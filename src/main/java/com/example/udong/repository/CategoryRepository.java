package com.example.udong.repository;

import com.example.udong.util.CategoryBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryBean, Long> {
    
}
