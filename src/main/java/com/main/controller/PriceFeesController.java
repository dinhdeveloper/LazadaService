package com.main.controller;

import com.main.exception.RecordNotFoundException;
import com.main.model.ListProductModel;
import com.main.model.PriceFeesModel;
import com.main.model.ProductPriceModel;
import com.main.service.PriceFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/price")
public class PriceFeesController {
    @Autowired
    PriceFeesService service;
    @GetMapping("/list")
    public ResponseEntity<List<PriceFeesModel>> getAllPrice() {
        List<PriceFeesModel> list = service.getAllPriceFees();
        return new ResponseEntity<List<PriceFeesModel>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PriceFeesModel> createOrUpdatePrice(@RequestBody PriceFeesModel product)
            throws RecordNotFoundException {
        PriceFeesModel updated = service.createOrUpdatePriceFees(product);
        return new ResponseEntity<PriceFeesModel>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/product")
    public List<ProductPriceModel> getListSize() {
        return service.getListProduct();
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePriceById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        service.deletePriceFeesById(id);
        return HttpStatus.OK;
    }
}
