package com.main.repository;

import com.main.model.ColorModel;
import com.main.model.PriceFeesModel;
import com.main.model.SizeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PriceFeesRepository extends JpaRepository<PriceFeesModel, Integer> {
    @Query("SELECT DISTINCT s FROM ProductModel e,PriceFeesModel s WHERE e.id = s.product_id and s.product_id=?1")
    ArrayList<PriceFeesModel> getAllPriceByColorId(int id);
}
