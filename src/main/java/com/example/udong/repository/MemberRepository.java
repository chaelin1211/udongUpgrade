package com.example.udong.repository;

import com.example.udong.util.MemberBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberBean, Long> {
    
}
