
public class Person implements Comparable<Person> {

	private int age;
	private int id;
	private String name;

	public Person(int age, int id, String name) {
		super();
		this.age = age;
		this.id = id;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {

		if (o.getAge() == this.getAge()) {
			return 0;
		} else {
			if (o.getAge() < this.getAge()) {
				return 1;
			} else {

				return -1;
			}
		}
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Person) {

			if (this.compareTo((Person) obj) == 0) {
				return true;
			}

		}
		return false;
	}

	@Override
	public String toString() {
		return "[age=" + age + ", id=" + id + ", name=" + name + "]";
	}

}
