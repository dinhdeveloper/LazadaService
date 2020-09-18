package com.main.controller;

import com.main.exception.RecordNotFoundException;
import com.main.model.SizeModel;
import com.main.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/size")
public class SizeController {
    @Autowired
    SizeService service;

    @GetMapping("/list")
    public ResponseEntity<List<SizeModel>> getAllSize() {
        List<SizeModel> list = service.getAllSize();
        return new ResponseEntity<List<SizeModel>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SizeModel> createOrUpdateSize(@RequestBody SizeModel product)
            throws RecordNotFoundException {
        SizeModel updated = service.createOrUpdateSize(product);
        return new ResponseEntity<SizeModel>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSizeById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        service.deleteSizeById(id);
        return HttpStatus.OK;
    }
}
