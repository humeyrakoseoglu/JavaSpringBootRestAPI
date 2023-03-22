package com.humeyra.springbootcityrestapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "SEHIRLER")
@Data//getter setterları otomatik oluşturuyor ya da  @Getter @Setter olarak da ekleyebilirsin lombok sayesinde
public class CityModel extends BaseModel { //baseentitydeki fieldları kendine miras olarak aldı
    @Id
    @SequenceGenerator(name="city_seq_gen",sequenceName = "city_gen", initialValue = 1, allocationSize = 1)//Generated valuedeki alanı değiştirmek için
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//sırayla arttır
    @Column(name="ID")
    private Long id;
    @Column(name="ISIM", length = 100)
    private String name;
    @Column(name="BASKAN", length = 100)
    private String baskan;
    @Column(name="NUFUS")
    private Double nufus;
}
