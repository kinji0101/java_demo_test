package com.example.java_demo_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.java_demo_test.entity.Bird;
import com.example.java_demo_test.service.ifs.Active;
import com.example.java_demo_test.service.impl.ActiveImpl;

@SpringBootApplication
public class JavaDemoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDemoTestApplication.class, args);
//		Bird bird = new Bird("LLL",5);
//		Active act = new ActiveImpl();
//		act.fly(bird.getName(),bird.getAge());
	}

}
