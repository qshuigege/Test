package cn.net.fusen.ssm.po;

public class UserOrder {
	
	private  String ORDA001OID;
	private  String FSNO;
	private  String ORDERSTATUS;
	private  String CUSTORDERNO;

	public  UserOrder(){}

	public String getORDA001OID() {
		return ORDA001OID;
	}

	public void setORDA001OID(String oRDA001OID) {
		ORDA001OID = oRDA001OID;
	}

	public String getFSNO() {
		return FSNO;
	}

	public void setFSNO(String fSNO) {
		FSNO = fSNO;
	}

	public String getORDERSTATUS() {
		return ORDERSTATUS;
	}

	public void setORDERSTATUS(String oRDERSTATUS) {
		ORDERSTATUS = oRDERSTATUS;
	}

	public String getCUSTORDERNO() {
		return CUSTORDERNO;
	}

	public void setCUSTORDERNO(String cUSTORDERNO) {
		CUSTORDERNO = cUSTORDERNO;
	}

	
	
}
