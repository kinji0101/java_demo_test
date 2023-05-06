package com.example.java_demo_test;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.Bird;
import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;
import com.example.java_demo_test.service.ifs.Active;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.service.impl.ActiveImpl;

@SpringBootTest(classes = JavaDemoTestApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonInfoTest {
	
	private List<PersonInfo> list = new ArrayList<>();
	
	@Autowired
	private PersonInfoDao personInfoDao;
	
	@Test
	public void findByAgeDaoTest() {
//		//新增假資料放到BeforEach
//		//新增一筆假資料
//		PersonInfo personInfo = new PersonInfo("testA","testName",66,"桃園");
//		personInfoDao.save(personInfo);
//		//測試 FinByAge
		List<PersonInfo> result = personInfoDao.findByAge(66);
		//測試結果是否正確
		Assert.isTrue(result.size() == 1, "測試結果錯誤");
		//刪除假資料放到(AfterEach)
		//刪除新增的假資料(Optional)
//		personInfoDao.delete(personInfo);
	}
	
	@Test
	public void findByAgeGreaterThanDaoTest() {
//		PersonInfo personInfo1 = new PersonInfo("testA","testName",40,"桃園");
//		PersonInfo personInfo2 = new PersonInfo("testB","testName",41,"桃園");
//		PersonInfo personInfo3 = new PersonInfo("testC","testName",42,"桃園");
//		List<PersonInfo> list = Arrays.asList(personInfo1,personInfo2,personInfo3);
//		personInfoDao.saveAll(list);
		List<PersonInfo> result = personInfoDao.findByAge(40);
		Assert.isTrue(result.size() == 3, "測試結果錯誤");
//		personInfoDao.saveAll(list);
	}
	
	@BeforeEach
	public void beforeEachTest() {
//		PersonInfo personInfo1 = new PersonInfo("testA","testName",40,"桃園");
//		PersonInfo personInfo2 = new PersonInfo("testB","testName",41,"桃園");
//		PersonInfo personInfo3 = new PersonInfo("testC","testName",42,"桃園");
//		list = Arrays.asList(personInfo1,personInfo2,personInfo3);
//		personInfoDao.saveAll(list);
	}
	
	@AfterEach
	public void afterEachTest() {
////		personInfoDao.deleteAll(list);
	}
	
	@BeforeAll
	public void BeforeAllTest() {
		System.out.println("=================BeforeAll");
		PersonInfo personInfo1 = new PersonInfo("testA","testName",40,"桃園");
		PersonInfo personInfo2 = new PersonInfo("testB","testName",41,"桃園");
		PersonInfo personInfo3 = new PersonInfo("testC","testName",42,"桃園");
		list = Arrays.asList(personInfo1,personInfo2,personInfo3);
		personInfoDao.saveAll(list);
	}
	@AfterAll
	public void AfterAllTest() {
		System.out.println("=================AfterAll");
		personInfoDao.deleteAll(list);
	}

}
