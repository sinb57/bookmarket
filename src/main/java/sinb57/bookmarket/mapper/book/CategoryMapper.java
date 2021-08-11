package sinb57.bookmarket.mapper.book;

import org.apache.ibatis.annotations.Mapper;
import sinb57.bookmarket.dto.book.CategoryDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CategoryMapper {

    void save(CategoryDto category);

    Optional<CategoryDto> findById(Long id);

    List<CategoryDto> findAll();
    
}
