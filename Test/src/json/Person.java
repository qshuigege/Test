package json;

import java.math.BigDecimal;
import java.util.Date;

public class Person {
	private BigDecimal bd = new BigDecimal(-1);
	private String name; 
	private Integer age; 
	private Date birthday; 
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public BigDecimal getBd() {
		return bd;
	}
	public void setBd(BigDecimal bd) {
		this.bd = bd;
	}
	@Override
	public String toString() {
		return "Person [bd=" + bd + ", name=" + name + ", age=" + age
				+ ", birthday=" + birthday + ", gender=" + gender + "]";
	}

	
	
}
