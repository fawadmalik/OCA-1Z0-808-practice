package com.javastreams.practice;

public class Person {
	  private final String name;
	  private final int age;
	  private final Gender gender;
	
	public Person(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	  @Override
	  public String toString() {
	    return "Person{" +
	        "name='" + name + '\'' +
	        ", age=" + age +
	        ", gender=" + gender +
	        '}';
	  }
}

