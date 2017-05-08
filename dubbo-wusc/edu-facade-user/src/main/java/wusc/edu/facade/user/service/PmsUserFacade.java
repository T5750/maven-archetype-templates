/**
 * 
 */
package wusc.edu.facade.user.service;

import java.util.Map;

import wusc.edu.common.page.PageBean;
import wusc.edu.common.page.PageParam;
import wusc.edu.facade.user.entity.PmsUser;

/**
 * @描述: 用户Dubbo服务接口 .
 * @作者: WuShuicheng .
 * @创建时间: 2015-1-26,上午1:41:38 .
 * @版本号: V1.0 .
 */
public interface PmsUserFacade {
	/**
	 * 保存用户信息.
	 * 
	 * @param pmsUser
	 */
	public void create(PmsUser pmsUser);

	/**
	 * 根据ID获取用户信息.
	 * 
	 * @param userId
	 * @return
	 */
	public PmsUser getById(Long userId);

	/**
	 * 根据登录名取得用户对象
	 */
	public PmsUser findUserByUserNo(String userNo);

	/**
	 * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
	 * 
	 * @param userId
	 *            用户ID.
	 */
	public void deleteUserById(long userId);

	/**
	 * 更新用户信息.
	 * 
	 * @param user
	 */
	public void update(PmsUser user);

	/**
	 * 根据用户ID更新用户密码.
	 * 
	 * @param userId
	 * @param newPwd
	 *            (已进行SHA1加密)
	 */
	public void updateUserPwd(Long userId, String newPwd, boolean isTrue);

	/**
	 * 查询并分页列出用户信息.
	 * 
	 * @param pageParam
	 * @param paramMap
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
}
