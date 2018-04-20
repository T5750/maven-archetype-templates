package com.admin.domain.repository;

import java.util.List;

import com.admin.domain.model.SysLog;

/**
 * @author Jonsy
 *
 */
public interface SysLogRepository {
	void add(SysLog sysLog);

	List<SysLog> list();

	void clear();
}
