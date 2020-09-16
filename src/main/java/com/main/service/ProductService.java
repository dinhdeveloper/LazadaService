package com.main.service;

import com.main.model.ColorModel;
import com.main.model.ProductModel;
import com.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    //get all
    public List<ProductModel> getAllProduct() {
        List<ProductModel> productModels = repository.findAll();
        if (productModels.size() > 0) {
            return productModels;
        } else {
            return new ArrayList<ProductModel>();
        }
    }

    public List<ProductModel> getPageProduct(int page, int size) {
        List<ProductModel> pageProduct = repository.getPageProduct(PageRequest.of(page, size)).getContent();
        if (pageProduct.size() > 0) {
            ColorModel colorModel = new ColorModel();
            colorModel.setColor_name(pageProduct.get(1));
            colorModel.setColor_description(pageProduct.get(2));
            pageProduct.get(0).setColorModels(colorModel);
            return pageProduct;
        } else {
            return new ArrayList<ProductModel>();
        }
    }
}
