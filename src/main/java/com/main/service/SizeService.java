package com.main.service;

import com.main.exception.RecordNotFoundException;
import com.main.model.SizeModel;
import com.main.repository.SizeReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SizeService {
    @Autowired
    SizeReporsitory repository;

    //get all
    public List<SizeModel> getAllSize() {
        List<SizeModel> colorModels = repository.findAll();
        if (colorModels.size() > 0) {
            return colorModels;
        } else {
            return new ArrayList<SizeModel>();
        }
    }

    //update or create
    public SizeModel createOrUpdateSize(SizeModel entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<SizeModel> oldPro = repository.findById(entity.getId());

            if (oldPro.isPresent()) {
                SizeModel newEntity = oldPro.get();
                if (entity.getId_code() != null) {
                    newEntity.setId_code(entity.getId_code());
                }
                if (entity.getColor_id() != null) {
                    newEntity.setColor_id(entity.getColor_id());
                }
                if (entity.getSize_name() != null) {
                    newEntity.setSize_name(entity.getSize_name());
                }
                if (entity.getSize_description() != null) {
                    newEntity.setSize_description(entity.getSize_description());
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
    public void deleteSizeById(Integer id) throws RecordNotFoundException {
        Optional<SizeModel> product = repository.findById(id);

        if (product.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No product record exist for given id", id);
        }
    }
}
