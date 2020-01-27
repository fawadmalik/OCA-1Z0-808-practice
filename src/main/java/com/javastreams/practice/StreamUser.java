package com.javastreams.practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

public class StreamUser {

	public static void main(String[] args) {
		ArrayList<Person> people = getPeople();
		
		List<Person> females = people.stream()
		.filter(person -> person.getGender().equals(Gender.FEMALE))
		.collect(Collectors.toList());

		females.forEach(System.out::println);
		System.out.println();
		
		List<Person> femalesSortedByAge = people.stream()
		.sorted(Comparator.comparing(Person::getAge))//.thenComparing(Person::getGender))
		.collect(Collectors.toList());
		
		femalesSortedByAge.forEach(System.out::println);

	}

	private static ArrayList<Person> getPeople() {
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(new Person("Antonio", 20, Gender.MALE));
		people.add(new Person("Alina Smith", 33, Gender.FEMALE));
		people.add(new Person("Helen White", 57, Gender.FEMALE));
		people.add(new Person("Alex Boz", 14, Gender.MALE));
		people.add(new Person("Jamie Goa", 99, Gender.MALE));
		people.add(new Person("Anna Cook", 7, Gender.FEMALE));
		people.add(new Person("Zelda Brown", 120, Gender.FEMALE));
		
		return people;
	}

}
