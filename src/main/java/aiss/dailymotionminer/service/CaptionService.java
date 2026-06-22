package aiss.dailymotionminer.service;

import aiss.dailymotionminer.model.dailymotion.Caption;
import aiss.dailymotionminer.model.dailymotion.CaptionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaptionService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${dailymotion.api.base.url}")
    private String dailymotionBaseUri;

    public List<Caption> getCaptions(String videoId) {
        String url = dailymotionBaseUri + "/video/" + videoId + "/subtitles?fields=id,language,url";

        try {
            CaptionSearch search = restTemplate.getForObject(url, CaptionSearch.class);
            // Revisa si en tu CaptionSearch el getter es getData(), getList() o getCaptions()
            // y cámbialo aquí si es necesario:
            if (search != null && search.getCaption() != null) {
                return search.getCaption();
            }
        } catch (Exception e) {
            // Si el vídeo no tiene subtítulos, devolvemos lista vacía sin romper el programa
            System.out.println("Sin subtítulos para el vídeo: " + videoId);
        }
        return new ArrayList<>();
    }
}