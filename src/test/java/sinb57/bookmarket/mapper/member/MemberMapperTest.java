package sinb57.bookmarket.mapper.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sinb57.bookmarket.domain.member.Member;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

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

        Member member1 = createMember(email1, username1, password1);
        Member member2 = createMember(email2, username2, password2);

        // when
        memberMapper.save(member1);
        memberMapper.save(member2);

        // then
        Member searchedMember1 = memberMapper.findByEmail(email1);
        Member searchedMember2 = memberMapper.findByEmail(email2);

        assertThat(searchedMember1.getEmail()).isEqualTo(email1);
        assertThat(searchedMember1.getUsername()).isEqualTo(username1);
        assertThat(searchedMember1.getPassword()).isEqualTo(password1);

        assertThat(searchedMember2.getEmail()).isEqualTo(email2);
        assertThat(searchedMember2.getUsername()).isEqualTo(username2);
        assertThat(searchedMember2.getPassword()).isEqualTo(password2);
    }

    private Member createMember(String email, String username, String password) {
        return Member.builder()
                .email(email)
                .username(username)
                .password(password)
                .build();
    }
}
