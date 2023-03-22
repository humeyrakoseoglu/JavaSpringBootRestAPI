package com.humeyra.springbootcityrestapi.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;


@MappedSuperclass //base model extends eden tüm sınıflarda bu özellikler olacak

@Data
public class BaseModel implements Serializable{ //nesnemizi networkten taşıyabilme yetisi kazandırıyoruz
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
    
}
