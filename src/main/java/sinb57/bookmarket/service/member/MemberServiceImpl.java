package sinb57.bookmarket.service.member;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sinb57.bookmarket.dto.member.MemberDto;
import sinb57.bookmarket.dto.member.MemberSearchOptionDto;
import sinb57.bookmarket.mapper.member.MemberMapper;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public void join(MemberDto member) {
        memberMapper.save(member);
    }

    @Override
    public MemberDto getMemberByEmail(String email) {
        Optional<MemberDto> member = memberMapper.findByEmail(email);
        // EXCEPTION
        return member.orElseThrow(() -> new IllegalStateException("회원을 찾을 수 없습니다."));
    }

    @Override
    public List<MemberDto> getMemeberList() {
        return memberMapper.findAll();
    }

    @Override
    public List<MemberDto> getMemeberList(MemberSearchOptionDto memberSearchOption) {
        return memberMapper.search(memberSearchOption);
    }

    @Override
    public MemberDto loadUserByUsername(String email) throws UsernameNotFoundException {
        return getMemberByEmail(email);
    }
}
