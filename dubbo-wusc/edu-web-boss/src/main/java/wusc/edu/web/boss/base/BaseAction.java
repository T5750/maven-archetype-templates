package wusc.edu.web.boss.base;

import wusc.edu.facade.user.entity.PmsUser;
import wusc.edu.web.common.constant.SessionConstant;
import wusc.edu.web.common.struts.Struts2ActionSupport;

/**
 * 
 * @描述: Web系统权限模块基础支撑Action.
 * @作者: WuShuicheng.
 * @创建: 2014-8-13,下午5:19:28
 * @版本: V1.0
 * 
 */
@SuppressWarnings("serial")
public class BaseAction extends Struts2ActionSupport
		implements UserLoginedAware {
	/**
	 * 取出当前登录用户对象
	 */
	@Override
	public PmsUser getLoginedUser() {
		PmsUser user = (PmsUser) this.getSessionMap()
				.get(SessionConstant.USER_SESSION_KEY);
		return user;
	}
}
