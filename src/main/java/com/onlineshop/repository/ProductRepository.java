package com.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.entity.EntityProduct;



@Repository
public interface ProductRepository extends JpaRepository<EntityProduct, Integer>{

}

