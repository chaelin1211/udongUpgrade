package com.example.udong.repository;


import com.example.udong.util.MemberInterestBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInterestRepository extends JpaRepository<MemberInterestBean, Long> {
    
}