package com.example.java_demo_test.service.impl;

import org.springframework.stereotype.Service;

import com.example.java_demo_test.entity.Bird;
import com.example.java_demo_test.service.ifs.Active;

@Service
public class ActiveImpl implements Active {
		
	@Override
	public void fly(String name,int age) {		
		System.out.println("今年"+ age+"歲"+ name+"正在飛");
	}
}