package com.example.udong.repository;


import com.example.udong.util.QnaBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QnaRepository extends JpaRepository<QnaBean, Long> {
    
}