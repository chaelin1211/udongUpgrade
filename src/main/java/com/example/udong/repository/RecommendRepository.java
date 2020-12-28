package com.example.udong.repository;

import com.example.udong.util.RecommendBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendRepository extends JpaRepository<RecommendBean, Long> {
    
}
