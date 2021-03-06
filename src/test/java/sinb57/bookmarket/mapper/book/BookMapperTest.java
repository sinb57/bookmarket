package sinb57.bookmarket.mapper.book;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sinb57.bookmarket.dto.book.BookDto;
import sinb57.bookmarket.dto.book.BookSearchOptionDto;
import sinb57.bookmarket.dto.book.CategoryDto;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    @DisplayName("카테고리 추가 기능 테스트")
    @Transactional
    void saveCategoryTest() {

        for (int i=0; i<10; i++) {
            String categoryName = "categoryName" + i;
            CategoryDto category = CategoryDto.builder()
                    .name(categoryName).build();

            categoryMapper.save(category);
        }


        List<CategoryDto> result = categoryMapper.findAll();

        for (int i=0; i<10; i++) {
            String categoryName = "cateogoryName" + i;
            CategoryDto searchedCategory = result.get(i);

            assertThat(searchedCategory.getName()).isEqualTo("categoryName" + i);

        }

    }

    @Test
    @DisplayName("도서 추가 기능 테스트")
    @Transactional
    void saveBookTest() {

        Optional<BookDto> book1 = bookMapper.findById(1L);

        assertTrue(book1.isPresent());

        assertThat(book1.get().getName()).isEqualTo("꼭두각시 살인사건");
    }


    @Test
    @DisplayName("도서 검색 기능 테스트")
    void searchBookTest() {

        BookSearchOptionDto searchOption =
                BookSearchOptionDto.builder()
                        .keyword("파랑")
                        .page(0)
                        .offset(0)
                        .build();

        BookDto book = bookMapper.search(searchOption).get(0);

        assertThat(book.getName()).isEqualTo("천 개의 파랑");
    }
}
