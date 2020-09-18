package com.main.repository;

import com.main.model.ColorModel;
import com.main.model.PriceFeesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceFeesRepository extends JpaRepository<PriceFeesModel, Integer> {
}
