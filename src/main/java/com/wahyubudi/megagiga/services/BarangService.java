package com.wahyubudi.megagiga.services;

import com.wahyubudi.megagiga.models.entities.Barang;
import com.wahyubudi.megagiga.models.repository.BarangRepository;
import jakarta.transaction.TransactionScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@TransactionScoped
@RequiredArgsConstructor
@Slf4j
public class BarangService {
    @Autowired
    private final BarangRepository barangRepository;

    public Barang save(@RequestBody Barang barang) {
        log.info("Barang saved!");
        return barangRepository.save(barang);
    }

    public Iterable<Barang> getAllBarang() {
        return barangRepository.findAll();
    }

    public Barang getSingleBarang(String id) {
        Optional<Barang> barang = barangRepository.findById(id);
        if(!barang.isPresent()) {
            return null;
        }
        return barang.get();
    }

    public String deleteBarang(String id) {
        barangRepository.deleteById(id);
        log.info("Barang {} is deleted", id);
        return "Delete Successfully";
    }
}
