import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Scanner;

public class Program {

	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int NUMBERS_IN_SET = 10;
	private static final int MAX_RANGE_NUMBER = 100;

	public Program() {
		Scanner scanner = new Scanner(System.in);

		// Creating 3 groups & showing the values

		GroupSet<Integer> group1 = this.createRandomGroup();
		GroupSet<Integer> group2 = this.createRandomGroup();
		GroupSet<Integer> group3 = this.createRandomGroup();

		System.out.println("Group1: " + group1.toString());
		System.out.println("Group2: " + group2.toString());
		System.out.println("Group3: " + group3.toString());

		group1.union(group2);
		System.out.println();
		System.out.println("Union of Group1 and Group2: " + group1.toString());

		group1.intersect(group3);
		System.out.println();
		System.out.println("Intersection of unified Group1 and Group3: " + group1.toString());

		// Scan 2 numbers and create a group4th group
		
		GroupSet<Integer> group4 = new GroupSet<Integer>();
		
		this.scanAndAddToGroup(group4, scanner);
		this.scanAndAddToGroup(group4, scanner);

		// Showing if the group4th group is a subgroup of any of the other groups
		
		
		if (group1.isSubset(group4) == true) {
			System.out.println("Group4 is a subset of Group1");
		}

		if (group2.isSubset(group4) == true) {
			System.out.println("Group4 is a subset of Group2");
		}

		if (group3.isSubset(group4) == true) {
			System.out.println("Group4 is a subset of Group3");
		}

		// Scanning a number and checking if its a member of group1

		int aNum = scanNumber(scanner);

		if (group1.isMember(new Integer(aNum)) == true) {
			System.out.println("The number: " + aNum + " is a member of Group1");
		} else {
			System.out.println("The number: " + aNum + " is not a member of Group1");
		}

		// Adding it to group2

		System.out.println("Adding " + aNum + " to Group2");
		group2.insert(new Integer(aNum));
		System.out.println("Result: " + group2.toString());

		// Removing it from Group3
		System.out.println("Removing " + aNum + " from Group3");
		group3.delete(new Integer(aNum));
		System.out.println("Result: " + group3.toString());

		// Creating a group set of Person and adding 5 objects to it

		GroupSet<Person> group5 = new GroupSet<Person>();

		group5.insert(new Person(26, 305512402, "Eliran"));
		group5.insert(new Person(21, 305512403, "Yonatan"));
		group5.insert(new Person(40, 305512404, "Moti"));
		group5.insert(new Person(11, 305512405, "Talia"));
		group5.insert(new Person(24, 305512406, "Adi"));

		System.out.println(group5);

		// Showing min Person
		System.out.println("The minimum Person is :" + this.minMember(group5));

	}

	public GroupSet<Integer> createRandomGroup() {
		GroupSet<Integer> aSet = new GroupSet<Integer>();

		for (int i = 0; i < NUMBERS_IN_SET; i++) {
			Integer aNumber = new Integer(randomNumbers.nextInt(MAX_RANGE_NUMBER));
			// Insert into group if doesn't exists, if it does iterate group1 more time
			if (aSet.isMember(aNumber) == true) {
				i--;
			} else {
				aSet.insert(aNumber);
			}
		}

		return aSet;

	}

	public void scanAndAddToGroup(GroupSet<Integer> aSet, Scanner scanner) {

		int aNum = scanNumber(scanner);

		while (aSet.insert(new Integer(aNum)) == false) {
			System.out.print("Number already exists, ");
			aNum = scanNumber(scanner);
		}

	}

	public int scanNumber(Scanner scanner) {
		int aNum;
		System.out.print("Enter number:");
		aNum = scanner.nextInt();

		return aNum;

	}

	public <T extends Comparable<T>> T minMember(GroupSet<T> aSet) {
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
