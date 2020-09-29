package com.main.repository;

import com.main.model.ProductModel;
import com.main.model.QuantityImportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityImportRepository extends JpaRepository<QuantityImportModel, Integer> {

}
