package com.main.controller;

import com.main.exception.RecordNotFoundException;
import com.main.model.ColorModel;
import com.main.model.ListProductModel;
import com.main.model.ProductModel;
import com.main.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/color")
public class ColorController {
    @Autowired
    ColorService service;

    @GetMapping("/list")
    public ResponseEntity<List<ColorModel>> getAllColor() {
        List<ColorModel> list = service.getAllColor();
        return new ResponseEntity<List<ColorModel>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/product={id}")
    public ResponseEntity<ColorModel> getById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        ColorModel optional = service.findCateById(id);
        return new ResponseEntity<ColorModel>(optional, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ColorModel> createOrUpdateColor(@RequestBody ColorModel product)
            throws RecordNotFoundException {
        ColorModel updated = service.createOrUpdateColor(product);
        return new ResponseEntity<ColorModel>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteColorById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        service.deleteColorById(id);
        return HttpStatus.OK;
    }
}
