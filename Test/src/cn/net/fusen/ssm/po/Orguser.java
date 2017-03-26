package cn.net.fusen.ssm.po;

import java.util.Date;

public class Orguser {
	private String id; 
	private String userno; 
	private String userid; 
	private String username; 
	private Integer orderindex; 
	private String password; 
	private Integer closed; 
	private String departmentid; 
	private String roleid; 
	private Integer ismanager; 
	private String workcanlendar; 
	private String position_no; 
	private String position_name; 
	private String position_layer; 
	private String officetel; 
	private String officefax; 
	private String mobile; 
	private String email; 
	private String userip; 
	private Integer issinglelogin; 
	private String work_status; 
	private Integer sessiontime; 
	private String outerid; 
	private String ext1; 
	private String ext2; 
	private String ext3; 
	private String ext4; 
	private String ext5; 
	private Date zcsj; 
	private String hylx; 
	private String qyqc; 
	private String qyjc; 
	private String khh; 
	private String yhzh; 
	private String gszch; 
	private String zjjgh; 
	private String ybnsrh; 
	private String zcdz; 
	private String frxm; 
	private String frdh; 
	private String frsfzh; 
	private String yyzzfj; 
	private String lxr; 
	private String lxrsj; 
	private String lxrdh; 
	private String lxrcz; 
	private String qtfj; 
	private String bz; 
	private String khbm; 
	private String fskhbm; 
	private String khmc; 
	private String ywlx; 
	private String jkswzy; 
	private String jkswzymobile; 
	private String jkswzyemail; 
	private String jkywy; 
	private String jkywymobile; 
	private String jkywyemail; 
	private String sfyx; 
	private String basb001oid;
	
	
	//关联属性
	private String departmentno;
	private String departmentname;
	
