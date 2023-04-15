package fourthTaskAPI.pojo.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class PetBuilder {

    @Builder.Default
    @JsonProperty("photoUrls")
    private List<String> photoUrls = Arrays.asList("url1", "url2");

    @Builder.Default
    @JsonProperty("name")
    private String name = "Buba";

    @Builder.Default
    @JsonProperty("id")
    private int id = 12345678;

    @Builder.Default
    @JsonProperty("category")
    private Category category = new Category("Cat", 1);

    @Builder.Default
    @JsonProperty("tags")
    private List<TagsItem> tags = Arrays.asList(new TagsItem("tag1", 1));

    @Builder.Default
    @JsonProperty("status")
    private String status = "available";
}
