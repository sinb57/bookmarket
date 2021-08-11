package sinb57.bookmarket.dto.member;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;

@Alias("memberSearchOption")
@Getter
public class MemberSearchOptionDto {

    @NotNull
    private String keyword;

    @NotNull
    private String type;

    private int page;
    private int offset;

    @JsonCreator
    @Builder
    public MemberSearchOptionDto(@JsonProperty("keyword") String keyword,
                                 @JsonProperty("type") String type,
                                 @JsonProperty("page") int page,
                                 @JsonProperty("offset") int offset) {

        switch (type) {
            case "email":
                break;
            case "username":
                break;
            default:
                type = "email";
                break;
        }

        if (page == 0) {
            page = 1;
        }

        if (offset == 0) {
            offset = 12;
        }

        this.keyword = keyword;
        this.type = type;
        this.page = (page - 1) * offset;
        this.offset = offset;
    }


}
