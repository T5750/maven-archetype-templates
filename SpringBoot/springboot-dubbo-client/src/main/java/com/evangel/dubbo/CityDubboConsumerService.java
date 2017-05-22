package com.evangel.dubbo;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.evangel.domain.City;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class CityDubboConsumerService {
	@Reference(version = "1.0.0")
	CityDubboService cityDubboService;
	// fixed the bug by poms
	// java.lang.IllegalArgumentException: interface
	// com.evangel.dubbo.CityDubboService is not visible from class loader

	public void printCity() {
		String cityName = "温岭";
		City city = cityDubboService.findCityByName(cityName);
		System.out.println(city.toString());
	}
}
