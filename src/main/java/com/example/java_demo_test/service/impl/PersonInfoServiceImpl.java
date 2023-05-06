package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.PersonInfoRequest;
import com.example.java_demo_test.vo.PersonInfoRequestA;
import com.example.java_demo_test.vo.PersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponseA;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public PersonInfoResponseA addPersonInfo(PersonInfoRequestA request) {
		if (StringUtils.hasText(request.getId()) || !StringUtils.hasText(request.getName())) {
			return new PersonInfoResponseA("Add Person Info Error!!");
		}
		if (personInfoDao.existsById(request.getId())) {
			return new PersonInfoResponseA("帳號已存在");
		}
		PersonInfo info = new PersonInfo(request.getId(), request.getName(), request.getAge());
		personInfoDao.save(info);
		return new PersonInfoResponseA(request.getId(), request.getName(), request.getAge(),
				"Add Person Info Successful");

	}

	@Override
	public PersonInfoResponse addPersonInfo(PersonInfoRequest request) {
//		// 檢查單筆 PersonInfo
//		PersonInfo reqInfo = request.getPersonInfo();
//		if (StringUtils.hasText(reqInfo.getId()) || !StringUtils.hasText(reqInfo.getName())) {
//			return new PersonInfoResponse("Add Person Info Error");
//		}
//		if (personInfoDao.existsById(reqInfo.getId())) {
//			return new PersonInfoResponse("帳號已存在");
//		}
//		// 新增單筆 PersonInfo
//		personInfoDao.save(reqInfo);
		// =================================
		// 從 request 中取出多筆 PersonInfo
		List<PersonInfo> errorInfoList = new ArrayList<>();
		List<PersonInfo> infoList = request.getPersonInfoList();
		// 檢查多筆 PersonInfo :使用 foreach 逐筆檢查
		for (PersonInfo item : infoList) {
			// 檢查單筆 PersonInfo(item)
			if (!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getName())) {
				return new PersonInfoResponse("Add Person Info Error");
			}
			if (personInfoDao.existsById(item.getId())) {
				// 把id 有重複的 PersonInfo 加到errorInfoListerrorInfoList
				errorInfoList.add(item);
			}
			// infoList 有幾筆資料,就會 save 多少次:程式語言對對 DB 的存取算比較耗cost
			// 新增單筆 PersonInfo(item)
//			personInfoDao.save(item);
		}
		if (!errorInfoList.isEmpty()) {
			return new PersonInfoResponse(errorInfoList, "帳號已存在");
		}
		// 新增多筆 PersonInfo
		personInfoDao.saveAll(infoList);
		return new PersonInfoResponse(infoList, "Add Person Info Successful");
	}

	@Override
	public List<PersonInfo> getPersonInfo() {
		return personInfoDao.findAll();
	}

	@Override
	public PersonInfoResponse getPersonInfoById(String id) {
		if(!StringUtils.hasText(id)) {
			return new PersonInfoResponse("id 不得為空");
		}
		Optional<PersonInfo> op = personInfoDao.findById(id);
		if(op.isPresent()) {
			return new PersonInfoResponse(op.get());
		}
		return new PersonInfoResponse("查無資料");
	}

	@Override
	public List<PersonInfo> getPersonInfoByAgeGreaterThan(int age) {
		return personInfoDao.findByAgeGreaterThan(age);
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByAgeLessThanEqual(int age) {
		return personInfoDao.findByAgeLessThanEqual(age);
	}

	@Override
	public List<PersonInfo> getPersonInfoByAge(int age) {
//		List<PersonInfo> result = personInfoDao.findByAge(age);
		return personInfoDao.findByAge(age);
	}

	@Override
	public List<PersonInfo> getPersonInfoByCityAndAgeGreaterThan(String city, int age) {
		return personInfoDao.findByCityAndAgeGreaterThan(city, age);
	}

	@Override
	public List<PersonInfo> getPersonInfoByCityContaining(String city) {
		return personInfoDao.findByCityContaining(city);
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByAgeBetween(int age ,int age2) {
		return personInfoDao.findByAgeBetween( age ,age2);
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByAgeAfterOrAgeBefore(int age ,int age2) {
		return personInfoDao.findByAgeAfterOrAgeBefore(age ,age2);
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByAgeAfterOrAgeBeforeOrCity(int age ,int age2,String city) {
		return personInfoDao.findByAgeAfterOrAgeBeforeOrCity(age ,age2,city);
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByCityOrderByAgeAsc(String city) {
		return personInfoDao.findByCityOrderByAgeAsc(city);
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByCityContainingOrderByAgeDesc(String city) {
		return personInfoDao.findByCityContainingOrderByAgeDesc(city);
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByCityContainingOrderByAge(String city) {
		return personInfoDao.findByCityContainingOrderByAge(city);
	}

}
