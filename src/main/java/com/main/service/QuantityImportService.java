package com.main.service;

import com.main.MobiShopUtil;
import com.main.exception.RecordNotFoundException;
import com.main.model.QuantityImportModel;
import com.main.repository.QuantityImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuantityImportService {
    @Autowired
    private QuantityImportRepository repository;

    //get all
    public List<QuantityImportModel> getAllProduct() {
        List<QuantityImportModel> productModels = repository.findAll();
        if (productModels.size() > 0) {
            return productModels;
        } else {
            return new ArrayList<QuantityImportModel>();
        }
    }

    public QuantityImportModel findCateById(Integer id) throws RecordNotFoundException {
        Optional<QuantityImportModel> productCategory = repository.findById(id);
        if (productCategory.isPresent()) {
            return productCategory.get();
        } else {
            throw new RecordNotFoundException("No category record exist for given id", id);
        }
    }

    //update or create
    public QuantityImportModel createOrUpdateProduct(QuantityImportModel entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<QuantityImportModel> oldCategory = repository.findById(entity.getId());

            if (oldCategory.isPresent()) {
                QuantityImportModel newEntity = oldCategory.get();
                if (entity.getId() != null) {
                    newEntity.setId(entity.getId());
                }
                if (entity.getId_product() != null) {
                    newEntity.setId_product(entity.getId_product());
                }
                if (entity.getName() != null) {
                    newEntity.setName(entity.getName());
                }
                if (entity.getQuantity_import() != null) {
                    newEntity.setQuantity_import(entity.getQuantity_import());
                }
                if (entity.getTotal_import() != null) {
                    newEntity.setTotal_import(entity.getTotal_import());
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
        Optional<QuantityImportModel> productCategory = repository.findById(id);

        if (productCategory.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No category record exist for given id", id);
        }
    }
}
