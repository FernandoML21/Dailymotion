package aiss.dailymotionminer.model.dailymotion;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "screenname",
        "url",
        "avatar_120_url"
})
@Generated("jsonschema2pojo")
public class User {

    @JsonProperty("id")
    private String id;
    @JsonProperty("screenname")
    private String screenname;
    @JsonProperty("url")
    private String url;
    @JsonProperty("avatar_120_url")
    private String avatar120Url;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("screenname")
    public String getScreenname() {
        return screenname;
    }

    @JsonProperty("screenname")
    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("avatar_120_url")
    public String getAvatar120Url() {
        return avatar120Url;
    }

    @JsonProperty("avatar_120_url")
    public void setAvatar120Url(String avatar120Url) {
        this.avatar120Url = avatar120Url;
    }

}