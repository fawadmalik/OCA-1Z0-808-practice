package com.streamsNlambdas;

public class Animal {
	public Animal(AnimalType type, String name, int age) {
		this.type = type;
		this.name = name;
		this.age = age;
	}

	public AnimalType type;
	public String name;
	public int age;

	public AnimalType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
