package com.example.java_demo_test.service.ifs;

import java.util.List;

import com.example.java_demo_test.entity.Menu2;
import com.example.java_demo_test.vo.Menu2Request;
import com.example.java_demo_test.vo.Menu2Response;
import com.example.java_demo_test.vo.OrderRequest;

public interface Menu2Service {
	
	public Menu2Response addMenu2(Menu2Request request);
	
	public List<Menu2> getMenu2();

	Menu2Response order(OrderRequest orderRequest);

}
