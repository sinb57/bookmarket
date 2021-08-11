package sinb57.bookmarket.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;
import sinb57.bookmarket.dto.member.MemberDto;
import java.util.Optional;

@Alias("member")
@Mapper
public interface MemberMapper {

    void save(MemberDto member);

    Optional<MemberDto> findByEmail(String email);

}
