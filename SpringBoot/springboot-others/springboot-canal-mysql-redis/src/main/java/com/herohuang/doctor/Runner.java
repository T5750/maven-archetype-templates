package com.herohuang.doctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.herohuang.doctor.service.CanalService;

/**
 * @author herohuang
 */
@Component
public class Runner implements CommandLineRunner {
	static Logger logger = LoggerFactory.getLogger(Runner.class);
	@Autowired
	private CanalService canalService;

	@Override
	public void run(String... strings) throws Exception {
		canalService.startBinlog();
	}
}
