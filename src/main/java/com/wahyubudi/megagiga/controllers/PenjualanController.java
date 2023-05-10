package com.wahyubudi.megagiga.controllers;

import com.wahyubudi.megagiga.dto.ResponseData;
import com.wahyubudi.megagiga.models.entities.Penjualan;
import com.wahyubudi.megagiga.services.PenjualanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/penjualan")
public class PenjualanController {
    @Autowired
    private PenjualanService penjualanService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Penjualan> getAllPenjualan() {
        return penjualanService.getAllPenjualan();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Penjualan getSinglePenjualan(@PathVariable("id") Long id) {
        return penjualanService.getSinglePenjualan(id);
    }

    @PostMapping
    public ResponseEntity<ResponseData<Penjualan>> createPenjualan(@Valid @RequestBody Penjualan penjualan, Errors errors) {
        ResponseData<Penjualan> responseData = new ResponseData<>();
        if(errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.getMessage().add("Successfully add new penjualan");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(penjualanService.save(penjualan));
        return ResponseEntity.ok(responseData);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Penjualan>> updatePenjualan(@Valid @RequestBody Penjualan penjualan, Errors errors) {
        ResponseData<Penjualan> responseData = new ResponseData<>();
        if(errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.getMessage().add("Successfully add new penjualan");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(penjualanService.save(penjualan));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public String deletePenjualan(@PathVariable("id") Long id) {
        return penjualanService.deletePenjualan(id);
    }
}
