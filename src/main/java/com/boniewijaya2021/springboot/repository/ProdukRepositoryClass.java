package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.pojo.ProduksiPojo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProdukRepositoryClass {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProduksiPojo> getDataDinamic (String namaBarang, String tipeBarang){
        StringBuilder qb = new StringBuilder();

        if(namaBarang != null){
            qb.append(" and nama_barang = :namaBarang \n");
        }
        if(tipeBarang != null){
            qb.append(" and tipe_barang = :tipeBarang \n");
        }

        String sisipan = qb.toString();

        String QueryText="SELECT cast (id_produksi as varchar) id_produksi,  asal_barang, biaya_produksi, nama_barang,  tanggal_produksi, tipe_barang \n" +
                "FROM sample.tbl_produksi  WHERE 1=1 \n" +sisipan;

        Query query = entityManager.createNativeQuery(QueryText);
        if(namaBarang != null){
            query.setParameter("namaBarang", namaBarang);
        } if(tipeBarang != null){
            query.setParameter("tipeBarang", tipeBarang);
        }

        List hasil = query.getResultList();
        List<ProduksiPojo> result = new ArrayList<>();

        Iterator itr = hasil.iterator();
        while(itr.hasNext()){
            ProduksiPojo browse = new ProduksiPojo();
            Object[] obj = (Object[]) itr.next();
            String id_produksi = String.valueOf(obj[0]);
            String asalBarang= String.valueOf(obj[1]);
            Double biayaProduksi = (Double) obj[2];
            String barangNama = String.valueOf(obj[3]);
//            Timestamp tanggalProduksi = ((Timestamp) obj[4]).toLocalDateTime();
            Timestamp tanggalProduksi= Timestamp.valueOf(String.valueOf((Timestamp)obj[4]));
            String barangTipe= String.valueOf(obj[5]);

            browse.setIdProduksi(id_produksi);
            browse.setAsalBarang(asalBarang);
            browse.setBiayaProduksi(biayaProduksi);
            browse.setNamaBarang(barangNama);
            browse.setTanggalProduksi(tanggalProduksi);
            browse.setTipeBarang(barangTipe);
            result.add(browse);
        }
        return result;
    }


}
