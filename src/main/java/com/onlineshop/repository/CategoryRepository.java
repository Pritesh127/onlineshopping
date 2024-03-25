package com.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.entity.EntityCategory;

@Repository
public interface CategoryRepository extends JpaRepository<EntityCategory, Integer>{

}

