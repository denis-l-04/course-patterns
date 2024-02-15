package app1;

import java.util.function.Predicate;

class Student {
	private String name;
	private int score;

	public Student(String name, int score){
		this.name=name;
		this.score=score;
	}

	public int getScore(){
		return score;
	}

	public String toString(){
		return name+": "+score;
	}
}

class MaxFinder implements Predicate<Student[]> {
	public boolean test(Student[] array){
		for (Student s : array){
			if (s.getScore() == 100)
				return true;
		}
		return false;
	}
}

public class Main {
	public static void main(String[] args) {
		Student[] a1 = {
			new Student("Анастасия", 57),
			new Student("Василий", 20),
			new Student("Григорий", 46),
			new Student("Пётр", 100),
			new Student("Вадим", 74),
			new Student("Андрей", 99)
		};
		Student[] a2 = {
			new Student("Георгий", 34),
			new Student("Борис", 28),
			new Student("Елена", 98),
			new Student("Степан", 56),
			new Student("Тимофей", 12)
		};
		Predicate<Student[]> p = new MaxFinder();
		System.out.println("Presence of max score in a1: "+p.test(a1));
		System.out.println("Presence of max score in a2: "+p.test(a2));
	}
}