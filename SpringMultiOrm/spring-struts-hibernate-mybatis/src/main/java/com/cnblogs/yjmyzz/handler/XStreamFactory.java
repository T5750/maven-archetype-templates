package com.cnblogs.yjmyzz.handler;

import com.thoughtworks.xstream.XStream;

public class XStreamFactory {
	private XStreamFactory() {
	}

	private static XStream xStream = null;

	public static XStream getInstance() {
		if (xStream == null) {
			xStream = new XStream();
			xStream.setMode(XStream.NO_REFERENCES);
		}
		return xStream;
	}
}
