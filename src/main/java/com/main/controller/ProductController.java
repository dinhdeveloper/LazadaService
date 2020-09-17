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
    public List<ListProductModel> getListPageProduct(@RequestParam int id, @RequestParam int page, @RequestParam int size){
        return service.getListPageProduct(id,page,size);
    }

    @GetMapping("/homepage")
    public List<ListProductModel> getListSize() {
        return service.getListSize();
    }

    @PostMapping
    public ResponseEntity<ProductModel> createOrUpdateProduct(@RequestBody ProductModel product)
            throws RecordNotFoundException {
        ProductModel updated = service.createOrUpdateProduct(product);
        return new ResponseEntity<ProductModel>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProductById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        service.deleteProductById(id);
        return HttpStatus.OK;
    }
    @GetMapping("search={search}")
    public ResponseEntity<List<ProductModel>> getSearch(@PathVariable("search") String search) throws RecordNotFoundException{
        List<ProductModel> optional = service.searchProduct(search);
        return new ResponseEntity<List<ProductModel>>(optional,new HttpHeaders(),HttpStatus.OK);
    }
}
