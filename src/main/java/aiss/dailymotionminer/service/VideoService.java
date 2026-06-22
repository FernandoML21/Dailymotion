package aiss.dailymotionminer.service;

import aiss.dailymotionminer.model.dailymotion.Video;
import aiss.dailymotionminer.model.dailymotion.VideoSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${dailymotion.api.base.url}")
    private String dailymotionBaseUri;

    public List<Video> getVideos(String channelId, int maxVideos) {
        String url = dailymotionBaseUri + "/user/" + channelId + "/videos?fields=id,title,description,created_time,tags,thumbnail_url,thumbnail_240_url&limit=" + maxVideos;
        VideoSearch search = restTemplate.getForObject(url, VideoSearch.class);

        // Usamos getVideo() porque así se llama el getter en la clase que me pasaste
        if (search != null && search.getVideo() != null) {
            return search.getVideo();
        }
        return new ArrayList<>();
    }
}