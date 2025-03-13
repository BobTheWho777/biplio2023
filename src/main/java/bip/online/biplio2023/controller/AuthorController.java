package bip.online.biplio2023.controller;

import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.Author;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/author")
@RequiredArgsConstructor
public class AuthorController {
    private final Author service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<Author>> getAll(){
        return ResponseEntity.ok(
                new ListResponse<Author>(true, "Список акторов", service.findAll()));
    }
    @GetMapping
    public ResponseEntity<DataResponse<Author>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<Author>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<Author>> save(@RequestBody Author author) {
        return ResponseEntity.ok(
                new DataResponse<Author>(true, "Автор сохранен", service.save(author)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody Author author) {
        service.update(author);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор сохранен"));

    }
}
