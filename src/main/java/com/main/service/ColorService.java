package com.main.service;

import com.main.MobiShopUtil;
import com.main.exception.RecordNotFoundException;
import com.main.model.ColorModel;
import com.main.model.ProductModel;
import com.main.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColorService {
    @Autowired
    ColorRepository repository;

    //get all
    public List<ColorModel> getAllColor() {
        List<ColorModel> colorModels = repository.findAll();
        if (colorModels.size() > 0) {
            return colorModels;
        } else {
            return new ArrayList<ColorModel>();
        }
    }

    //get by CateId
    public ColorModel findCateById(Integer id) throws RecordNotFoundException {
        Optional<ColorModel> productCategory = repository.findById(id);
        if (productCategory.isPresent()) {
            return productCategory.get();
        } else {
            throw new RecordNotFoundException("No category record exist for given id", id);
        }
    }

    //update or create
    public ColorModel createOrUpdateColor(ColorModel entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<ColorModel> oldPro = repository.findById(entity.getId());

            if (oldPro.isPresent()) {
                ColorModel newEntity = oldPro.get();
                if (entity.getId() != null) {
                    newEntity.setId(entity.getId());
                }
                if (entity.getId_product() != null) {
                    newEntity.setId_product(entity.getId_product());
                }
                if (entity.getName() != null) {
                    newEntity.setName(entity.getName());
                }
                if (entity.getId_code() != null) {
                    newEntity.setId_code(entity.getId_code());
                }
                if (entity.getDescription() != null) {
                    newEntity.setDescription(entity.getDescription());
                }
                if (entity.getPrice_import() != null) {
                    newEntity.setPrice_import(entity.getPrice_import());
                }
                if (entity.getPrice_export() != null) {
                    newEntity.setPrice_export(entity.getPrice_export());
                }
                if (entity.getQuantity_import() != null) {
                    newEntity.setQuantity_import(entity.getQuantity_import());
                }
                if (entity.getQuantity_export() != null) {
                    newEntity.setQuantity_import(entity.getQuantity_export());
                }
                if (entity.getTotal_import() != null) {
                    newEntity.setTotal_import(entity.getTotal_import());
                }
                if (entity.getTotal_export() != null) {
                    newEntity.setTotal_export(entity.getTotal_export());
                }
                if (entity.getDate_import() != null) {
                    newEntity.setDate_import(entity.getDate_import());
                }
                if (entity.getDate_export() != null) {
                    newEntity.setDate_export(entity.getDate_export());
                }
                if (entity.getStatus() != null) {
                    newEntity.setStatus(entity.getStatus());
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
    public void deleteColorById(Integer id) throws RecordNotFoundException {
        Optional<ColorModel> product = repository.findById(id);

        if (product.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No product record exist for given id", id);
        }
    }
}
