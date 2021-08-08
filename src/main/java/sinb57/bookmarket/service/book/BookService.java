package sinb57.bookmarket.service.book;

import sinb57.bookmarket.dto.book.BookDto;
import sinb57.bookmarket.dto.book.CategoryDto;

import java.util.List;

public interface BookService {

    void registerBook(BookDto book);

    BookDto getBookById(Long id);

    List<BookDto> getBookList();

    void registerCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getCategoryList();
}
