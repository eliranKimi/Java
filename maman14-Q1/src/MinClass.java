import java.util.Iterator;

public class MinClass {

	public static <T extends Comparable<T>> T minMember(GroupSet<T> aSet) {
		Iterator<T> it = aSet.iterator();
		T min = it.next();

		while (it.hasNext()) {
			T temp = it.next();
			if (min.compareTo(temp) > 0) {

				min = temp;

			}
		}

		return min;
	}

}
