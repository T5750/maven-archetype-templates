package com.evangel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.evangel.domain.City;
import com.evangel.service.CityService;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class CityRestController {
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
	public City findOneCity(@PathVariable("id") Long id) {
		return cityService.findCityById(id);
	}

	@RequestMapping(value = "/api/city", method = RequestMethod.GET)
	public List<City> findAllCity() {
		return cityService.findAllCity();
	}

	@RequestMapping(value = "/api/city", method = RequestMethod.POST)
	public void createCity(@RequestBody City city) {
		cityService.saveCity(city);
	}

	@RequestMapping(value = "/api/city", method = RequestMethod.PUT)
	public void modifyCity(@RequestBody City city) {
		cityService.updateCity(city);
	}

	@RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
	public void modifyCity(@PathVariable("id") Long id) {
		cityService.deleteCity(id);
	}
}
