package com.example.java_demo_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.PersonInfo;
@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String>{
	
	List<PersonInfo> findByAge(int age);
	
	List<PersonInfo> findByAgeGreaterThan(int age);
	
	List<PersonInfo> findByAgeLessThanEqual(int age);
	
	List<PersonInfo> findByCityAndAgeGreaterThan(String city,int age);
	
	List<PersonInfo> findByCityContaining(String city);
	
	List<PersonInfo> findByAgeBetween(int age, int age2);

	List<PersonInfo> findByAgeAfterOrAgeBefore(int age, int age2);

	List<PersonInfo> findByAgeAfterOrAgeBeforeOrCity(int age, int age2,String city);
	
	List<PersonInfo> findByCityOrderByAgeAsc(String city);
	
	List<PersonInfo> findByCityContainingOrderByAgeDesc(String city);
	
	List<PersonInfo> findByCityContainingOrderByAge(String city);



}
