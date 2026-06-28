package aiss.dailymotionminer.model.videominer; // o aiss.dailymotionminer.model.videominer

import com.fasterxml.jackson.annotation.JsonProperty;

public class VMThumbnail {

    @JsonProperty("url")
    private String url;

    @JsonProperty("size_type")
    private String sizeType;

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getSizeType() { return sizeType; }
    public void setSizeType(String sizeType) { this.sizeType = sizeType; }
}
