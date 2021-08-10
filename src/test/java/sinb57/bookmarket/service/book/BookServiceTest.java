package sinb57.bookmarket.service.book;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sinb57.bookmarket.dto.book.BookDto;
import sinb57.bookmarket.dto.book.CategoryDto;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("카테고리 추가 기능 테스트")
    @Transactional
    void saveCategoryTest() {

        for (int i=0; i<10; i++) {
            String categoryName = "categoryName" + i;
            CategoryDto category = CategoryDto.builder()
                    .name(categoryName).build();

            bookService.registerCategory(category);
        }


        List<CategoryDto> result = bookService.getCategoryList();

        for (int i=0; i<10; i++) {
            String categoryName = "cateogoryName" + i;
            CategoryDto searchedCategory = result.get(i);

            Assertions.assertThat(searchedCategory.getName()).isEqualTo("categoryName" + i);

        }

    }

    @Test
    @DisplayName("도서 추가 기능 테스트")
    @Transactional
    void saveBookTest() {

        CategoryDto category = CategoryDto.builder()
                .name("categoryName").build();

        bookService.registerCategory(category);


        BookDto book = BookDto.builder()
                .category_id(1L).name("도서1")
                .stock(10).price(10000)
                .build();

        bookService.registerBook(book);

        BookDto book1 = bookService.getBookById(1L);

        Assertions.assertThat(book1.getName()).isEqualTo("도서1");
    }
}
