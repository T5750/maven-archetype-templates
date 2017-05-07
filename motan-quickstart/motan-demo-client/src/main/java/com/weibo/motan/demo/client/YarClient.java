/*
 * Copyright 2009-2016 Weibo, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.weibo.motan.demo.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weibo.yar.yarclient.HttpYarClient;

public class YarClient {
	public static void main(String[] args) throws Exception {
		HttpYarClient yarClient = new HttpYarClient();
		String result = yarClient.call(
				"http://127.0.0.1:8003/openapi/yarserver/test", "testString",
				String.class, "yar");
		System.out.println(result);
		result = yarClient.call("http://127.0.0.1:8003/openapi/yarserver/test",
				"hello", String.class, "world");
		System.out.println(result);
		yarClient.call("http://127.0.0.1:8003/openapi/yarserver/test",
				"testVoid", Void.class);
		// System.out.println(result);
		result = yarClient.call("http://127.0.0.1:8003/openapi/yarserver/test",
				"testArgVoid", String.class);
		System.out.println(result);
		int result_int = yarClient.call(
				"http://127.0.0.1:8003/openapi/yarserver/test", "testInt",
				int.class, 2017);
		System.out.println(result_int);
		Integer result_Integer = yarClient.call(
				"http://127.0.0.1:8003/openapi/yarserver/test", "testInteger",
				Integer.class, 7102);
		System.out.println(result_Integer);
		Boolean result_boolean = yarClient.call(
				"http://127.0.0.1:8003/openapi/yarserver/test", "testBoolean",
				boolean.class, true);
		System.out.println(result_boolean);
		Long result_Long = yarClient.call(
				"http://127.0.0.1:8003/openapi/yarserver/test", "testLong",
				Long.class, 2017L);
		System.out.println(result_Long);
		float result_float = yarClient.call(
				"http://127.0.0.1:8003/openapi/yarserver/test", "testFloat",
				float.class, 3.14f);
		System.out.println(result_float);
		double result_double = yarClient.call(
				"http://127.0.0.1:8003/openapi/yarserver/test", "testDouble",
				double.class, 3.14);
		System.out.println(result_double);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		List result_list = yarClient.call(
				"http://127.0.0.1:8003/openapi/yarserver/test", "testList",
				List.class, list);
		System.out.println(result_list);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("year", 2017);
		Map result_map = yarClient.call(
				"http://127.0.0.1:8003/openapi/yarserver/test", "testMap",
				Map.class, map);
		System.out.println(result_map.get("year"));
	}
}
