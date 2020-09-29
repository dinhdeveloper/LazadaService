package com.main.controller;

import com.main.exception.RecordNotFoundException;
import com.main.model.ListProductModel;
import com.main.model.ProductModel;
import com.main.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/list")
    public ResponseEntity<List<ProductModel>> getAllProduct() {
        List<ProductModel> list = service.getAllProduct();
        return new ResponseEntity<List<ProductModel>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        ProductModel optional = service.findCateById(id);
        return new ResponseEntity<ProductModel>(optional, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductModel> createOrUpdateCategory(@Valid @RequestBody ProductModel product)
            throws RecordNotFoundException {
        ProductModel updated = service.createOrUpdateProduct(product);
        return new ResponseEntity<ProductModel>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCategoryById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        service.deleteCategoryById(id);
        return HttpStatus.OK;
    }
}
