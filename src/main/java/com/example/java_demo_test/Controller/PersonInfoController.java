package com.example.java_demo_test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.PersonInfoRequest;
import com.example.java_demo_test.vo.PersonInfoResponse;


@RestController
public class PersonInfoController {

	@Autowired
	private PersonInfoService service;

//	@PostMapping("/add_Person_InfoA")
//	public PersonInfoResponseA addPersomInfo(@RequestBody PersonInfoRequestA request) {
//		return service.addPersonInfo(request);
//	}
	
	@PostMapping("/add_Person_Info")
	public PersonInfoResponse addPersonInfo(@RequestBody PersonInfoRequest request) {
		return service.addPersonInfo(request);
	}
	
	@PostMapping("/get_Person_Info")
	public List<PersonInfo> getPersonInfo() {
		return service.getPersonInfo();
	}
	@PostMapping("/get_Person_Info_by_id")
	public PersonInfoResponse addPersonInfoById(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoById(request.getId());
	}
	
	@PostMapping("/get_Person_Info_by_age")
	public List<PersonInfo> addPersonInfoByAge(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByAge(request.getAge());
	}
	
	@PostMapping("/get_Person_Info_by_age_greater_than")
	public List<PersonInfo> addPersonInfoByAgeGreaterThan(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByAgeGreaterThan(request.getAge());
	}
	
	@PostMapping("/get_Person_Info_by_age_greater_than_equal")
	public List<PersonInfo> addPersonInfoByAgeLessThanEqual(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByAgeLessThanEqual(request.getAge());
	}
	@PostMapping("/get_Person_Info_by_City_And_Age_Greater_Than")
	public List<PersonInfo> addPersonInfoByCityAndAgeGreaterThan(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByCityAndAgeGreaterThan(request.getCity(),request.getAge());
	}
	
	@PostMapping("/get_Person_Info_by_City_Containing")
	public List<PersonInfo> addPersonInfoByCityContaining(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByCityContaining(request.getCity());
	}
	
	@PostMapping("/get_Person_Info_by_age_Between")
	public List<PersonInfo> addPersonInfoByAgeBetween(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByAgeBetween(request.getAge(),request.getAge2());
	}
	
	@PostMapping("/get_Person_Info_by_age_After_Or_Age_Before")
	public List<PersonInfo> addPersonInfoByAgeAfterOrAgeBefore(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByAgeAfterOrAgeBefore(request.getAge(),request.getAge2());
	}
	
	@PostMapping("/get_Person_Info_by_age_After_Or_Age_Before_Or_City")
	public List<PersonInfo> addPersonInfoByAgeAfterOrAgeBeforeOrCity(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByAgeAfterOrAgeBeforeOrCity(request.getAge(),request.getAge2(),request.getCity());
	}
	
	@PostMapping("/get_Person_Info_by_City_Order_By_Age_Asc")
	public List<PersonInfo> addPersonInfoByCityOrferByAgeAsc(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByCityOrderByAgeAsc(request.getCity());
	}
	
	@PostMapping("/get_Person_Info_by_City_Containing_Order_By_Age_Desc")
	public List<PersonInfo> addPersonInfoByCityContainingOrderByAgeDesc(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByCityContainingOrderByAgeDesc(request.getCity());
	}
	
	@PostMapping("/get_Person_Info_by_City_Containing_Order_By_Age")
	public List<PersonInfo> addPersonInfoByCityContainingOrderByAge(@RequestBody PersonInfoRequest request) {
		return service.getPersonInfoByCityContainingOrderByAge(request.getCity());
	}




}
