package bip.online.biplio2023.controller;


import bip.online.biplio2023.entity.BookEntity;
import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<BookEntity>> getAllBooks(){
        return ResponseEntity.ok(
                new ListResponse<BookEntity>(true, "Список книг", bookService.findAll()));
    }
    @GetMapping
    public ResponseEntity<DataResponse<BookEntity>> by_id(@RequestParam Long id){
        return ResponseEntity.ok(
                new DataResponse<BookEntity>(true, "Найдена следующая книга", bookService.findById(id).orElseThrow()));
    }
    @PostMapping
    public ResponseEntity<DataResponse<BookEntity>> save(@RequestBody BookEntity book) {
        return ResponseEntity.ok(
                new DataResponse<BookEntity>(true, "Книга сохранена", bookService.save(book)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity book) {
        bookService.update(book);
        return ResponseEntity.ok(
                new BaseResponse(true, "Книга обновлена"));
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Книга удалена"));
    }
}
