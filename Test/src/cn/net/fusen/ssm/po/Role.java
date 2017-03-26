package cn.net.fusen.ssm.po;

public class Role {
	private String id;
	private String rolename;
	private String categoryname;
	private String roledesc;

	public Role(){}
	public Role(String id, String rolename, String categoryname, String roledesc) {
		this.id = id;
		this.rolename = rolename;
		this.categoryname = categoryname;
		this.roledesc = roledesc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getRoledesc() {
		return roledesc;
	}
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
	
	
}
