package sinb57.bookmarket.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sinb57.bookmarket.dto.book.BookDto;
import sinb57.bookmarket.service.book.BookService;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String bookList(Model model) {
        List<BookDto> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);
        return "book/list";
    }

    @GetMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long bookId,
                           Model model) {
        BookDto book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "book/show";
    }


    @GetMapping("/books/register")
    public String registerBook() {
        return "book/register";
    }

    @PostMapping("/books/register")
    public String registerBook(@RequestBody BookDto bookDto) {
        return null;
    }

    @GetMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") String bookId) {
        return "book/update";
    }

    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") String bookId,
                             @RequestBody BookDto bookDto) {
        return null;
    }


    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") String bookId) {
        return null;
    }

}