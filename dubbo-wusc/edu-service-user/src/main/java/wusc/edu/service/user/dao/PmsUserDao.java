package wusc.edu.service.user.dao;

import wusc.edu.facade.user.entity.PmsUser;
import wusc.edu.service.user.common.core.dao.BaseDao;

/**
 * 
 * @描述: 用户表数据访问层接口.
 * @作者: WuShuicheng .
 * @创建时间: 2013-7-22,下午5:51:47 .
 * @版本: 1.0 .
 */
public interface PmsUserDao extends BaseDao<PmsUser> {
	/**
	 * 根据用户登录名获取用户信息.
	 * 
	 * @param loginName
	 *            .
	 * @return user .
	 */
	PmsUser findByUserNo(String userNo);
}
