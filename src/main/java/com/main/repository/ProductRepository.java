package com.main.repository;

import com.main.model.ColorModel;
import com.main.model.ListProductModel;
import com.main.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    @Query("SELECT DISTINCT p,c,s FROM ProductModel p,ColorModel c,SizeModel s WHERE p.id =?1")
    Page<ListProductModel> getPageProduct(int id, Pageable pageable);

    @Query("SELECT e.id FROM ProductModel e WHERE e.id = ?1")
    Page<ProductModel> findByProductId(int id, Pageable page);

    @Query("SELECT DISTINCT e FROM ColorModel e,ProductModel p WHERE p.id = e.product_id and p.id = ?1")
    ArrayList<ColorModel> findByColorId(int id);

    @Query("SELECT e FROM ProductModel e WHERE e.product_name LIKE %?1%")
    List<ProductModel> getSearch(String search);
}
