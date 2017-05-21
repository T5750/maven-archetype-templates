package com.evangel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evangel.dao.CityDao;
import com.evangel.domain.City;
import com.evangel.service.CityService;

/**
 * 城市业务逻辑实现类
 *
 * Created by xchunzhao on 02/05/2017.
 */
@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDao cityDao;

	public City findCityByName(String cityName) {
		return cityDao.findByName(cityName);
	}
}
