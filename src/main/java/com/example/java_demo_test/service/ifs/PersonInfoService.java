package com.example.java_demo_test.service.ifs;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.PersonInfoRequest;
import com.example.java_demo_test.vo.PersonInfoRequestA;
import com.example.java_demo_test.vo.PersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponseA;

public interface PersonInfoService {

	public PersonInfoResponseA addPersonInfo(PersonInfoRequestA request);

	public PersonInfoResponse addPersonInfo(PersonInfoRequest request);

	public List<PersonInfo> getPersonInfo();
	
	public PersonInfoResponse getPersonInfoById(String id);
	
	public List<PersonInfo> getPersonInfoByAgeGreaterThan(int age);
	
	public List<PersonInfo> getPersonInfoByAgeLessThanEqual(int age);
	
	public List<PersonInfo> getPersonInfoByAge(int age);
	
	public List<PersonInfo> getPersonInfoByCityAndAgeGreaterThan(String city,int age);
	
	public List<PersonInfo> getPersonInfoByCityContaining(String city);
	
	public List<PersonInfo> getPersonInfoByAgeBetween(int age ,int age2);

	public List<PersonInfo> getPersonInfoByAgeAfterOrAgeBefore(int age, int age2);

	public List<PersonInfo> getPersonInfoByAgeAfterOrAgeBeforeOrCity(int age, int age2,String city);

	public List<PersonInfo> getPersonInfoByCityOrderByAgeAsc(String city);

	public List<PersonInfo> getPersonInfoByCityContainingOrderByAgeDesc(String city);

	public List<PersonInfo> getPersonInfoByCityContainingOrderByAge(String city);

}
