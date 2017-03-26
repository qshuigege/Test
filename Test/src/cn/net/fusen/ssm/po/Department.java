package cn.net.fusen.ssm.po;

public class Department {
	private String id;
	private String departmentname;
	private String parentid;
	private String departmentdesc;
	
	
	public Department() {
	}
	public Department(String id, String departmentname, String parentid, String departmentdesc) {
		this.id = id;
		this.departmentname = departmentname;
		this.parentid = parentid;
		this.departmentdesc = departmentdesc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getDepartmentdesc() {
		return departmentdesc;
	}
	public void setDepartmentdesc(String departmentdesc) {
		this.departmentdesc = departmentdesc;
	}
	
	
}
