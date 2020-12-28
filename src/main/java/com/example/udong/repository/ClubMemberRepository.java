package com.example.udong.repository;


import com.example.udong.util.ClubMemberBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubMemberRepository extends JpaRepository<ClubMemberBean, Long> {
    
}