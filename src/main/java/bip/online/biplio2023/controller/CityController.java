package bip.online.biplio2023.controller;

import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.Author;
import bip.online.biplio2023.service.City;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/city")
@RequiredArgsConstructor
public class CityController {
    private final City service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<City>> getAll(){
        return ResponseEntity.ok(
                new ListResponse<>(true, "Список городов", service.findAll()));
    }
    @GetMapping
    public ResponseEntity<DataResponse<City>> by_id(@RequestParam Long id){
        return ResponseEntity.ok(
                new DataResponse<City>(true, "Найден следующий город", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<City>> save (@RequestBody City city){
        return ResponseEntity.ok(
                new DataResponse<City>(true,"Город сохранён", service.save(city)));
    }
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody City city){
        service.update(city);
        return ResponseEntity.ok(
                new BaseResponse(true,"Город сохранён"));
    }

}
