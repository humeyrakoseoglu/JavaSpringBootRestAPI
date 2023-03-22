package com.humeyra.springbootcityrestapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.humeyra.springbootcityrestapi.model.CityModel;

// @Repository // bu anotasyona gerek yok extends ettiğimiz için Spring zaten repository katmanı olduğunu anlıyor otomatik
public interface CityRepository extends JpaRepository<CityModel,Long>{ //sorgu için kolay hazır metotlar var 
    // hazır metotlarda yoksa bu özellik nasıl yaparız, nasıl özelleştiririz
//    CityModel findByFirstName(String firstName);
//    //ya da bunun için sorgu yazabiliriz @Query anotasyonu ile
//    @Query("")
//    CityModel getCity();

}

