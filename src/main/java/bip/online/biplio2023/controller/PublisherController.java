package bip.online.biplio2023.controller;

import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.Genre;
import bip.online.biplio2023.service.Publisher;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/publisher")
@RequiredArgsConstructor
public class PublisherController {
    private final Publisher service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<Publisher>> getAll(){
        return ResponseEntity.ok(
                new ListResponse<Publisher>(true,"Список публикующих",service.findAll()));
    }
    @GetMapping ResponseEntity<DataResponse<Publisher>> by_id(@RequestParam Long id){
        return ResponseEntity.ok(
                new DataResponse<Publisher>(true,"Найден следующий публикующий", service.findById(id).orElseThrow()));
    }
    @PostMapping
    public ResponseEntity<DataResponse<Publisher>> save(@RequestBody Publisher publisher){
        return ResponseEntity.ok(
                new DataResponse<Publisher>(true, "Публикующий сохранён", service.save(publisher )));
    }
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody Publisher publisher) {
        service.update(publisher);
        return ResponseEntity.ok(
                new BaseResponse(true, "Публикующий сохранен"));

    }
}
