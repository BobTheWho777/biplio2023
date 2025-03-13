package bip.online.biplio2023.controller;

import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.Book;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final Book service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<Book>> getAll(){
        return ResponseEntity.ok(
                new ListResponse<Book>(true,"Список книг", service.findAll()));
    }
    @GetMapping
    public ResponseEntity<DataResponse<Book>> by_id(@RequestParam Long id){
        return ResponseEntity.ok(
                new DataResponse<Book>(true,"Найден следующая книга", service.findById(id).orElseThrow()));
    }
    @PostMapping
    public ResponseEntity<DataResponse<Book>> save(@RequestBody Book book) {
        return ResponseEntity.ok(
                new DataResponse<Book>(true, "Книга сохранена", service.save(book)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody Book book) {
        service.update(book);
        return ResponseEntity.ok(
                new BaseResponse(true, "Книга сохранена"));

    }
}
