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

		GroupSet<Integer> one = this.createRandomGroup();
		GroupSet<Integer> two = this.createRandomGroup();
		GroupSet<Integer> three = this.createRandomGroup();
		GroupSet<Integer> four = new GroupSet<Integer>();

		System.out.println("G1: " + one.toString());
		System.out.println("G2: " + two.toString());
		System.out.println("G3: " + three.toString());

		one.union(two);
		System.out.println();
		System.out.println("Union of G1 and G2: " + one.toString());

		one.intersect(three);
		System.out.println();
		System.out.println("Intersection of unified G1 and G3: " + one.toString());

		// Scan 2 numbers and create a fourth group
		this.scanAndAddToGroup(four, scanner);
		this.scanAndAddToGroup(four, scanner);

		// Showing if the fourth group is a subgroup of any of the other groups
		if (one.isSubset(four) == true) {
			System.out.println("G4 is a subset of G1");
		}

		if (two.isSubset(four) == true) {
			System.out.println("G4 is a subset of G2");
		}

		if (three.isSubset(four) == true) {
			System.out.println("G4 is a subset of G3");
		}

		// Scanning a number and checking if its a member of G1

		int aNum = scanNumber(scanner);

		if (one.isMember(new Integer(aNum)) == true) {
			System.out.println("The number: " + aNum + " is a member of G1");
		} else {
			System.out.println("The number: " + aNum + " is not a member of G1");
		}

		// Adding it to G2

		System.out.println("Adding " + aNum + " to G2");
		two.insert(new Integer(aNum));
		System.out.println("Result: " + two.toString());

		// Removing it from G3
		System.out.println("Removing " + aNum + " from G3");
		three.delete(new Integer(aNum));
		System.out.println("Result: " + three.toString());

		// Creating a group set of Person and adding 5 objects to it

		GroupSet<Person> five = new GroupSet<Person>();

		five.insert(new Person(26, 305512402, "Eliran"));
		five.insert(new Person(21, 305512403, "Yonatan"));
		five.insert(new Person(40, 305512404, "Moti"));
		five.insert(new Person(11, 305512405, "Talia"));
		five.insert(new Person(24, 305512406, "Adi"));

		System.out.println(five);

		// Showing min Person
		System.out.println("The minimum Person is :" + this.minMember(five));

	}

	public GroupSet<Integer> createRandomGroup() {
		GroupSet<Integer> aSet = new GroupSet<Integer>();

		for (int i = 0; i < NUMBERS_IN_SET; i++) {
			Integer aNumber = new Integer(randomNumbers.nextInt(MAX_RANGE_NUMBER));
			// Insert into group if doesn't exists, if it does iterate one more time
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
