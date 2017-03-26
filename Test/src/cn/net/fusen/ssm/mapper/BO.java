package cn.net.fusen.ssm.mapper;

import java.io.Serializable;

public class BO implements Serializable{
	private String  ERPUSEROID;
	private Integer MINONO;
	private Integer MAXONO;
	
	
	private String psorder;
	
	public BO(){}

	public String getERPUSEROID() {
		return ERPUSEROID;
	}

	public void setERPUSEROID(String eRPUSEROID) {
		ERPUSEROID = eRPUSEROID;
	}

	public Integer getMINONO() {
		return MINONO;
	}

	public void setMINONO(Integer mINONO) {
		MINONO = mINONO;
	}

	public Integer getMAXONO() {
		return MAXONO;
	}

	public void setMAXONO(Integer mAXONO) {
		MAXONO = mAXONO;
	}

	public String getPsorder() {
		return psorder;
	}

	public void setPsorder(String psorder) {
		this.psorder = psorder;
	}
	
	
}
