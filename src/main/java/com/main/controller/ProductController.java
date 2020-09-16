package com.main.controller;

import com.main.exception.RecordNotFoundException;
import com.main.model.BaseResponseModel;
import com.main.model.ProductModel;
import com.main.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pageproduct")
    public List<ProductModel> getListPageProduct(@RequestParam int page, @RequestParam int size) {

        return service.getPageProduct(page, size);
    }
}
