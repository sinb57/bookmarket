package sinb57.bookmarket.mapper.book;

import org.apache.ibatis.annotations.Mapper;
import sinb57.bookmarket.dto.book.CategoryDto;

import java.util.List;

@Mapper
public interface CategoryMapper {

    void save(CategoryDto category);

    CategoryDto findById(Long id);

    List<CategoryDto> findAll();
    
}
