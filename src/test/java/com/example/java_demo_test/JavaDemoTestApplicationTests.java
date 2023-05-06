package com.example.java_demo_test;

import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.Bird;
import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.service.ifs.Active;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.service.impl.ActiveImpl;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class JavaDemoTestApplicationTests {

	@Autowired
	private Active active;
	@Autowired
	private BankService bankservice;
	@Autowired
	private Menu menu;

	@Test
	public void MenuTest() {
		Map<String, Integer> newMenuMap = new HashMap<>();
		newMenuMap.put("Beef", 100);
		newMenuMap.put("Pork", 80);
		newMenuMap.put("Chicken", 70);
		Menu menu = new Menu();
		menu.setMenuMap(newMenuMap);
		Map<String, Integer> orderMap = new HashMap<>();
		Scanner nameScanner = new Scanner(System.in);
		Scanner numScanner = new Scanner(System.in);
		Scanner Scanner = new Scanner(System.in);
		System.out.println("請點餐 : 1 為繼續點餐, 0 為結束點餐");
		int count = Scanner.nextInt();
		while(count == 1) {
			System.out.println("請輸入品項");
			String name = nameScanner.next();
			System.out.println("請輸入數量");
			int num = numScanner.nextInt();
			orderMap.put(name, num);
			System.out.println("請點餐 : 1 為繼續點餐, 0 為結束點餐");
			count = Scanner.nextInt();
		}
//		orderService.order(newMenu,orderMap);
	}
//	public void contextLoads() {
//		Bird bird = new Bird("LLL",5);
//		active.fly(bird.getName(),bird.getAge());
//	public void BankserviceTest() {
//		Bank bank = new Bank("早安",5000);
//		bankservice.getAmount(bank);
//		bankservice.deposit(bank, 2000);
//		bankservice.withdraw(bank, 2000);
}

