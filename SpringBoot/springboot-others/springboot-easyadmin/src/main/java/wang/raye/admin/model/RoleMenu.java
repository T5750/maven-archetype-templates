package wang.raye.admin.model;

import java.util.Date;

import lombok.Data;

@Data
public class RoleMenu {
	private Integer menuid;
	private Integer roleid;
	private Integer flag;
	private Integer creater;
	private Date createTime;
}