package com.main.controller;

import com.main.exception.RecordNotFoundException;
import com.main.model.QuantityImportModel;
import com.main.service.QuantityImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/quantity")
public class QuantityImportController {
    @Autowired
    private QuantityImportService service;

    @GetMapping("/list")
    public ResponseEntity<List<QuantityImportModel>> getAllProduct() {
        List<QuantityImportModel> list = service.getAllProduct();
        return new ResponseEntity<List<QuantityImportModel>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<QuantityImportModel> getById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        QuantityImportModel optional = service.findCateById(id);
        return new ResponseEntity<QuantityImportModel>(optional, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuantityImportModel> createOrUpdateCategory(@Valid @RequestBody QuantityImportModel product)
            throws RecordNotFoundException {
        QuantityImportModel updated = service.createOrUpdateProduct(product);
        return new ResponseEntity<QuantityImportModel>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCategoryById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        service.deleteCategoryById(id);
        return HttpStatus.OK;
    }
}
