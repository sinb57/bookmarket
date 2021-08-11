package sinb57.bookmarket.service.member;

import org.springframework.stereotype.Service;
import sinb57.bookmarket.dto.member.MemberDto;
import sinb57.bookmarket.mapper.member.MemberMapper;

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

}
