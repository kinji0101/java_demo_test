package com.example.java_demo_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Restaurant;

@Repository
public interface RestaurantDao  extends JpaRepository<Restaurant, String>{
	
//	List<Restaurant> findBycity(String city);
//	
//	List<Restaurant> findByid(String id);
//
//	List<Restaurant> findBystar(int star);
}
