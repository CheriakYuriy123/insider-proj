package fourthTaskAPI.pojo.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private int id;
}
