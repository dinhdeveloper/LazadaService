package com.main.repository;

import com.main.model.ColorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface  ColorRepository extends JpaRepository<ColorModel, Integer> {
    @Query("SELECT e FROM ColorModel e WHERE e.id_product = ?1")
    ColorModel findByProductId(Integer id);

    @Query("SELECT e FROM ColorModel e WHERE e.name LIKE %?1%")
    List<ColorModel> getSearch(String search);
}
