package com.main.repository;

import com.main.model.ProductModel;
import com.main.model.SizeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeReporsitory extends JpaRepository<SizeModel, Integer> {

}
