import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class Test2 {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 1);
		map.put(3, 1);
		Thread t1 = new Thread(() -> {
			sleep(2, TimeUnit.SECONDS);
			
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " " + "adding item");
				map.put(i, i * i);
				sleep(500, TimeUnit.MILLISECONDS);
			}
		});
		t1.start();
		sleep(400, TimeUnit.MILLISECONDS);
		map.forEach((k, v) -> {
			System.out.println(Thread.currentThread().getName() + " " + "itr");
			System.out.println(k + "=" + v);
			sleep(600, TimeUnit.MILLISECONDS);
		});
		
		sleep(10, TimeUnit.SECONDS);
		System.out.println(map);
	}

	private static final void sleep(long timeout, TimeUnit timeUnit) {
		try {
			timeUnit.sleep(timeout);
		} catch (InterruptedException e) {
			// Ignore...
		}
	}
}
