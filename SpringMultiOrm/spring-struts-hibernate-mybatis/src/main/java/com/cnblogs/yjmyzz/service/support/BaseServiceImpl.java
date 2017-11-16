package com.cnblogs.yjmyzz.service.support;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.mybatis.spring.SqlSessionUtils;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public class BaseServiceImpl implements Serializable {
	private static final long serialVersionUID = -33988360094493502L;
	/**
	 * hibernate入口
	 */
	@Resource(name = "sessionFactory")
	protected SessionFactory hibernateSessionFactory;
	/**
	 * mybatis入口
	 */
	@Resource(name = "sqlSessionFactory")
	protected SqlSessionFactory mybatisSessionFactory;

	protected Session openSession() {
		return hibernateSessionFactory.openSession();
	}

	protected StatelessSession openStatelessSession() {
		return hibernateSessionFactory.openStatelessSession();
	}

	protected Session getCurrentSession() {
		return hibernateSessionFactory.getCurrentSession();
	}

	/**
	 * 查询分页数据(mybatis实现)
	 * 
	 * @param mapperClass
	 * @param sqlId
	 * @param sqlParameter
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	protected List<?> getPageList(Class<?> mapperClass, String sqlId,
			Object sqlParameter, int pageIndex, int pageSize) throws Exception {
		SqlSession session = null;
		try {
			session = SqlSessionUtils.getSqlSession(mybatisSessionFactory);
			if (pageIndex <= 0) {
				pageIndex = 1;
			}
			if (pageSize <= 0) {
				pageSize = 10;
			}
			PageBounds pageBounds = new PageBounds(pageIndex, pageSize);
			return session.selectList(mapperClass.getName() + "." + sqlId,
					sqlParameter, pageBounds);
		} finally {
			session.close();
		}
	}
}
