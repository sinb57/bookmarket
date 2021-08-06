package sinb57.bookmarket.mapper.book;

import org.apache.ibatis.annotations.Mapper;
import sinb57.bookmarket.dto.book.BookDto;

@Mapper
public interface BookMapper {

    void save(BookDto boot);

    BookDto findById(Long id);

}
