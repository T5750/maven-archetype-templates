package com.herohuang.doctor.dto;

public class Canal {
	private String tableName;
	private String cacheKey;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getCacheKey() {
		return cacheKey;
	}

	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}

	public Canal(String tableName, String cacheKey) {
		this.tableName = tableName;
		this.cacheKey = cacheKey;
	}

	public Canal() {
	}
}