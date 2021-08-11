package sinb57.bookmarket.service.member;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sinb57.bookmarket.dto.member.MemberDto;
import sinb57.bookmarket.dto.member.MemberSearchOptionDto;

import java.util.List;

public interface MemberService extends UserDetailsService {

    void join(MemberDto member);

    MemberDto getMemberByEmail(String email);

    List<MemberDto> getMemeberList();

    List<MemberDto> getMemeberList(MemberSearchOptionDto memberSearchOption);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
