package com.cnblogs.yjmyzz.handler;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.rest.handler.ContentTypeHandler;
import org.springframework.beans.BeanUtils;

public class JacksonHandler implements ContentTypeHandler {
	Logger logger = LogManager.getLogger(this.getClass());

	public String fromObject(Object obj, String resultCode, Writer out)
			throws IOException {
		if (obj != null) {
			JacksonFactory.getObjectMapper().writeValue(out, obj);
		}
		return null;
	}

	public void toObject(Reader in, Object target) {
		try {
			Object origin = JacksonFactory.getObjectMapper().readValue(in,
					target.getClass());
			BeanUtils.copyProperties(origin, target);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	public String getContentType() {
		return "application/json;charset=UTF-8";
	}

	public String getExtension() {
		return "json";
	}
}
