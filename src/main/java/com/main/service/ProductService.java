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

    @Autowired
    private SizeReporsitory sizerepository;

    @Autowired
    private ColorRepository colorrepository;

    //get all
    public List<ProductModel> getAllProduct() {
        List<ProductModel> productModels = repository.findAll();
        if (productModels.size() > 0) {
            return productModels;
        } else {
            return new ArrayList<ProductModel>();
        }
    }

    public List<ListProductModel> getListPageProduct(int id, int page, int size) {
        List<ListProductModel> pageProduct = repository.getPageProduct(id, PageRequest.of(page, size)).getContent();
        if (pageProduct.size() > 0) {
            return pageProduct;
        } else {
            return new ArrayList<ListProductModel>();
        }
    }

    public List<ListProductModel> getListSize() {
        List<ListProductModel> listProductModel = new ArrayList<>();
        ArrayList<SizeColorModel> sizeColor = new ArrayList<>();
        List<ProductModel> listPro = repository.findAll();
        ArrayList<SizeModel> listSize = new ArrayList<>();
        for (ProductModel proModel : listPro) {
            ArrayList<ColorModel> listColor = repository.findByColorId(proModel.getId());
            if (listColor.size() > 0) {
                for (ColorModel color : listColor) {
                    listSize = colorrepository.getAllSizeByColorId(color.getId());
                    if (listSize.size() > 0) {
                        sizeColor.add(new SizeColorModel(String.valueOf(color.getId()), color.getColor_name(), color.getColor_description(), listSize));
                    } else {
                        listSize = new ArrayList<>();
                    }
                }
                listProductModel.add(new ListProductModel(String.valueOf(proModel.getId()), proModel.getId_code(), proModel.getColor_id(),
                        proModel.getProduct_name(), proModel.getProduct_image(), proModel.getPrice_import(),
                        proModel.getPrice_export(), proModel.getQuantity_import(), proModel.getQuantity_export(), proModel.getSafe_stock(),
                        proModel.getDate_create(), proModel.getDate_export(), proModel.getTotal_import(),
                        proModel.getTotal_export(), proModel.getStatus(), sizeColor));
            } else {
                listColor = new ArrayList<>();
            }
        }
        return listProductModel;
    }

    //update or create
    public ProductModel createOrUpdateProduct(ProductModel entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<ProductModel> oldPro = repository.findById(entity.getId());

            if (oldPro.isPresent()) {
                ProductModel newEntity = oldPro.get();
                if (entity.getId_code() != null) {
                    newEntity.setId_code(entity.getId_code());
                }
                if (entity.getColor_id() != null) {
                    newEntity.setColor_id(entity.getColor_id());
                }
                if (entity.getProduct_name() != null) {
                    newEntity.setProduct_name(entity.getProduct_name());
                }
                if (entity.getProduct_image() != null) {
                    newEntity.setProduct_image(MobiShopUtil.getBaseUrl() + entity.getProduct_image());
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
                    newEntity.setQuantity_export(entity.getQuantity_export());
                }
                if (entity.getSafe_stock() != null) {
                    newEntity.setSafe_stock(entity.getSafe_stock());
                }
                if (entity.getDate_create() != null) {
                    newEntity.setDate_create(entity.getDate_create());
                }
                if (entity.getDate_export() != null) {
                    newEntity.setDate_export(entity.getDate_export());
                }
                if (entity.getStatus() != null) {
                    newEntity.setStatus(entity.getStatus());
                }
                if (entity.getTotal_import() != null) {
                    newEntity.setTotal_import(entity.getTotal_import());
                }
                if (entity.getTotal_export() != null) {
                    newEntity.setTotal_export(entity.getTotal_export());
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
    public void deleteProductById(Integer id) throws RecordNotFoundException {
        Optional<ProductModel> product = repository.findById(id);

        if (product.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No product record exist for given id", id);
        }
    }

    //search
    public List<ProductModel> searchProduct(String search) throws RecordNotFoundException {
        List<ProductModel> productList = repository.getSearch(search);
        if (productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<ProductModel>();
        }
    }

}
