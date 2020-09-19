package com.main.service;

import com.main.exception.RecordNotFoundException;
import com.main.model.*;
import com.main.repository.PriceFeesRepository;
import com.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriceFeesService {
    @Autowired
    PriceFeesRepository repository;

    @Autowired
    ProductRepository productRepository;

    //get all
    public List<PriceFeesModel> getAllPriceFees() {
        List<PriceFeesModel> colorModels = repository.findAll();
        if (colorModels.size() > 0) {
            return colorModels;
        } else {
            return new ArrayList<PriceFeesModel>();
        }
    }

    public List<ProductPriceModel> getListProduct(){
        List<ProductPriceModel> listProduct = new ArrayList<>();
        List<ProductModel> listPro = productRepository.findAll();
        ArrayList<PriceFeesModel> listPrice = new ArrayList<>();
        for (ProductModel pro : listPro){
            listPrice.add(repository.getAllPriceByColorId(pro.getId()));

           // listProduct.add(new ProductPriceModel(String.valueOf(pro.getId()),pro.getProduct_name(),pro.getDate_export(),listPrice));
        }
        return listProduct;
    }

    //update or create
    public PriceFeesModel createOrUpdatePriceFees(PriceFeesModel entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<PriceFeesModel> oldPro = repository.findById(entity.getId());

            if (oldPro.isPresent()) {
                PriceFeesModel newEntity = oldPro.get();
                if (entity.getId_code() != null) {
                    newEntity.setId_code(entity.getId_code());
                }
                if (entity.getPrice_print() != null) {
                    newEntity.setPrice_print(entity.getPrice_print());
                }
                if (entity.getPrice_ship() != null) {
                    newEntity.setPrice_ship(entity.getPrice_ship());
                }
                if (entity.getProduct_id() != 0) {
                    newEntity.setProduct_id(entity.getProduct_id());
                }
                if (entity.getPrice_sell() != null) {
                    newEntity.setPrice_sell(entity.getPrice_sell());
                }
                if (entity.getPrice_fees() != null) {
                    newEntity.setPrice_fees(entity.getPrice_fees());
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
    public void deletePriceFeesById(Integer id) throws RecordNotFoundException {
        Optional<PriceFeesModel> product = repository.findById(id);

        if (product.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No product record exist for given id", id);
        }
    }
}
