package com.cnblogs.yjmyzz.handler;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.apache.struts2.rest.handler.ContentTypeHandler;

import com.cnblogs.yjmyzz.dto.Order;
import com.cnblogs.yjmyzz.dto.OrderList;
import com.thoughtworks.xstream.XStream;

public class XStreamHandler implements ContentTypeHandler {
	public String fromObject(Object obj, String resultCode, Writer out)
			throws IOException {
		if (obj != null) {
			XStream xstream = XStreamFactory.getInstance();
			xstream.processAnnotations(obj.getClass());
			xstream.toXML(obj, out);
		}
		return null;
	}

	public void toObject(Reader in, Object target) {
		XStream xstream = XStreamFactory.getInstance();
		xstream.alias("data", OrderList.class);
		xstream.alias("order", Order.class);
		xstream.processAnnotations(target.getClass());
		xstream.fromXML(in, target);
	}

	public String getContentType() {
		return "application/xml";
	}

	public String getExtension() {
		return "xml";
	}
}
