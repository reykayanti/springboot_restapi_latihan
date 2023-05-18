package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.entity.TblProduksi;
import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.service.ProduksiService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/produksi")
public class ProduksiController {

    @Autowired
    private ProduksiService produksiService;

    @GetMapping("/get/produksi")
    public ResponseEntity getDataProduksi(@RequestParam UUID idProduksi){
        ResponseEntity responseEntity = produksiService.getDataProduksi(idProduksi);
        return responseEntity;
    }

    @PostMapping("/post/produksi")
    public ResponseEntity addDataProduksi(@RequestBody TblProduksi tblProduksi){
        ResponseEntity responseEntity = produksiService.addDataProduksi(tblProduksi);
        return responseEntity;
    }

    @PostMapping("/delete/produksi")
    public ResponseEntity deleteDataProduksi(@RequestParam UUID idProduksi){
        ResponseEntity responseEntity = produksiService.deleteDataProduksi(idProduksi);
        return  responseEntity;
    }


}
