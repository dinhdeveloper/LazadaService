package com.main.repository;

import com.main.model.ColorModel;
import com.main.model.ProductModel;
import com.main.model.SizeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface  ColorRepository extends JpaRepository<ColorModel, Integer> {
    @Query("SELECT DISTINCT s FROM ColorModel e,SizeModel s WHERE e.id = s.color_id and e.id = ?1")
    ArrayList<SizeModel> getAllSizeByColorId(int id);


    @Query("SELECT e FROM ColorModel e WHERE e.product_id = ?1")
    List<ColorModel> findByCategoryId(Integer id);
}
