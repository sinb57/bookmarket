package sinb57.bookmarket.service.book;

import sinb57.bookmarket.dto.book.BookDto;
import sinb57.bookmarket.dto.book.CategoryDto;
import sinb57.bookmarket.dto.book.BookSearchOptionDto;
import sinb57.bookmarket.mapper.book.BookMapper;
import sinb57.bookmarket.mapper.book.CategoryMapper;

import java.util.List;

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
        return bookMapper.findById(id);
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
        return categoryMapper.findById(id);
    }

    @Override
    public List<CategoryDto> getCategoryList() {
        return categoryMapper.findAll();
    }
}
