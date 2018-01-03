package com.herohuang.doctor.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.herohuang.doctor.dto.Canal;
import com.herohuang.doctor.dto.Config;

/**
 * Created by acheron on 02/05/2017.
 */
@Component
public class PropertyUtil {
	static Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
	private static String filePath;
	@Autowired
	private Config config;

	private String getFilePath() {
		return config.getCachePropertiesPath();
	}

	private Properties getPps() {
		Properties pps = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream(getFilePath());
			pps.load(is);
		} catch (IOException e) {
			logger.error("Could not find resource " + getFilePath());
		}
		return pps;
	}

	public List<Canal> getCacheConfig() {
		List<Canal> canalList = new ArrayList<>();
		Properties pps = getPps();
		Enumeration enum1 = pps.propertyNames();
		Canal canal = null;
		while (enum1.hasMoreElements()) {
			String strKey = (String) enum1.nextElement();
			String strValue = pps.getProperty(strKey);
			canal = new Canal(strKey, strValue);
			canalList.add(canal);
		}
		return canalList;
	}

	public String getCacheKeyByTableName(String tableName) {
		Properties pps = getPps();
		return pps.getProperty(tableName);
	}

	public void WriteProperties(String tableName, String cacheKey) {
		Properties pps = getPps();
		try {
			OutputStream out = new FileOutputStream(getFilePath());
			pps.setProperty(tableName, cacheKey);
			pps.store(out, "");
			out.close();
		} catch (IOException e) {
			logger.error("Could not find resource " + getFilePath());
		}
	}

	public void removeProperties(String tableName) {
		Properties pps = getPps();
		try {
			OutputStream out = new FileOutputStream(getFilePath());
			pps.remove(tableName);
			pps.store(out, "");
		} catch (IOException e) {
			logger.error("Could not find resource " + getFilePath());
		}
	}

	public static void main(String[] args) {
		// List<Canal> cacheConfig = getCacheConfig();
		// for (Canal canal : cacheConfig) {
		// System.out.println(canal.getTableName() + ":" + canal.getCacheKey());
		// }
		// String cacheKey = getCacheKeyByTableName("nide");
		// System.out.println(cacheKey);
		// WriteProperties("nid", "com.nide.key.*");
		// System.out.println(getCacheKeyByTableName("nid"));
	}
}
