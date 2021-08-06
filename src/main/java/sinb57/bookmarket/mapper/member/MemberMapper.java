package sinb57.bookmarket.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import sinb57.bookmarket.dto.member.MemberDto;

@Mapper
public interface MemberMapper {

    void save(MemberDto member);

    MemberDto findByEmail(String email);

}
