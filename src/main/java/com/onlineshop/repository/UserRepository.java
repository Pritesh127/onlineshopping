package com.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
