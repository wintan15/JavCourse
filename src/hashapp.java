import java.util.Objects;
import java.lang.System;
import java.util.ArrayList;

class Person extends Object{
	private int age;
	private String name;
	private boolean gender;
	private String email;
	Person(int age, String name, boolean gender, String email){
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}
	public int getAge() {
		return this.age;
	}
	public String getName() {
		return this.name;
	}
	public boolean getGender() {
		return this.gender;
	}
	public int hashCode() {
		return this.age * (this.gender ? 2:1) * (this.name.hashCode() + 3) * this.email.hashCode();		
	}
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Person p = (Person) o;
		return (this.name.equals(p.getName()) && this.age == p.getAge() && 
				this.gender == p.getGender() && this.email.equals(p.getEmail()));		
	}
}

class PersonComp{
	private int age;
	private String name;
	private String email;
	private boolean gender;
	PersonComp(int age, String name, boolean gender, String email){
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	public int getAge() {
		return this.age;
	}
	public String getName() {
		return this.name;
	}
	public boolean getGender() {
		return this.gender;
	}
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        PersonComp p = (PersonComp) o;
		return (this.name.equals(p.getName()) && this.age == p.getAge() && 
				this.gender == p.getGender() && this.email.equals(p.getEmail()));		
	}
}

public class hashapp {
	public static void main(String[] args) {
		long pt;
		ArrayList<Person> hashed = new ArrayList<Person>();
		ArrayList<PersonComp> unhashed = new ArrayList<PersonComp>();
		for(int i = 0; i<1000; i++) {
			hashed.add(new Person(i, "t", true, "2@t.com"));
			unhashed.add(new PersonComp(i, "t", true, "2@t.com"));
		}
		pt = System.nanoTime();
		Person targetPerson = new Person(950, "t", true, "2@t.com");
		System.out.println(hashed.contains(targetPerson));
		System.out.println(hashed.contains(targetPerson));
		System.out.println(hashed.contains(targetPerson));
		System.out.println(hashed.contains(targetPerson));
		System.out.println(hashed.contains(targetPerson));
		System.out.println("Hashed: " + String.valueOf(System.nanoTime()-pt));
		pt = System.nanoTime();
		PersonComp targetPc = new PersonComp(950, "t", true, "2@t.com");
		System.out.println(unhashed.contains(targetPc));
		System.out.println(unhashed.contains(targetPc));
		System.out.println(unhashed.contains(targetPc));
		System.out.println(unhashed.contains(targetPc));
		System.out.println(unhashed.contains(targetPc));
		System.out.println("Unhashed: " + String.valueOf(System.nanoTime()-pt));
	}

}
