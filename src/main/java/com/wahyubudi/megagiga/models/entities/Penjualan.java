package com.wahyubudi.megagiga.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_penjualan")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Penjualan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_faktur")
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "tgl_faktur", nullable = false)
    private Date factur_date;
    @Column(name = "nama_konsumen", length = 100, nullable = false)
    private String name;
    @Column(nullable = false)
    private int jumlah;
    @Column(name = "harga_satuan", nullable = false)
    private Long price;
    @Column(name = "harga_total", nullable = false)
    private Long total_price;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tbl_penjualan_barang",
            joinColumns = @JoinColumn(name = "no_faktur", referencedColumnName = "no_faktur"),
            inverseJoinColumns = @JoinColumn(name = "kode_barang", referencedColumnName = "kode_barang"))
    private Set<Barang> barangs = new HashSet<>();
}
