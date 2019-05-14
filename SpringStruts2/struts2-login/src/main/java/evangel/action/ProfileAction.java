package evangel.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class ProfileAction {
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String s = (String) session.getAttribute("login");
		if (s != null && !s.equals("")) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
