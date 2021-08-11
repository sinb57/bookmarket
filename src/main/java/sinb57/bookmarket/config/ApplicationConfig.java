package sinb57.bookmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sinb57.bookmarket.mapper.book.BookMapper;
import sinb57.bookmarket.mapper.book.CategoryMapper;
import sinb57.bookmarket.mapper.member.MemberMapper;
import sinb57.bookmarket.service.book.BookService;
import sinb57.bookmarket.service.book.BookServiceImpl;
import sinb57.bookmarket.service.member.MemberService;
import sinb57.bookmarket.service.member.MemberServiceImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public WebSecurityConfig webSecurityConfig(MemberService memberService) {
        return new WebSecurityConfig(memberService);
    }

    @Bean
    public MemberService memberService(MemberMapper memberMapper) {
        return new MemberServiceImpl(memberMapper);
    }

    @Bean
    public BookService bookService(BookMapper bookMapper, CategoryMapper categoryMapper) {
        return new BookServiceImpl(bookMapper, categoryMapper);
    }
}
