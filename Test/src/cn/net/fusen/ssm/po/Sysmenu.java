package cn.net.fusen.ssm.po;

public class Sysmenu {
	private String id;
	private String menuname; 
	private String parentid; 
	private String linkurl;
	private String menudesc; 
	private String menulevel;
	//private Sysmenu parent;
	private Sysmenu[] children;
	
	public Sysmenu(){}
	
	public Sysmenu(String id, String menuname, String parentid, String linkurl,
			String menudesc, String menulevel, Sysmenu[] children) {
		this.id = id;
		this.menuname = menuname;
		this.parentid = parentid;
		this.linkurl = linkurl;
		this.menudesc = menudesc;
		this.menulevel = menulevel;
		this.children = children;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getLinkurl() {
		return linkurl;
	}
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	public String getMenudesc() {
		return menudesc;
	}
	public void setMenudesc(String menudesc) {
		this.menudesc = menudesc;
	}
	public String getMenulevel() {
		return menulevel;
	}
	public void setMenulevel(String menulevel) {
		this.menulevel = menulevel;
	}

	public Sysmenu[] getChildren() {
		return children;
	}

	public void setChildren(Sysmenu[] children) {
		this.children = children;
	}
	
	
}
