package com.evangel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evangel.dao.CityDao;
import com.evangel.domain.City;
import com.evangel.service.CityService;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDao cityDao;

	public List<City> findAllCity() {
		return cityDao.findAllCity();
	}

	public City findCityById(Long id) {
		return cityDao.findById(id);
	}

	@Override
	public Long saveCity(City city) {
		return cityDao.saveCity(city);
	}

	@Override
	public Long updateCity(City city) {
		return cityDao.updateCity(city);
	}

	@Override
	public Long deleteCity(Long id) {
		return cityDao.deleteCity(id);
	}
}
