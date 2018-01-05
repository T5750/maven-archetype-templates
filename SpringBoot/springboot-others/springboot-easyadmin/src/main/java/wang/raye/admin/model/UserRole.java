package wang.raye.admin.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserRole {
	private Integer userid;
	private Integer roleid;
	private Integer creater;
	private Date createTime;
}