package sinb57.bookmarket.domain.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

    private Long id;
    private String email;
    private String username;
    private String password;

    @Builder
    public Member(Long id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

}