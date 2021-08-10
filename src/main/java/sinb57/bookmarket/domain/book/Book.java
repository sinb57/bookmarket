package sinb57.bookmarket.domain.book;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Book {

    private Long id;
    private Long category_id;
    private String name;
    private int stock;
    private int price;

    @Builder
    public Book(Long id, Long category_id, String name, int stock, int price) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

}
