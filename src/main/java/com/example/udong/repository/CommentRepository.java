package com.example.udong.repository;


import com.example.udong.util.CommentBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentBean, Long> {
    
}
