package sinb57.bookmarket.service.member;

import sinb57.bookmarket.dto.member.MemberDto;

public interface MemberService {

    void join(MemberDto member);

    MemberDto getMemberByEmail(String email);
}
