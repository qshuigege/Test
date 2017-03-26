package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			final int ii = i;
			pool.execute(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < 3; j++) {
						System.out.println(Thread.currentThread().getName()+" is looping of "+j+" task of "+ii);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
		pool.shutdown();
	}
}
