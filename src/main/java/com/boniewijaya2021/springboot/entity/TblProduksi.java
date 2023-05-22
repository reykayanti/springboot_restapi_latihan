package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_produksi", schema = "sample")
public class TblProduksi implements Serializable {

//    private static final long serialversionID = 1L;

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_produksi", nullable = false)
    private UUID id_produksi;

    @Column(name = "nama_barang", nullable = false)
    private String namaBarang;

    @Column(name = "tipe_barang", nullable = false)
    private String tipeBarang;

    @Column(name = "asal_barang", nullable = false)
    private String asalBarang;

    @Column(name = "biaya_produksi", nullable = false)
    private Double biayaProduksi;

//    @Column(name = "tanggal_produksi", nullable = false)
//    private Timestamp tanggalProduksi;

    @Column(nullable = false, updatable = false)
    @Temporal (TemporalType.TIMESTAMP) //untuk mengubah data ke waktu dan tanggal
    @CreatedDate
    private Date tanggalProduksi;

//    last modif or updated
//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate

//    public Produksi(Long id, String name){
//        this.id = id;
//        this.name = name;
//    }
}
