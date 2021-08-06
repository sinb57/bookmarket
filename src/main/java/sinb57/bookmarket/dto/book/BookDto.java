package sinb57.bookmarket.dto.book;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BookDto {

    private Long id;
    private Long category_id;
    private String name;
    private String description;
    private int stock;
    private int price;

    @Builder
    public BookDto(Long id, Long category_id, String name, String description, int stock, int price) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

}
