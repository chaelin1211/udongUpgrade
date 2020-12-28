package com.example.udong.repository;


import com.example.udong.util.ClubBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<ClubBean, Long> {
    
}
