package sinb57.bookmarket.dto.member;

import lombok.Builder;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

@Alias("member")
@Getter
public class MemberDto {

    private String email;
    private String username;
    private String password;

    @Builder
    public MemberDto(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
