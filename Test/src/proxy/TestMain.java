package proxy;

import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class TestMain {
	public static void main(String[] args) {
		UserManagerImpl impl = new UserManagerImpl();
		MyHandler h = new MyHandler(impl);
		IUserManager ma = (IUserManager) Proxy.newProxyInstance(impl.getClass().getClassLoader(), impl.getClass().getInterfaces(), h);
		ma.addUser("", "");
		impl.addUser("", "");
		Entry<String,String> en;
		HashMap<String, String> map = (HashMap<String, String>) Collections.EMPTY_MAP;
		map.put("", "");
		System.out.println(23&(16-1));
		UserManagerImpl impl2 = new UserManagerImpl();
		System.out.println(impl);
		System.out.println(impl2);
	}
}
