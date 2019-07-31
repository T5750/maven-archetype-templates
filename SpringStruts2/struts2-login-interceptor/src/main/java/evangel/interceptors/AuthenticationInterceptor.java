package evangel.interceptors;

import java.io.File;
import java.util.Map;

import evangel.models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationInterceptor implements Interceptor {
	private static final long serialVersionUID = -5011962009065225959L;

	@Override
	public void destroy() {
		// release resources here
	}

	@Override
	public void init() {
		// create resources here
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("inside auth interceptor");
		Map<String, Object> sessionAttributes = actionInvocation
				.getInvocationContext().getSession();
		User user = (User) sessionAttributes.get("USER");
		if (user == null) {
			// 获取HttpServletRequest对象
			HttpServletRequest req = ServletActionContext.getRequest();
			// 获取此请求的地址，请求地址包含application name，进行subString操作，去除application name
			// String path = req.getRequestURI().substring(10);
			String path = req.getRequestURI();
			String contextPath = req.getContextPath();
			if (path.contains(contextPath)) {
				path = path.replace(contextPath, "");
			}
			// 获得请求中的参数
			String queryString = req.getQueryString();
			// 预防空指针
			if (queryString == null) {
				queryString = "";
			}
			// 拼凑得到登录之前的地址
			String realPath = path + "?" + queryString;
			ActionContext context = actionInvocation.getInvocationContext();
			// 获取session
			Map<String, Object> session = context.getSession();
			// 存入session，方便调用
			session.put("prePage", realPath);
			return Action.LOGIN;
		} else {
			Action action = (Action) actionInvocation.getAction();
			if (action instanceof UserAware) {
				((UserAware) action).setUser(user);
			}
			return actionInvocation.invoke();
		}
	}
}
