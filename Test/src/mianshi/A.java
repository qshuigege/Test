package mianshi;

public class A {
	public void m1(String s1, String s2){
		String temp;
		temp = s1;
		s1 = s2;
		s2 = temp;
		s1=new String();s1 = "aaa";
		s2=new String();s2 = "bbb";
	}
	
	public void m2(Person p1, Person p2){
		Person temp;
		temp = p1;
		p1 = p2;
		p2 = temp;
		
		p1.setName("zhangsansan");
		p2.setName("lisisi");
	}
	
	public void m3(String str){
		str="哈哈";
	}
}
