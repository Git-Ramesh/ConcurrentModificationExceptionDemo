import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class Test3 {

	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<>();
		List<Integer> list = new CopyOnWriteArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);

		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			Integer num = itr.next();
			if (num % 2 == 0) {
				// When using CopyOnWriteArrayList java.lang.UnsupportedOperationException
				// itr.remove(); 
				list.remove(num); //  java.util.ConcurrentModificationException
			}
		}
		System.out.println(list);

//		Map<Integer, Integer> map = new HashMap<>();
//		Map<Integer, Integer> map = new ConcurrentHashMap<>();
//		for (int i = 1; i <= 10; i++) {
//			map.put(i, i * 2);
//		}
//		System.out.println(map);
////		map.forEach((key, value) -> {
////			if(key % 2 == 0) {
////				map.remove(key); // java.util.ConcurrentModificationException
////			}
////		});
//		Iterator<Integer> itr = map.keySet().iterator();
//		while (itr.hasNext()) {
//			Integer key = itr.next();
//			if (key % 2 == 0) {
////				itr.remove();
//				map.remove(key); // java.util.ConcurrentModificationException
//			}
//		}
//		System.out.println(map);

	}

	private static final void sleep(long timeout, TimeUnit timeUnit) {
		try {
			timeUnit.sleep(timeout);
		} catch (InterruptedException e) {
			// Ignore...
		}
	}
}
