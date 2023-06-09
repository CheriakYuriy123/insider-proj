package fourthTaskAPI.pojo.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private long id;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("tags")
    private List<TagsItem> tags;

    @JsonProperty("status")
    private String status;
}