package cn.net.fusen.ssm.po;

public class User {
	private String id; 
	private String userid; 
	private String username; 
	private String password; 
	private String departmentid; 
	private String roleid;
	private String pwd;
	
	public User(){}
	public User(String id, String userid, String username, String password, String departmentid, String roleid, String pwd) {
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.departmentid = departmentid;
		this.roleid = roleid;
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
