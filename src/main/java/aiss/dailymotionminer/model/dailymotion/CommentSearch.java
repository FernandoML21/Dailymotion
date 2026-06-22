package aiss.dailymotionminer.model.dailymotion;

import java.util.LinkedHashMap;
import java.util.List;
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
        "total",
        "data",
        "totalNotDeletedComments"
})
@Generated("jsonschema2pojo")
public class CommentSearch {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("data")
    private List<Comment> comment;
    @JsonProperty("totalNotDeletedComments")
    private Integer totalNotDeletedComments;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("comment")
    public List<Comment> getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @JsonProperty("totalNotDeletedComments")
    public Integer getTotalNotDeletedComments() {
        return totalNotDeletedComments;
    }

    @JsonProperty("totalNotDeletedComments")
    public void setTotalNotDeletedComments(Integer totalNotDeletedComments) {
        this.totalNotDeletedComments = totalNotDeletedComments;
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
