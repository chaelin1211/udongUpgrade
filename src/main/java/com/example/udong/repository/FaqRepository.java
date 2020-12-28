package com.example.udong.repository;

import com.example.udong.util.FaqBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<FaqBean, Long> {
    
}
