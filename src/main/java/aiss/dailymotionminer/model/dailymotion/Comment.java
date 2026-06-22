package aiss.dailymotionminer.model.dailymotion;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "url",
        "text",
        "threadId",
        "inReplyToCommentId",
        "videoId",
        "createdAt",
        "updatedAt",
        "deletedAt",
        "heldForReview",
        "isDeleted",
        "totalRepliesFromVideoAuthor",
        "totalReplies",
        "account"
})
@Generated("jsonschema2pojo")
public class Comment {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;
    @JsonProperty("threadId")
    private Integer threadId;
    @JsonProperty("inReplyToCommentId")
    private Object inReplyToCommentId;
    @JsonProperty("videoId")
    private Integer videoId;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("deletedAt")
    private String deletedAt;
    @JsonProperty("heldForReview")
    private Boolean heldForReview;
    @JsonProperty("isDeleted")
    private Boolean isDeleted;
    @JsonProperty("totalRepliesFromVideoAuthor")
    private Integer totalRepliesFromVideoAuthor;
    @JsonProperty("totalReplies")
    private Integer totalReplies;
    @JsonProperty("account")
    private User user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("threadId")
    public Integer getThreadId() {
        return threadId;
    }

    @JsonProperty("threadId")
    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    @JsonProperty("inReplyToCommentId")
    public Object getInReplyToCommentId() {
        return inReplyToCommentId;
    }

    @JsonProperty("inReplyToCommentId")
    public void setInReplyToCommentId(Object inReplyToCommentId) {
        this.inReplyToCommentId = inReplyToCommentId;
    }

    @JsonProperty("videoId")
    public Integer getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("deletedAt")
    public String getDeletedAt() {
        return deletedAt;
    }

    @JsonProperty("deletedAt")
    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    @JsonProperty("heldForReview")
    public Boolean getHeldForReview() {
        return heldForReview;
    }

    @JsonProperty("heldForReview")
    public void setHeldForReview(Boolean heldForReview) {
        this.heldForReview = heldForReview;
    }

    @JsonProperty("isDeleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("isDeleted")
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonProperty("totalRepliesFromVideoAuthor")
    public Integer getTotalRepliesFromVideoAuthor() {
        return totalRepliesFromVideoAuthor;
    }

    @JsonProperty("totalRepliesFromVideoAuthor")
    public void setTotalRepliesFromVideoAuthor(Integer totalRepliesFromVideoAuthor) {
        this.totalRepliesFromVideoAuthor = totalRepliesFromVideoAuthor;
    }

    @JsonProperty("totalReplies")
    public Integer getTotalReplies() {
        return totalReplies;
    }

    @JsonProperty("totalReplies")
    public void setTotalReplies(Integer totalReplies) {
        this.totalReplies = totalReplies;
    }

    @JsonProperty("account")
    public User getUser() {
        return user;
    }

    @JsonProperty("account")
    public void setAccount(User user) {
        this.user = user;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
