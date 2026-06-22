package aiss.dailymotionminer.service;

import aiss.dailymotionminer.model.dailymotion.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${dailymotion.api.base.url}")
    private String dailymotionBaseUri;

    public Channel getChannel(String id) {
        String url = dailymotionBaseUri + "/user/" + id + "?fields=id,screenname,description,created_time";
        return restTemplate.getForObject(url, Channel.class);
    }
}