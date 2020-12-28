package com.example.udong.repository;


import com.example.udong.util.BoardBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardBean, Long> {
    
}
