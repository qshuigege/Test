package reflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReflectMain {
	public static void main(String[] args) throws Exception{
//		testReflect();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Leslie");
		map.put("age", 59);
		System.out.println(map);
		Set set = map.keySet();
		Iterator iter = set.iterator();
		/*int len = set.size();
		for (int i = 0; i < len; i++) {
			
		}*/
		while (iter.hasNext()) {
			String key = (String)iter.next();
			Object value = map.get(key);
			System.out.println(value);
		}
		map.remove("age");
		System.out.println(map);
	}

	private static void testReflect() throws IllegalAccessException {
		Class clazz = Person.class;
		Field[] fields = clazz.getDeclaredFields();
		Person p = new Person();
		p.setName("Leslie");
		p.setAge(59);
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			System.out.println(fields[i].getName());
			System.out.println(fields[i].get(p));
		}
	}
}
