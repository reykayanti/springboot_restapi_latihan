package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblProduksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProduksiRepository extends JpaRepository<TblProduksi, UUID> {

    @Query(value = "SELECT cast (id_produksi as varchar) id_produksi, asal_barang, biaya_produksi, nama_barang, tanggal_produksi, tipe_barang\n" +
            "FROM sample.tbl_produksi where id_produksi =:idProduksi", nativeQuery = true)
    TblProduksi getProduksiById(@Param("idProduksi") UUID idProduksi);

//    TblProduksi deleteProduksiById(@Param("idProduksi") UUID idProduksi);
//    void save(TblProduksi tblProduksi);
}
