package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/all")
    public ResponseEntity<ListResponse<CityEntity>> getAllCity(){
        return ResponseEntity.ok(
                new ListResponse<CityEntity>(true, "Список городов", cityService.findAll()));
    }
    @GetMapping
    public ResponseEntity<DataResponse<CityEntity>> by_id(@RequestParam Long id){
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Найден следующий город", cityService.findById(id).orElseThrow()));
    }
    @PostMapping
    public ResponseEntity<DataResponse<CityEntity>> save(@RequestBody CityEntity city) {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Город сохранён", cityService.save(city)));
    }
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody CityEntity city) {
        cityService.update(city);
        return ResponseEntity.ok(
                new BaseResponse(true, "Город обновлен"));
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        cityService.deleteById(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Город уничтожен"));
    }


}



