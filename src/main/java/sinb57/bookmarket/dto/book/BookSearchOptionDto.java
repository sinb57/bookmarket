package sinb57.bookmarket.dto.book;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

@Alias("bookSearchOption")
@Getter
public class BookSearchOptionDto {

    private String keyword;
    private int page;
    private int offset;

    @JsonCreator
    @Builder
    public BookSearchOptionDto(@JsonProperty("keyword") String keyword,
                               @JsonProperty("page") int page,
                               @JsonProperty("offset") int offset) {

        if (page == 0) {
            page = 1;
        }

        if (offset == 0) {
            offset = 12;
        }

        this.keyword = keyword;
        this.page = (page - 1) * offset;
        this.offset = offset;
    }


}
