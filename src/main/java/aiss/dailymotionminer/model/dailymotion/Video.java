package aiss.dailymotionminer.model.dailymotion;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "title",
        "description",
        "created_time",
        "tags",
        "thumbnail_url",      // ← añadido
        "thumbnail_240_url"   // ← añadido
})
@Generated("jsonschema2pojo")
public class Video {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("created_time")
    private Integer createdTime;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    @JsonProperty("thumbnail_240_url")
    private String thumbnail240Url;

    @JsonIgnore
    private List<Comment> comments;

    @JsonIgnore
    private List<Caption> captions;

    @JsonProperty("id")
    public String getId() { return id; }

    @JsonProperty("id")
    public void setId(String id) { this.id = id; }

    @JsonProperty("title")
    public String getTitle() { return title; }

    @JsonProperty("title")
    public void setTitle(String title) { this.title = title; }

    @JsonProperty("description")
    public String getDescription() { return description; }

    @JsonProperty("description")
    public void setDescription(String description) { this.description = description; }

    @JsonProperty("created_time")
    public Integer getCreatedTime() { return createdTime; }

    @JsonProperty("created_time")
    public void setCreatedTime(Integer createdTime) { this.createdTime = createdTime; }

    @JsonProperty("tags")
    public List<String> getTags() { return tags; }

    @JsonProperty("tags")
    public void setTags(List<String> tags) { this.tags = tags; }

    // ← getters y setters nuevos para thumbnail
    @JsonProperty("thumbnail_url")
    public String getThumbnailUrl() { return thumbnailUrl; }

    @JsonProperty("thumbnail_url")
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }

    @JsonProperty("thumbnail_240_url")
    public String getThumbnail240Url() { return thumbnail240Url; }

    @JsonProperty("thumbnail_240_url")
    public void setThumbnail240Url(String thumbnail240Url) { this.thumbnail240Url = thumbnail240Url; }

    @JsonIgnore
    public List<Comment> getComments() { return comments; }

    @JsonIgnore
    public void setComments(List<Comment> comments) { this.comments = comments; }

    @JsonIgnore
    public List<Caption> getCaptions() { return captions; }

    @JsonIgnore
    public void setCaptions(List<Caption> captions) { this.captions = captions; }
}