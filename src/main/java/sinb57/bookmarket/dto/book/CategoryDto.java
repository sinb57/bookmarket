package sinb57.bookmarket.dto.book;

import lombok.Builder;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

@Alias("category")
@Getter
public class CategoryDto {

    private Long id;
    private String name;

    @Builder
    public CategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
