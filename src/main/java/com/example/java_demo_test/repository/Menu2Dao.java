package com.example.java_demo_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Menu2;

@Repository
public interface Menu2Dao extends JpaRepository<Menu2, String> {

}
