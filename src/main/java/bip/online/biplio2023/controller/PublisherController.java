package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.entity.PublisherEntity;
import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/publisher")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<PublisherEntity>> getAllPublishers() {
        return ResponseEntity.ok(
                new ListResponse<PublisherEntity>(true, "Список издатель", publisherService.findAll()));
    }
    @GetMapping
    public ResponseEntity<DataResponse<PublisherEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<PublisherEntity>(true, "Найден следующий издатель", publisherService.findById(id).orElseThrow()));
    }

    @PostMapping
        public ResponseEntity<DataResponse<PublisherEntity>> save(@RequestBody PublisherEntity publisher) {
        return ResponseEntity.ok(
                new DataResponse<PublisherEntity>(true, "Издатель сохранен", publisherService.save(publisher)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity publisher) {
        publisherService.update(publisher);
        return ResponseEntity.ok(
                new BaseResponse(true, "Издатель обновлен"));
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        publisherService.deleteById(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Издатель удален"));
    }
}
