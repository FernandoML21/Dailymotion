package aiss.dailymotionminer.controller;

import aiss.dailymotionminer.etl.Transformer;
import aiss.dailymotionminer.model.dailymotion.Channel;
import aiss.dailymotionminer.model.dailymotion.Video;
import aiss.dailymotionminer.model.videominer.VMChannel;
import aiss.dailymotionminer.model.videominer.VMVideo;
import aiss.dailymotionminer.service.CaptionService;
import aiss.dailymotionminer.service.ChannelService;
import aiss.dailymotionminer.service.CommentService;
import aiss.dailymotionminer.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "DailymotionMiner", description = "API para extraer datos de Dailymotion y enviarlos a VideoMiner")
@RestController
@RequestMapping("/dailymotion")
public class DailymotionController {

    @Autowired
    ChannelService channelService;

    @Autowired
    VideoService videoService;

    @Autowired
    CaptionService captionService;

    @Autowired
    CommentService commentService;

    @Autowired
    RestTemplate restTemplate;

    @Value("${videominer.base.url}")
    String videominerBaseUrl;

    @Operation(
            summary = "Previsualizar canal de Dailymotion",
            description = "Extrae y transforma los datos de un usuario (canal) de Dailymotion " +
                    "sin enviarlos a VideoMiner. Permite limitar el número de vídeos a procesar."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Canal obtenido y transformado correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado en Dailymotion")
    })
    @GetMapping("/{id}")
    public VMChannel getChannel(@PathVariable String id,
                                @RequestParam(value = "maxVideos", defaultValue = "10") int maxVideos) {

        Channel dmChannel = channelService.getChannel(id);
        List<Video> dmVideos = videoService.getVideos(id, maxVideos);

        for (Video video : dmVideos) {
            video.setCaptions(captionService.getCaptions(video.getId()));
            video.setComments(commentService.getComments(video.getId(), 10));
        }

        VMChannel vmChannel = Transformer.transformChannel(dmChannel);

        List<VMVideo> vmVideos = new ArrayList<>();
        for (Video video : dmVideos) {
            vmVideos.add(Transformer.transformVideo(video));
        }
        vmChannel.setVideos(vmVideos);

        return vmChannel;
    }


    @Operation(
            summary = "Extraer canal de Dailymotion y enviarlo a VideoMiner",
            description = "Realiza el proceso completo de minería: extrae datos de Dailymotion, " +
                    "los transforma al modelo común y los envía mediante POST a VideoMiner para su almacenamiento."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Canal procesado y creado con éxito en VideoMiner"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado en Dailymotion"),
            @ApiResponse(responseCode = "500", description = "Error al conectar con VideoMiner")
    })
    @PostMapping("/{id}")
    public VMChannel sendChannelToVideoMiner(@PathVariable String id,
                                             @RequestParam(value = "maxVideos", defaultValue = "10") int maxVideos) {

        VMChannel vmChannel = getChannel(id, maxVideos);
        VMChannel createdChannel = restTemplate.postForObject(videominerBaseUrl, vmChannel, VMChannel.class);

        return createdChannel;
    }
}