package io.example2;

public class TypeInference {

	public static void main(String[] args) {
		
		//StringLength myLambda = s -> System.out.print(s);
		
		//Using Method reference
		greet("Hi you", System.out::print); // System.out::print == s -> System.out.print(s)
	}

	public static void greet(String s,StringLength greeting)
	{
		greeting.print(s);
	}
	
	@FunctionalInterface
	interface StringLength
	{
		void print(String s);
	}
	
}
