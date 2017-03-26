package db;

public class B2bLogger {
	private String logid;
	private String logtime;
	private String webserviceno;
	private String params;
	private String operationtype;
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	public String getWebserviceno() {
		return webserviceno;
	}
	public void setWebserviceno(String webserviceno) {
		this.webserviceno = webserviceno;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getOperationtype() {
		return operationtype;
	}
	public void setOperationtype(String operationtype) {
		this.operationtype = operationtype;
	}
	@Override
	public String toString() {
		return "B2bLogger [logid=" + logid + ", logtime=" + logtime
				+ ", webserviceno=" + webserviceno + ", params=" + params
				+ ", operationtype=" + operationtype + "]";
	}
	
	
}
