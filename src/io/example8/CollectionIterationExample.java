package io.example8;

import java.util.Arrays;
import java.util.List;

import io.common.Person;

public class CollectionIterationExample {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),				
				new Person("Lewis", "Carol", 42),				
				new Person("Thomas", "Carlyle", 51),				
				new Person("Chorlotte", "Bronte", 45),				
				new Person("Mathew", "Arnold", 31)
				);

		CollectionIterationExample collectionIterarionRef = new CollectionIterationExample();
		
		//It is explicit and sequential, hence does not allow for multi-threading
		System.out.print("Using For Loops\n");
		for(int i = 0; i < people.size(); i++)
		{
			//System.out.println(people.get(i).getFirstname());
			collectionIterarionRef.printFirstName(people.get(i));
		}

		System.out.println("\nUsing external ForEach/ForIn");
		for(Person p : people)
		{
			//System.out.println(p.getFirstname());
			collectionIterarionRef.printFirstName(p);
		}

		//Since it is an internal loop, processor can run it in multiple threads
		System.out.println("\nUsing internal lambda ForEach");
		//people.forEach(p -> System.out.println(p.getFirstname()));
		people.forEach(collectionIterarionRef::printFirstName);
	}
	
	void printFirstName(Person p)
	{
		System.out.println(p.getFirstname());
	}
}
