package cn.net.fusen.ssm.po;

import java.util.Date;

public class ChengPinChuKu_addrInfo {
	
	
	private String GKWDEL01ADDOID;
	private Date CreDate;
	private String SendCom;
	private String SendAdd;
	private String SendDetailAdd;
	private String Att;
	private String Tel;
	private String GKWDEL01_FK;
	private String BASB001_FK;
	
	
	public ChengPinChuKu_addrInfo(){}
	
	
	public String getGKWDEL01ADDOID() {
		return GKWDEL01ADDOID;
	}
	public void setGKWDEL01ADDOID(String gKWDEL01ADDOID) {
		GKWDEL01ADDOID = gKWDEL01ADDOID;
	}
	public Date getCreDate() {
		return CreDate;
	}
	public void setCreDate(Date creDate) {
		CreDate = creDate;
	}
	public String getSendCom() {
		return SendCom;
	}
	public void setSendCom(String sendCom) {
		SendCom = sendCom;
	}
	public String getSendAdd() {
		return SendAdd;
	}
	public void setSendAdd(String sendAdd) {
		SendAdd = sendAdd;
	}
	public String getSendDetailAdd() {
		return SendDetailAdd;
	}
	public void setSendDetailAdd(String sendDetailAdd) {
		SendDetailAdd = sendDetailAdd;
	}
	public String getAtt() {
		return Att;
	}
	public void setAtt(String att) {
		Att = att;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getGKWDEL01_FK() {
		return GKWDEL01_FK;
	}
	public void setGKWDEL01_FK(String gKWDEL01_FK) {
		GKWDEL01_FK = gKWDEL01_FK;
	}
	public String getBASB001_FK() {
		return BASB001_FK;
	}
	public void setBASB001_FK(String bASB001_FK) {
		BASB001_FK = bASB001_FK;
	}


	@Override
	public String toString() {
		return "ChengPinChuKu_addrInfo [GKWDEL01ADDOID=" + GKWDEL01ADDOID
				+ ", CreDate=" + CreDate + ", SendCom=" + SendCom
				+ ", SendAdd=" + SendAdd + ", SendDetailAdd=" + SendDetailAdd
				+ ", Att=" + Att + ", Tel=" + Tel + ", GKWDEL01_FK="
				+ GKWDEL01_FK + ", BASB001_FK=" + BASB001_FK + "]";
	}
	
	
	
	
	
	
	
	
	
}
