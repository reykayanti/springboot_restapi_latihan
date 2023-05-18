package com.boniewijaya2021.springboot.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class ProduksiPojo {
    private String idProduksi;
    private String asalBarang;
    private Integer biayaProduksi;
    private String namaBarang;
    private Timestamp tanggalProduksi;
    private String tipeBarang;
}
