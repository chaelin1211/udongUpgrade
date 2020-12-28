package com.example.udong.repository;


import com.example.udong.util.InterestCategoryBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestCategoryRepository extends JpaRepository<InterestCategoryBean, Long> {
    
}