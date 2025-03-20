package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.GenreEntity;
import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/genre")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<GenreEntity>> getAllGenres(){
        return ResponseEntity.ok(
                new ListResponse<GenreEntity>(true,"Список жанров", genreService.findAll()));
    }
    @GetMapping
    public ResponseEntity<DataResponse<GenreEntity>> by_id(@RequestParam Long id){
        return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true, "Найден следующий жанр", genreService.findById(id).orElseThrow()));
    }
    @PostMapping
    public ResponseEntity<DataResponse<GenreEntity>> save(@RequestBody GenreEntity genre){
        return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true,"Жанр сохранён", genreService.save(genre)));
    }
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody GenreEntity genre) {
        genreService.update(genre);
        return ResponseEntity.ok(
                new BaseResponse(true, "Жанр обновлен"));
    }
    @DeleteMapping
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        genreService.deleteById(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Жанр удален"));
    }
}
