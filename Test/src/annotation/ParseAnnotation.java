package annotation;

public class ParseAnnotation {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("annotation.Person");
			if (clazz.isAnnotationPresent(AnnotationTest.class)) {
				AnnotationTest a = (AnnotationTest)clazz.getAnnotation(AnnotationTest.class);
				System.out.println("注解描述：" + a.Hello());
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("出现异常！");
			e.printStackTrace();
		}
	}
}
