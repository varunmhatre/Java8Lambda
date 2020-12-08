package io.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import io.common.Person;

public class Unit1Exercise {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),				
				new Person("Lewis", "Carol", 42),				
				new Person("Thomas", "Carlyle", 51),				
				new Person("Chorlotte", "Bronte", 45),				
				new Person("Mathew", "Arnold", 31)
				);
				
		// Step 1: Sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastname().compareTo(p2.getLastname()));

		// Step 2: Create a method that prints all elements in that list
		performConditionally(people, p -> true, p -> System.out.println(p));

		// Print Empty Line
		System.out.println();
		
		// Step 3: Create a method that prints all people whose last name starts with C
		performConditionally(people, p -> p.getLastname().startsWith("C"), p -> System.out.println(p));	

		// Print Empty Line
		System.out.println();
		
		// Step 4: Create a method that prints all people whose first name starts with C
		printConditionally2(people, p -> p.getFirstname().startsWith("C"), p -> System.out.println(p));

		// Print Empty Line
		System.out.println();
		
		// Step 5: Create a method that prints all people whose first or last name starts with C
		printConditionally3(people, p -> p.getFirstname().startsWith("C") || p.getLastname().startsWith("C"), p -> System.out.println(p));
	}

	private static void performConditionally(List<Person> people, Condition condition, Consumer<Person> perform) {
		for(Person p : people)
			if(condition.test(p))
				perform.accept(p);
	}	

	private static void printConditionally2(List<Person> people, Predicate<Person> condition, Consumer<Person> perform) {
		for(Person p : people)
			if(condition.test(p))
				perform.accept(p);
	}	

	private static void printConditionally3(List<Person> people, Function<Person, Boolean> condition, Consumer<Person> perform) {
		for(Person p : people)
			if(condition.apply(p))
				perform.accept(p);
	}	
	
	interface Condition
	{
		boolean test(Person p);
	}
}