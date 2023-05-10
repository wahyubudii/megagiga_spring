package com.wahyubudi.megagiga.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_barang")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Barang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "kode_barang")
    private String id;
    @Column(name = "nama_barang", length = 100, nullable = false)
    private String name;
    @Column(name = "harga_jual", nullable = false)
    private Long selling_price;
    @Column(name = "harga_beli", nullable = false)
    private Long purchase_price;
    @Column(name = "satuan", nullable = false)
    private int stock;
    @Column(name = "kategori", nullable = false)
    private String category;
//    @ManyToMany(mappedBy = "barang")
//    private Set<Penjualan> penjualan = new HashSet<>();
}
