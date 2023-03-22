package com.humeyra.springbootcityrestapi.service;

import java.util.List;

import com.humeyra.springbootcityrestapi.model.CityModel;


public interface CityService { // katmanlar arası bağlantılar interfaceler üzerinden olduğu için
    CityModel createCity(CityModel city); // default olarak public abstract zaten tanımlamaya gerek yok tekrardan
    List<CityModel> getCities();
    CityModel getCity(Long id);
    CityModel updateCity(Long id, CityModel city);
    Boolean deleteCity(Long id);
}


