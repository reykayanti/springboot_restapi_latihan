package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblProduksi;
import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.pojo.PenjualanPojo;
import com.boniewijaya2021.springboot.pojo.ProduksiPojo;
import com.boniewijaya2021.springboot.repository.ProdukRepositoryClass;
import com.boniewijaya2021.springboot.repository.ProduksiRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProduksiService {

    @Autowired
    private ProduksiRepository produksiRepository;

    @Autowired
    private ProdukRepositoryClass produkRepositoryClass;

    public ResponseEntity getDataProduksi(UUID idProduksi){
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try{
            TblProduksi data = produksiRepository.getProduksiById(idProduksi);
            if(data.getId_produksi() == null){
                msg.setStatus(true);
                msg.setMessage("Data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Success");
                result.put("data", data);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }
        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);

        }
    }

    public ResponseEntity<MessageModel> addDataProduksi(TblProduksi tblProduksi)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try{
            produksiRepository.save(tblProduksi);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", tblProduksi);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    public ResponseEntity<MessageModel> deleteDataProduksi(UUID idProduksi){
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try{
            produksiRepository.deleteById(idProduksi);
            msg.setStatus(true);
            msg.setMessage("Berhasil dihapus");
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

    }

    public ResponseEntity getProduksiClassRepo(String namaBarang, String tipeBarang){
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            List<ProduksiPojo> data = produkRepositoryClass.getDataDinamic(namaBarang, tipeBarang);
            if(data.isEmpty()) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Success");
                result.put("data", data);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }

        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);

        }
    }
}
