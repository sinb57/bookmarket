package sinb57.bookmarket.service.book;

import sinb57.bookmarket.dto.book.BookDto;
import sinb57.bookmarket.dto.book.CategoryDto;
import sinb57.bookmarket.dto.book.BookSearchOptionDto;
import sinb57.bookmarket.mapper.book.BookMapper;
import sinb57.bookmarket.mapper.book.CategoryMapper;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final CategoryMapper categoryMapper;

    public BookServiceImpl(BookMapper bookMapper, CategoryMapper categoryMapper) {
        this.bookMapper = bookMapper;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void registerBook(BookDto book) {
        bookMapper.save(book);
    }

    @Override
    public BookDto getBookById(Long id) {
        Optional<BookDto> book = bookMapper.findById(id);
        // EXCEPTION
        return book.orElseThrow(() -> new IllegalStateException("도서를 찾을 수 없습니다."));
    }

    @Override
    public List<BookDto> getBookList() {
        return bookMapper.findAll();
    }

    @Override
    public List<BookDto> getBookList(BookSearchOptionDto searchOption) {
        return bookMapper.search(searchOption);
    }




    @Override
    public void registerCategory(CategoryDto categoryDto) {
        categoryMapper.save(categoryDto);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Optional<CategoryDto> category = categoryMapper.findById(id);
        // EXCEPTION
        return category.orElseThrow(() -> new IllegalStateException("카테고리를 찾을 수 없습니다."));
    }

    @Override
    public List<CategoryDto> getCategoryList() {
        return categoryMapper.findAll();
    }

}

