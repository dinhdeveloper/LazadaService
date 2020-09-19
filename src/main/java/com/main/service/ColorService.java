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
    public List<ColorModel> getColorByCateId(Integer id) throws RecordNotFoundException {
        List<ColorModel> list = repository.findByProductId(id);
        if (list.size() > 0) {
            return list;
        } else {
            return new ArrayList<ColorModel>();
        }
    }

    //update or create
    public ColorModel createOrUpdateColor(ColorModel entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<ColorModel> oldPro = repository.findById(entity.getId());

            if (oldPro.isPresent()) {
                ColorModel newEntity = oldPro.get();
                if (entity.getId_code() != null) {
                    newEntity.setId_code(entity.getId_code());
                }
                if (entity.getSize_id() != null) {
                    newEntity.setSize_id(entity.getSize_id());
                }
                if (entity.getProduct_id() != 0) {
                    newEntity.setProduct_id(entity.getProduct_id());
                }
                if (entity.getColor_name() != null) {
                    newEntity.setColor_name(entity.getColor_name());
                }
                if (entity.getColor_description() != null) {
                    newEntity.setColor_description(entity.getColor_description());
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
