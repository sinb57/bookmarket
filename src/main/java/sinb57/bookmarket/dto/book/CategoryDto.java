package sinb57.bookmarket.dto.book;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

@Alias("category")
@Getter
public class CategoryDto {

    private Long id;
    private String name;

    @JsonCreator
    @Builder
    public CategoryDto(@JsonProperty("id") Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
