package com.example.java_demo_test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.service.ifs.Menu2Service;
import com.example.java_demo_test.vo.Menu2Request;
import com.example.java_demo_test.vo.Menu2Response;

@RestController
public class Menu2Controller {
	
	@Autowired
	private Menu2Service service;
	
	@PostMapping("/add_Menu2")
	public Menu2Response addMenu2(@RequestBody Menu2Request request) {
		return service.addMenu2(request);
	}


}
