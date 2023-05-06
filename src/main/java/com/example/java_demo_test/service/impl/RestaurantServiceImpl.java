package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Restaurant;
import com.example.java_demo_test.repository.RestaurantDao;
import com.example.java_demo_test.service.ifs.RestaurantService;
import com.example.java_demo_test.vo.RestaurantRequest;
import com.example.java_demo_test.vo.RestaurantResponse;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	public RestaurantResponse addRestaurant(RestaurantRequest request) {
		List<Restaurant> errorInfoList = new ArrayList<>();
		List<Restaurant> infoList = request.getRestaurantList();
		for (Restaurant item : infoList) {
			if(!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getCity())) {
				return new RestaurantResponse("Add Restaurant Info error");
			}
			if(restaurantDao.existsById(item.getId())) {
				errorInfoList.add(item);
			}
		}
		
		if(!errorInfoList.isEmpty()) {
			return new RestaurantResponse("摨振撌脣�");
		}
		
		restaurantDao.saveAll(infoList);
		return new RestaurantResponse(infoList, "Add Restaurant Info Successful");
	}

	@Override
	public List<Restaurant> getRestaurant() {
		return null;		
	}

	@Override
	public RestaurantResponse getRestaurantById(String id) {
		if(!StringUtils.hasText(id)) {
			return new RestaurantResponse("id 銝�蝛�");
	}
		Optional<Restaurant> op = restaurantDao.findById(id);
		if(op.isPresent()) {
			return new RestaurantResponse(op.get());
		}
		return new RestaurantResponse("��鞈��");
	}





}
