package bip.online.biplio2023.controller;

import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;

import bip.online.biplio2023.service.Genre;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/genre")
@RequiredArgsConstructor
public class GenreController {
    private final Genre service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<Genre>> getAll(){
        return ResponseEntity.ok(
                new ListResponse<Genre>(true,"Список genre",service.findAll()));
    }
    @GetMapping ResponseEntity<DataResponse<Genre>> by_id(@RequestParam Long id){
        return ResponseEntity.ok(
                new DataResponse<Genre>(true,"Найден следующий genre", service.findById(id).orElseThrow()));
    }
    @PostMapping
    public ResponseEntity<DataResponse<Genre>> save(@RequestBody Genre genre){
        return ResponseEntity.ok(
                new DataResponse<Genre>(true, "Genre сохранён", service.save(genre)));
    }
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody Genre genre) {
        service.update(genre);
        return ResponseEntity.ok(
                new BaseResponse(true, "Genre сохранен"));

    }
}
