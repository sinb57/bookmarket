package sinb57.bookmarket.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sinb57.bookmarket.dto.member.MemberDto;
import sinb57.bookmarket.service.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("회원가입 및 회원조회 테스트")
    @Transactional
    void saveAndFindTest() {

        // given
        String email1 = "email1";
        String username1 = "username1";
        String password1 = "password1";

        String email2 = "email2";
        String username2 = "username2";
        String password2 = "password2";

        MemberDto member1 = createMember(email1, username1, password1);
        MemberDto member2 = createMember(email2, username2, password2);

        // when
        memberService.join(member1);
        memberService.join(member2);

        // then
        MemberDto searchedMember1 = memberService.findByEmail(email1);
        MemberDto searchedMember2 = memberService.findByEmail(email2);

        assertThat(searchedMember1.getEmail()).isEqualTo(email1);
        assertThat(searchedMember1.getUsername()).isEqualTo(username1);
        assertThat(searchedMember1.getPassword()).isEqualTo(password1);

        assertThat(searchedMember2.getEmail()).isEqualTo(email2);
        assertThat(searchedMember2.getUsername()).isEqualTo(username2);
        assertThat(searchedMember2.getPassword()).isEqualTo(password2);
    }

    private MemberDto createMember(String email, String username, String password) {
        return MemberDto.builder()
                .email(email)
                .username(username)
                .password(password)
                .build();
    }
}
