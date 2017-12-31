import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GroupSet<T> {

	private ArrayList<T> genericSet;

	public GroupSet() {
		this.genericSet = new ArrayList<T>();
	}

	public void union(GroupSet<T> aSet) {

		Iterator<T> it = aSet.iterator();

		while (it.hasNext()) {
			this.insert(it.next());
		}

	}

	public void intersect(GroupSet<T> aSet) {

		Iterator<T> it = aSet.iterator();
		ArrayList<T> intersectSet = new ArrayList<T>();

		while (it.hasNext()) {

			T aMember = it.next();

			if (genericSet.contains(aMember) == true) {
				intersectSet.add(aMember);
			}

		}

		this.genericSet = intersectSet;

	}

	public boolean isSubset(GroupSet<T> aSet) {

		Iterator<T> it = aSet.iterator();

		while (it.hasNext()) {

			if (this.genericSet.contains(it.next()) == false) {
				return false;
			}

		}
		return true;
	}

	public boolean isMember(T aMember) {
		return this.genericSet.contains(aMember);
	}

	public void insert(T aMember) {
		if (this.genericSet.contains(aMember) == false) {
			this.genericSet.add(aMember);
		}
	}

	public void delete(T aMember) {

		if (this.genericSet.contains(aMember) == false) {
			this.genericSet.remove(aMember);
		}

	}

	public Iterator<T> iterator() {

		return this.genericSet.iterator();

	}

}
