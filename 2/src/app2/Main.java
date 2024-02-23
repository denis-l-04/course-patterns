package app2;

import java.time.LocalDate;
import static java.time.LocalDate.of;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Stream;

class Human {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private int age;
	private int weight;

	public Human (int age, String firstName, String lastName, LocalDate birthDate, int weight){
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.weight = weight;
	}

	public String toString(){
		return firstName+" "+lastName+", born at "+birthDate+" ("+age+" y. o.)";
	}

	public String getLastName(){
		return lastName;
	}
	public int getAge(){
		return age;
	}
	public LocalDate getBirthDate(){
		return birthDate;
	}
	public int getWeight(){
		return weight;
	}
}

public class Main {
	public static void main(String[] args) {
		LinkedList<Human> l = new LinkedList<Human>();
		l.add(new Human(19, "Daniil", "Litvinov", of(2004, 4, 11), 60));
		l.add(new Human(98, "Akakiy", "Rybin", of(1926, 1, 4), 70));
		l.add(new Human(8, "Boris", "Bondarev", of(2016, 8, 17), 40));
		l.add(new Human(35, "Friedrich", "Schumacher", of(1988, 12, 23), 71));
		l.add(new Human(64, "Steeve", "Rockwell", of(1960, 2, 22), 80));

		System.out.println("\tSort by last letter:");
		Stream<Human> s = l.stream();
		s.sorted(Comparator.comparingInt((a) -> a.getLastName().charAt(a.getLastName().length()-1))).forEach(System.out::println);

		System.out.println("\tAge > weight:");
		s = l.stream();
		s.filter((h) -> h.getAge() > h.getWeight()).forEach(System.out::println);

		System.out.println("\tSort by birth date:");
		s = l.stream();
		s.sorted((h1, h2) -> h2.getAge() - h1.getAge()) .forEach(System.out::println);

		System.out.println("\tAges production:");
		s = l.stream();
		System.out.println(s.map((h) -> Integer.valueOf(h.getAge())).reduce((a, b) -> a*b).get());
	}
}