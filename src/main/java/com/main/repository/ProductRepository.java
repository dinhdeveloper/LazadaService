package com.main.repository;

import com.main.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    @Query("SELECT e,f.color_description,f.color_name FROM ProductModel e,ColorModel f WHERE e.color_id = f.id ORDER BY e.id DESC")
    Page<ProductModel> getPageProduct(Pageable pageable);
}