	private String rolename;
	
	
	public Orguser(){};
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
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
	public Integer getOrderindex() {
		return orderindex;
	}
	public void setOrderindex(Integer orderindex) {
		this.orderindex = orderindex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getClosed() {
		return closed;
	}
	public void setClosed(Integer closed) {
		this.closed = closed;
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
	public Integer getIsmanager() {
		return ismanager;
	}
	public void setIsmanager(Integer ismanager) {
		this.ismanager = ismanager;
	}
	public String getWorkcanlendar() {
		return workcanlendar;
	}
	public void setWorkcanlendar(String workcanlendar) {
		this.workcanlendar = workcanlendar;
	}
	public String getPosition_no() {
		return position_no;
	}
	public void setPosition_no(String position_no) {
		this.position_no = position_no;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getPosition_layer() {
		return position_layer;
	}
	public void setPosition_layer(String position_layer) {
		this.position_layer = position_layer;
	}
	public String getOfficetel() {
		return officetel;
	}
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	public String getOfficefax() {
		return officefax;
	}
	public void setOfficefax(String officefax) {
		this.officefax = officefax;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserip() {
		return userip;
	}
	public void setUserip(String userip) {
		this.userip = userip;
	}
	public Integer getIssinglelogin() {
		return issinglelogin;
	}
	public void setIssinglelogin(Integer issinglelogin) {
		this.issinglelogin = issinglelogin;
	}
	public String getWork_status() {
		return work_status;
	}
	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}
	public Integer getSessiontime() {
		return sessiontime;
	}
	public void setSessiontime(Integer sessiontime) {
		this.sessiontime = sessiontime;
	}
	public String getOuterid() {
		return outerid;
	}
	public void setOuterid(String outerid) {
		this.outerid = outerid;
	}
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	public String getExt3() {
		return ext3;
	}
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	public String getExt4() {
		return ext4;
	}
	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}
	public String getExt5() {
		return ext5;
	}
	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}
	public Date getZcsj() {
		return zcsj;
	}
	public void setZcsj(Date zcsj) {
		this.zcsj = zcsj;
	}
	public String getHylx() {
		return hylx;
	}
	public void setHylx(String hylx) {
		this.hylx = hylx;
	}
	public String getQyqc() {
		return qyqc;
	}
	public void setQyqc(String qyqc) {
		this.qyqc = qyqc;
	}
	public String getQyjc() {
		return qyjc;
	}
	public void setQyjc(String qyjc) {
		this.qyjc = qyjc;
	}
	public String getKhh() {
		return khh;
	}
	public void setKhh(String khh) {
		this.khh = khh;
	}
	public String getYhzh() {
		return yhzh;
	}
	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}
	public String getGszch() {
		return gszch;
	}
	public void setGszch(String gszch) {
		this.gszch = gszch;
	}
	public String getZjjgh() {
		return zjjgh;
	}
	public void setZjjgh(String zjjgh) {
		this.zjjgh = zjjgh;
	}
	public String getYbnsrh() {
		return ybnsrh;
	}
	public void setYbnsrh(String ybnsrh) {
		this.ybnsrh = ybnsrh;
	}
	public String getZcdz() {
		return zcdz;
	}
	public void setZcdz(String zcdz) {
		this.zcdz = zcdz;
	}
	public String getFrxm() {
		return frxm;
	}
	public void setFrxm(String frxm) {
		this.frxm = frxm;
	}
	public String getFrdh() {
		return frdh;
	}
	public void setFrdh(String frdh) {
		this.frdh = frdh;
	}
	public String getFrsfzh() {
		return frsfzh;
	}
	public void setFrsfzh(String frsfzh) {
		this.frsfzh = frsfzh;
	}
	public String getYyzzfj() {
		return yyzzfj;
	}
	public void setYyzzfj(String yyzzfj) {
		this.yyzzfj = yyzzfj;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getLxrsj() {
		return lxrsj;
	}
	public void setLxrsj(String lxrsj) {
		this.lxrsj = lxrsj;
	}
	public String getLxrdh() {
		return lxrdh;
	}
	public void setLxrdh(String lxrdh) {
		this.lxrdh = lxrdh;
	}
	public String getLxrcz() {
		return lxrcz;
	}
	public void setLxrcz(String lxrcz) {
		this.lxrcz = lxrcz;
	}
	public String getQtfj() {
		return qtfj;
	}
	public void setQtfj(String qtfj) {
		this.qtfj = qtfj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getFskhbm() {
		return fskhbm;
	}
	public void setFskhbm(String fskhbm) {
		this.fskhbm = fskhbm;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public String getYwlx() {
		return ywlx;
	}
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	public String getJkswzy() {
		return jkswzy;
	}
	public void setJkswzy(String jkswzy) {
		this.jkswzy = jkswzy;
	}
	public String getJkswzymobile() {
		return jkswzymobile;
	}
	public void setJkswzymobile(String jkswzymobile) {
		this.jkswzymobile = jkswzymobile;
	}
	public String getJkswzyemail() {
		return jkswzyemail;
	}
	public void setJkswzyemail(String jkswzyemail) {
		this.jkswzyemail = jkswzyemail;
	}
	public String getJkywy() {
		return jkywy;
	}
	public void setJkywy(String jkywy) {
		this.jkywy = jkywy;
	}
	public String getJkywymobile() {
		return jkywymobile;
	}
	public void setJkywymobile(String jkywymobile) {
		this.jkywymobile = jkywymobile;
	}
	public String getJkywyemail() {
		return jkywyemail;
	}
	public void setJkywyemail(String jkywyemail) {
		this.jkywyemail = jkywyemail;
	}
	public String getSfyx() {
		return sfyx;
	}
	public void setSfyx(String sfyx) {
		this.sfyx = sfyx;
	}
	public String getBasb001oid() {
		return basb001oid;
	}
	public void setBasb001oid(String basb001oid) {
		this.basb001oid = basb001oid;
	}
	public String getDepartmentno() {
		return departmentno;
	}
	public void setDepartmentno(String departmentno) {
		this.departmentno = departmentno;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "Orguser [id=" + id + ", userno=" + userno + ", userid="
				+ userid + ", username=" + username + ", orderindex="
				+ orderindex + ", password=" + password + ", closed=" + closed
				+ ", departmentid=" + departmentid + ", roleid=" + roleid
				+ ", ismanager=" + ismanager + ", workcanlendar="
				+ workcanlendar + ", position_no=" + position_no
				+ ", position_name=" + position_name + ", position_layer="
				+ position_layer + ", officetel=" + officetel + ", officefax="
				+ officefax + ", mobile=" + mobile + ", email=" + email
				+ ", userip=" + userip + ", issinglelogin=" + issinglelogin
				+ ", work_status=" + work_status + ", sessiontime="
				+ sessiontime + ", outerid=" + outerid + ", ext1=" + ext1
				+ ", ext2=" + ext2 + ", ext3=" + ext3 + ", ext4=" + ext4
				+ ", ext5=" + ext5 + ", zcsj=" + zcsj + ", hylx=" + hylx
				+ ", qyqc=" + qyqc + ", qyjc=" + qyjc + ", khh=" + khh
				+ ", yhzh=" + yhzh + ", gszch=" + gszch + ", zjjgh=" + zjjgh
				+ ", ybnsrh=" + ybnsrh + ", zcdz=" + zcdz + ", frxm=" + frxm
				+ ", frdh=" + frdh + ", frsfzh=" + frsfzh + ", yyzzfj="
				+ yyzzfj + ", lxr=" + lxr + ", lxrsj=" + lxrsj + ", lxrdh="
				+ lxrdh + ", lxrcz=" + lxrcz + ", qtfj=" + qtfj + ", bz=" + bz
				+ ", khbm=" + khbm + ", fskhbm=" + fskhbm + ", khmc=" + khmc
				+ ", ywlx=" + ywlx + ", jkswzy=" + jkswzy + ", jkswzymobile="
				+ jkswzymobile + ", jkswzyemail=" + jkswzyemail + ", jkywy="
				+ jkywy + ", jkywymobile=" + jkywymobile + ", jkywyemail="
				+ jkywyemail + ", sfyx=" + sfyx + ", basb001oid=" + basb001oid
				+ ", departmentno=" + departmentno + ", departmentname="
				+ departmentname + ", rolename=" + rolename + "]";
	}
	
	
}
