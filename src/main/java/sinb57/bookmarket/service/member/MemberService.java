package sinb57.bookmarket.service.member;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sinb57.bookmarket.dto.member.MemberDto;

public interface MemberService extends UserDetailsService {

    void join(MemberDto member);

    MemberDto getMemberByEmail(String email);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
