package io.example7;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.common.Person;

public class MethodReferenceExample2 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),				
				new Person("Lewis", "Carol", 42),				
				new Person("Thomas", "Carlyle", 51),				
				new Person("Chorlotte", "Bronte", 45),				
				new Person("Mathew", "Arnold", 31)
				);
				
		printConditionally2(people, p -> true, System.out::println); 
		//Method reference
		//System.out::println == p -> System.out.println(p)
	}

	private static void printConditionally2(List<Person> people, Predicate<Person> condition, Consumer<Person> perform) {
		for(Person p : people)
			if(condition.test(p))
				perform.accept(p);
	}	

}
