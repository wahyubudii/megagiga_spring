package com.wahyubudi.megagiga.services;

import com.wahyubudi.megagiga.models.entities.Barang;
import com.wahyubudi.megagiga.models.entities.Penjualan;
import com.wahyubudi.megagiga.models.repository.BarangRepository;
import com.wahyubudi.megagiga.models.repository.PenjualanRepository;
import jakarta.transaction.TransactionScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@TransactionScoped
@RequiredArgsConstructor
@Slf4j
public class PenjualanService {
    @Autowired
    private final PenjualanRepository penjualanRepository;

    @Autowired
    private BarangRepository barangRepository;

    public Penjualan save(@RequestBody Penjualan penjualan) {
        Long totalPrice = 0L;
        Set<Barang> barangs = new HashSet<>();
        for (Barang barang : penjualan.getBarangs()) {
            Optional<Barang> barangOptional = barangRepository.findById(barang.getId());
            if (barangOptional.isPresent()) {
                Barang foundBarang = barangOptional.get();
                foundBarang.setStock(barang.getStock());
                barangs.add(foundBarang);
                totalPrice += foundBarang.getSelling_price() * barang.getStock();
            }
        }
        penjualan.setJumlah(penjualan.getBarangs().stream().mapToInt(Barang::getStock).sum());
        penjualan.setPrice(penjualan.getJumlah() * (totalPrice / penjualan.getJumlah()));
        penjualan.setTotal_price(penjualan.getJumlah() * (totalPrice / penjualan.getJumlah()));
        penjualan.setBarangs(new HashSet<>(barangs)); // use a new HashSet to avoid modifying the original one
        log.info("Penjualan saved!");
        return penjualanRepository.save(penjualan);
    }

    public Iterable<Penjualan> getAllPenjualan() {
        return penjualanRepository.findAll();
    }

    public Penjualan getSinglePenjualan(Long id) {
        Optional<Penjualan> penjualan = penjualanRepository.findById(id);
        if(!penjualan.isPresent()) {
            return null;
        }
        return penjualan.get();
    }

    public String deletePenjualan(Long id) {
        penjualanRepository.deleteById(id);
        log.info("Penjualan {} is deleted", id);
        return "Delete Successfully";
    }
}
