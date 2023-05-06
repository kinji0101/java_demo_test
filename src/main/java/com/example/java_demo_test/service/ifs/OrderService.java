package com.example.java_demo_test.service.ifs;

import java.util.Map;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.Menu;

public interface OrderService {

	public Menu addMenu(Map<String, Integer> menuMap);

}
