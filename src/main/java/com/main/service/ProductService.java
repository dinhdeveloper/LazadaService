package com.main.service;

import com.main.MobiShopUtil;
import com.main.exception.RecordNotFoundException;
import com.main.model.*;
import com.main.repository.ColorRepository;
import com.main.repository.ProductRepository;
import com.main.repository.SizeReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ProductModel findCateById(Integer id) throws RecordNotFoundException {
        Optional<ProductModel> productCategory = repository.findById(id);
        if (productCategory.isPresent()) {
            return productCategory.get();
        } else {
            throw new RecordNotFoundException("No category record exist for given id", id);
        }
    }

    //update or create
    public ProductModel createOrUpdateProduct(ProductModel entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<ProductModel> oldCategory = repository.findById(entity.getId());

            if (oldCategory.isPresent()) {
                ProductModel newEntity = oldCategory.get();
                if (entity.getId() != null) {
                    newEntity.setId(entity.getId());
                }
                if (entity.getId_code() != null) {
                    newEntity.setId_code(entity.getId_code());
                }
                if (entity.getImage() != null) {
                    newEntity.setImage(MobiShopUtil.getBaseUrl() + entity.getImage());
                }
                if (entity.getName() != null) {
                    newEntity.setName(entity.getName());
                }
                newEntity = repository.save(newEntity);
                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        } else {
            entity = repository.save(entity);
            return entity;
        }
    }

    //delete
    public void deleteCategoryById(Integer id) throws RecordNotFoundException {
        Optional<ProductModel> productCategory = repository.findById(id);

        if (productCategory.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No category record exist for given id", id);
        }
    }
}
