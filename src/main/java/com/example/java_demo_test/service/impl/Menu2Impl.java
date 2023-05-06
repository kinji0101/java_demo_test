package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Menu2;
import com.example.java_demo_test.repository.Menu2Dao;
import com.example.java_demo_test.service.ifs.Menu2Service;
import com.example.java_demo_test.vo.Menu2Request;
import com.example.java_demo_test.vo.Menu2Response;
import com.example.java_demo_test.vo.OrderRequest;

@Service
public class Menu2Impl implements Menu2Service {

	@Autowired
	private Menu2Dao menu2Dao;

	@Override
	public Menu2Response addMenu2(Menu2Request request) {
		List<Menu2> infoList = request.getMenu2List();
		System.out.println(infoList == null);
		if (CollectionUtils.isEmpty(infoList)) {
			return new Menu2Response("新增餐點錯誤");
		}
		List<Menu2> errorInfoList = new ArrayList<>();
		for (Menu2 item : infoList) {
			if (!StringUtils.hasText(item.getMealname()) || item.getPrice() <= 0) {
				return new Menu2Response("Add menu Error");
			}
			if (menu2Dao.existsById(item.getMealname())) {
				errorInfoList.add(item);
			}
			if (!errorInfoList.isEmpty()) {
				return new Menu2Response(errorInfoList, "餐點已存在");
			}
			menu2Dao.saveAll(infoList);
			return new Menu2Response(infoList, "Add menu Successful");
		}
		return null;
	}

	@Override
	public List<Menu2> getMenu2() {
		return menu2Dao.findAll();
	}

	@Override
	public Menu2Response order(OrderRequest orderRequest) {
		Map<String, Integer> orderMenu = orderRequest.getOrderMap();
		int originalTotalPrice = 0;
		for (Entry<String, Integer> item : orderMenu.entrySet()) {
			String menuItem = item.getKey();
			Optional<Menu2> menuOp = menu2Dao.findById(menuItem);
			if (!menuOp.isPresent()) {
				return new Menu2Response("餐點不存在");
			}
			Menu2 menu2 = menuOp.get();
			int price = menu2.getPrice();
			int itemTotalPrice = price * item.getValue();
			originalTotalPrice += itemTotalPrice;

		}
		int totalPrice = 0;
		if (originalTotalPrice >= 500) {
			totalPrice = (int) (originalTotalPrice * 0.9);
			return new Menu2Response(orderMenu, originalTotalPrice, totalPrice);
		} 
			return new Menu2Response(orderMenu, originalTotalPrice);
//			
//			return originalTotalPrice >= 500 ? new Menu2Response(orderMenu, originalTotalPrice, 
//					(int) (originalTotalPrice * 0.9)): new Menu2Response(orderMenu, originalTotalPrice);
		}
	}