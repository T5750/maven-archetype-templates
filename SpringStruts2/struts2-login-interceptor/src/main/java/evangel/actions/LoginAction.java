package evangel.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import evangel.models.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements SessionAware,
		ModelDriven<User> {
	private static final long serialVersionUID = -3369875299120377549L;
	// 登录前页面
	private String prePage;

	@Override
	public String execute() {
		System.out.println("inside execute");
		String namePassword = "admin";
		if (namePassword.equals(user.getUser())
				&& namePassword.equals(user.getPassword())) {
			user.setUserName(namePassword);
			sessionAttributes.put("USER", user);
			// 获取跳转到登陆界面之前的页面地址，由拦截器提供
			prePage = (String) sessionAttributes.get("prePage");
			// 清除session中的数据
			sessionAttributes.remove("prePage");
			if (prePage == null) {
				return "welcome";
			} else {
				return SUCCESS;
			}
		}
		return INPUT;
	}

	private User user = new User();
	private Map<String, Object> sessionAttributes = null;

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	@Override
	public User getModel() {
		return user;
	}

	public String logout() {
		sessionAttributes.remove("USER");
		return SUCCESS;
	}

	public String getPrePage() {
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
}
