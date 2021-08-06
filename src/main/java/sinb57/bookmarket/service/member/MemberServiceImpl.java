package sinb57.bookmarket.service.member;

import org.springframework.stereotype.Service;
import sinb57.bookmarket.dto.member.MemberDto;
import sinb57.bookmarket.mapper.member.MemberMapper;

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
        return memberMapper.findByEmail(email);
    }
}
