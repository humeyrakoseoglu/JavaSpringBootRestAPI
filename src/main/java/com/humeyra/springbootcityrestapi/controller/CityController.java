package com.humeyra.springbootcityrestapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humeyra.springbootcityrestapi.model.CityModel;
import com.humeyra.springbootcityrestapi.service.CityService;

    @RestController // API'yı dışarı açmak için bu anotasyonu kullandık
    @RequestMapping("/city")//yayınlanacağı adres. city'e istek gelince CityController karşılasın diyoruz
    public class CityController {
       //  @Autowired // bu anotasyonla city servisin referansını controller içindekiproperty'e enjekte ediyoruz.
       // private CityService cityService;
       //üstteki yerine final(runtimede çalışırken property'e atama yapılmaması için ) diyip parametreli constructor oluşturarak d bunu yapabiliriz
    
       private final CityService cityService;
       
       public CityController(CityService cityService){
        this.cityService = cityService;
       }
    
       //PostMapping anotasyonu
       @PostMapping("/create")
       public ResponseEntity<CityModel> createCity(@RequestBody CityModel city){//metodun dönüş tipi CityModel. @RequestBody anotasyonu ile json nesnemizi cityModel sınıfı ile eşleştirmeyi sağlıyoruz
        CityModel resultCity = cityService.createCity(city);
          return ResponseEntity.ok(resultCity);
       }
    
       //GetMapping Anotasyonu
       @GetMapping("/getAll")
       public ResponseEntity<List<CityModel>> getCities(){
          List<CityModel> cities = cityService.getCities();
          return ResponseEntity.ok(cities);// ResponseEntity.ok() HTTP 200e denk geliyor
       }
    
       @GetMapping("/getById/{id}")
       public ResponseEntity<CityModel> getCity(@PathVariable Long id){
        CityModel city = cityService.getCity(id);
          return ResponseEntity.ok(city);// ResponseEntity.ok() HTTP 200e denk geliyor
       }
    
       //PutMapping Anotasyonu
       @PutMapping("/edit/{id}")
       public ResponseEntity<CityModel> updateCity(@PathVariable("id") Long id,@RequestBody CityModel city){ //var olan kaydı güncelle
        CityModel resultCity = cityService.updateCity(id,city);
          return ResponseEntity.ok(resultCity);
       }
    
       //DeleteMapping Anotasyonu
       @DeleteMapping("/remove/{cityId}")
       public ResponseEntity<Boolean> deleteCity(@PathVariable("cityId") Long id){
          Boolean status = cityService.deleteCity(id);
          return ResponseEntity.ok(status);
    
       }
    
    }
    
