package com.lambdaExpressions.practice;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressions {
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("dog", true, true));

		print(animals, new CheckCanJump());

		print(animals, animal -> animal.canSwim());
		print(animals, animal -> !animal.canSwim());

	}

	private static void print(Animal first, Animal second, AnotherCheck check) {
		System.out.println(check.check(first, second));
	}

	private static void print(List<Animal> animals, CheckAnimal filter) {
		for (Animal animal : animals) {
			if (filter.check(animal)) {
				System.out.println(animal.getType()+ " can jump");
			}
		}

		System.out.println();
	}

}

class Animal {
	private String type;
	private boolean canJump;
	private boolean canSwim;

	public Animal(String type, boolean canJump, boolean canSwim) {
		this.type = type;
		this.canJump = canJump;
		this.canSwim = canSwim;
	}

	public boolean canJump() {
		return canJump;
	}

	public boolean canSwim() {
		return canSwim;
	}

	public String getType() {
		return type;
	}
}

interface CheckAnimal {
	boolean check(Animal animal);
}

class CheckCanJump implements CheckAnimal {

	@Override
	public boolean check(Animal animal) {
		return animal.canJump();
	}
}

interface AnotherCheck {
	boolean check(Animal first, Animal second);
}
