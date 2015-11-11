package hello;

public class Person {

    private final long id;
    private final String name, surname;
	private final int age;

    public Person(long id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
		this.surname = surname;
		this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name; //+ " " + surname + ", " + age "ani.";
    }
	public String getSurname() {
        return surname;
	}
	public int getAge() {
        return age;
	}
}
