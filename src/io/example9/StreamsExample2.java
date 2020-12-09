package io.example9;

import java.util.Arrays;
import java.util.List;

import io.common.Person;

public class StreamsExample2 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),				
				new Person("Lewis", "Carol", 42),				
				new Person("Thomas", "Carlyle", 51),				
				new Person("Chorlotte", "Bronte", 45),				
				new Person("Mathew", "Arnold", 31)
				);
		
		//Stream (as with/using the forEach) takes the iteration out of the hands of the developer 
		//and does it internally. Developers just state their intent without actually implementing it.
		//This allows for parallel processing.
		//Different portions of the collection handled in different processors.
		//Portions of a huge collection execute operations in different cores.
		//Think multiple assembly lines (as many as there are cores).
		//parallelStream will attempt to do this if it feels that using multiple core could make it faster
		
		people.parallelStream()
		.filter(p -> p.getFirstname().startsWith("C") || p.getLastname().startsWith("C"))
		.forEach(p -> System.out.println(p.getFirstname() +" "+ p.getLastname()));
						
	}

}
