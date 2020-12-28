package com.example.udong.repository;


import com.example.udong.util.AreaBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<AreaBean, Long> {
    
}
