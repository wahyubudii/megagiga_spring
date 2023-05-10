package com.wahyubudi.megagiga.controllers;

import com.wahyubudi.megagiga.dto.ResponseData;
import com.wahyubudi.megagiga.models.entities.Barang;
import com.wahyubudi.megagiga.services.BarangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/barang")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Barang> getAllBarang() {
        return barangService.getAllBarang();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Barang getSingleBarang(@PathVariable("id") String id) {
        return barangService.getSingleBarang(id);
    }

    @PostMapping
    public ResponseEntity<ResponseData<Barang>> createBarang(@Valid @RequestBody Barang barang, Errors errors) {
        ResponseData<Barang> responseData = new ResponseData<>();
        if(errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.getMessage().add("Successfully add new barang");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(barangService.save(barang));
        return ResponseEntity.ok(responseData);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Barang>> updateBarang(@Valid @RequestBody Barang barang, Errors errors) {
        ResponseData<Barang> responseData = new ResponseData<>();
        if(errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.getMessage().add("Successfully add new barang");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(barangService.save(barang));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public String deleteBarang(@PathVariable("id") String id) {
        return barangService.deleteBarang(id);
    }
}
