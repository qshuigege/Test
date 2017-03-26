package mianshi;

class People{
	public String name;
}

public class Main {
	public static void main(String[] args) {
		People p1 = new People();
		p1.name = "zhangsan";
		
		People p2 = new People();
		p2.name = "lisi";
		
		new Main().m(p1, p2);
		
		System.out.println(p1.name);
		System.out.println(p2.name);
	}
	
	public void m(People p1, People p2){
		People temp;
		temp = p1;
		p1 = p2;
		p2 = temp;
	}
	
	
	
}


