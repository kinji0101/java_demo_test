package com.example.java_demo_test.service.impl;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.vo.Menu2Response;
import com.example.java_demo_test.vo.OrderRequest;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Override
	public Menu addMenu(Map<String, Integer> menuMap) {
		Menu menu = new Menu();
		menu.setMenuMap(menuMap);
		return menu;
	}
	public void order(Menu menu,Map<String, Integer> orderMap) {
		int totalPrice = 0;
		Map<String, Integer>menuMap = menu.getMenuMap();
	for(Entry<String, Integer> item :orderMap.entrySet()) {
		String key = item.getKey();
		int value = item.getValue();
		if(!menuMap.containsKey(key)|| value <= 0){
			continue;
		}
		int itemPrice = menuMap.get(key);
		int itemTotalPrice = itemPrice * value;
		totalPrice = totalPrice + itemTotalPrice;
		System.out.println(key + ",數量 :" + value + " ,價格:" + itemTotalPrice);
	}
	if(totalPrice >500) {
		int newtotalPrice = (int) (totalPrice * 0.9);
		System.out.println("餐點總價格" + totalPrice + ",折扣後價格" + newtotalPrice);
		return;
	}
	System.out.println("餐點總價格:" + totalPrice)	;

}
}