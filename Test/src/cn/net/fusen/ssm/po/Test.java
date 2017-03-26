package cn.net.fusen.ssm.po;

import java.math.BigDecimal;
import java.util.Date;

public class Test {
	private String uuid;
	private String aaa;
	private BigDecimal bbb;
	private Date ccc;
	private char ddd;
	private Integer eee;
	public Test(){}
	public Test(String aaa, BigDecimal bbb, Date ccc, char ddd, Integer eee) {
		this.aaa = aaa;
		this.bbb = bbb;
		this.ccc = ccc;
		this.ddd = ddd;
		this.eee = eee;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getAaa() {
		return aaa;
	}
	public void setAaa(String aaa) {
		this.aaa = aaa;
	}
	public BigDecimal getBbb() {
		return bbb;
	}
	public void setBbb(BigDecimal bbb) {
		this.bbb = bbb;
	}
	public Date getCcc() {
		return ccc;
	}
	public void setCcc(Date ccc) {
		this.ccc = ccc;
	}
	public char getDdd() {
		return ddd;
	}
	public void setDdd(char ddd) {
		this.ddd = ddd;
	}
	public Integer getEee() {
		return eee;
	}
	public void setEee(Integer eee) {
		this.eee = eee;
	}
	@Override
	public String toString() {
		return "Test [uuid=" + uuid + ", aaa=" + aaa + ", bbb=" + bbb
				+ ", ccc=" + ccc + ", ddd=" + ddd + ", eee=" + eee + "]";
	}
	
}
