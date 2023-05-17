package com.boniewijaya2021.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tbl_produksi", schema = "sample")
public class TblProduksi implements Serializable {

//    private static final long serialversionID = 1L;

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product)id", nullable = false)
    private Long id;
    @Column(name = "product_name", nullable = false)
    private String name;

//    public Produksi(Long id, String name){
//        this.id = id;
//        this.name = name;
//    }
}
