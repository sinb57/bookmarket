package sinb57.bookmarket.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;
import sinb57.bookmarket.dto.member.MemberDto;

@Alias("member")
@Mapper
public interface MemberMapper {

    void save(MemberDto member);

    MemberDto findByEmail(String email);

}
