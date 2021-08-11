package sinb57.bookmarket.mapper.book;

import org.apache.ibatis.annotations.Mapper;
import sinb57.bookmarket.dto.book.BookDto;
import sinb57.bookmarket.dto.book.BookSearchOptionDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BookMapper {

    void save(BookDto boot);

    Optional<BookDto> findById(Long id);

    List<BookDto> findAll();

    List<BookDto> search(BookSearchOptionDto searchOption);
}
