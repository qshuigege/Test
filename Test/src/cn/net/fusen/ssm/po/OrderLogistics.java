package cn.net.fusen.ssm.po;

import java.util.Date;

public class OrderLogistics {
	private String Otype; //状态名称
	private Date   OTime; //状态时间
	private String ONo;   //状态序号
	private String Remark;//备注
	private String Refno;//单号
	
	public OrderLogistics(){}

	public String getOtype() {
		return Otype;
	}

	public void setOtype(String otype) {
		Otype = otype;
	}

	public Date getOTime() {
		return OTime;
	}

	public void setOTime(Date oTime) {
		OTime = oTime;
	}

	public String getONo() {
		return ONo;
	}

	public void setONo(String oNo) {
		ONo = oNo;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getRefno() {
		return Refno;
	}

	public void setRefno(String refno) {
		Refno = refno;
	}

	@Override
	public String toString() {
		return "OrderLogistics [Otype=" + Otype + ", OTime=" + OTime + ", ONo="
				+ ONo + ", Remark=" + Remark + ", Refno=" + Refno + "]";
	}
	
	
}
