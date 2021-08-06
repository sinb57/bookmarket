package sinb57.bookmarket.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import sinb57.bookmarket.domain.member.Member;

@Mapper
public interface MemberMapper {

    void save(Member member);

    Member findByEmail(String email);

}
