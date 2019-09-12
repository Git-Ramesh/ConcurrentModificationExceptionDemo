import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);
		Iterator<Integer> itr = numbers.iterator();
		Thread t1 = new Thread(() -> {
			sleep(2, TimeUnit.SECONDS);
			System.out.println(Thread.currentThread().getName() + " " + "adding item");
			numbers.add(11);
		});
		t1.start();
		System.out.println(Thread.currentThread().getName() + " " + "iterating");
		while (itr.hasNext()) {
			Integer number = itr.next();
			if (number % 2 == 0) {
				itr.remove();
			}
			sleep(1, TimeUnit.SECONDS);
		}
		System.out.println(numbers);
	}

	private static final void sleep(long timeout, TimeUnit timeUnit) {
		try {
			timeUnit.sleep(timeout);
		} catch (InterruptedException e) {
			// Ignore...
		}
	}
}
