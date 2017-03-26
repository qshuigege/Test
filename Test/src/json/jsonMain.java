package json;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jsonMain extends Date{
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		p.setBirthday(new Date());
		
		/*Pet pet = new Pet();
		pet.setName("xiaobai");
		pet.setColor("white");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("person", p);
		map.put("pet", pet);
		System.out.println(JSONUtils.toJson(map));*/
		
		System.out.println(JSONUtils.toJson(p));
		
		String json = "{\"bd\":-1,\"birthday\":\"2017-03-11 17:09:04\",\"gender\":\"\",\"name\":\"\"}";
		System.out.println(JSONUtils.jsonToObjectByGson(json, Person.class));
		
		
		
		/*
//		p.setName("Leslie");
		p.setAge(59);
//		p.setGender("男");
		
		Gson gson = new Gson();
		String json = gson.toJson(p);
		System.out.println(json);
		
		String s = JSONObject.fromObject(p).toString();
		System.out.println(s);*/
		
		/*List<Person> list = new ArrayList<Person>();
		list.add(new Person());
		list.add(new Person());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p1", new Person());
		map.put("p2", new Person());
		
//		System.out.println(JSONUtils.toJson(list));
		System.out.println(JSONUtils.toJson(list));
		System.out.println(JSONUtils.toJson(p));
//		System.out.println(JSONUtils.toJson(map));
//		System.out.println(JSONUtils.toJson(new Date()));
*/		
		/*Date date = new Date();
		System.out.println(new Date());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateStr = formatter.format(date);
		
		System.out.println(dateStr);
		date = formatter.parse(dateStr);
		System.out.println(date);*/
	}
}
