package sinb57.bookmarket.dto.book;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Alias("book")
@Getter
@ToString
public class BookDto {

    private Long id;
    private Long category_id;
    private String name;
    private int stock;
    private int price;

    @JsonCreator
    @Builder
    public BookDto(@JsonProperty("id") Long id,
                   @JsonProperty("category") Long category_id,
                   @JsonProperty("name") String name,
                   @JsonProperty("stock") int stock,
                   @JsonProperty("price") int price) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

}
