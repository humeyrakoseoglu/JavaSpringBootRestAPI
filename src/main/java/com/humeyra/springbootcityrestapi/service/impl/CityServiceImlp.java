package com.humeyra.springbootcityrestapi.service.impl;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.humeyra.springbootcityrestapi.model.CityModel;
import com.humeyra.springbootcityrestapi.repository.CityRepository;
import com.humeyra.springbootcityrestapi.service.CityService;

import lombok.RequiredArgsConstructor;
    
    @Service // proje ayağa kalkarken. Spring bu sınıftan bir instance oluşturrarak IoC'u içinde tutuyor. Servis olduğunu bildiriyoruz
    @RequiredArgsConstructor //constructor oluşturması için lombok kullanıyoruz
    public class CityServiceImlp implements CityService { 
        @Override
        public CityModel createCity(CityModel city) {
            city.setCreatedAt(new Date());
            city.setCreatedBy("Admin");
            return cityRepository.save(city);
        }
    
        //service üzerinde Repositorymize bağlanıyoruz
        private final CityRepository cityRepository;
    
        @Override
        public List<CityModel> getCities() {
           return cityRepository.findAll();
        }
    
        @Override
        public CityModel getCity(Long id) {
            Optional<CityModel> city = cityRepository.findById(id);//optional ile kayıt var mı yok mu diye kontrol yaptırıyoruz. util paketinden geliyor
            if(city.isPresent()){//kayıt varsa
                return city.get();
            }
            return null;
        }
    
        @Override
        public CityModel updateCity(Long id, CityModel city) {
            Optional<CityModel> resultCity = cityRepository.findById(id);//optional ile kayıt var mı yok mu diye kontrol yaptırıyoruz. util paketinden geliyor
            if(resultCity.isPresent()){//kayıt varsa
                resultCity.get().setName(city.getName());
                resultCity.get().setBaskan(city.getBaskan());
                resultCity.get().setNufus(city.getNufus());
                resultCity.get().setUpdatedAt(new Date());
                resultCity.get().setUpdatedBy("Admin");
            return cityRepository.save(resultCity.get());
            }
            return null;
        }
    
        @Override
        public Boolean deleteCity(Long id) {
            Optional<CityModel> city = cityRepository.findById(id);
            if(city.isPresent()){//kayıt varsa
                cityRepository.deleteById(id);
                return true;
            }
            return false;
        }
        
    }
    
