package volatile_test;

public class TestMain {
	//private volatile String name;
	private String name;
	
	public static void main(String[] args) {
		final TestMain tm = new TestMain();
		final char[] z = new char[]{'z','h','a','n','g','x','i','a','o','x','i','a','n','g'};
		final char[] l = new char[]{'l','i','h','u','o','m','i','n','g'};
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				tm.name = "";
			}
		}).start();
	}
}
