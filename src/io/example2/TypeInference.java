package io.example2;

public class TypeInference {

	public static void main(String[] args) {
		
		//StringLength myLambda = s -> System.out.print(s);
		
		greet(s -> System.out.print(s),"Hi you");
	}

	public static void greet(StringLength greeting, String s)
	{
		greeting.print(s);
	}
	
	@FunctionalInterface
	interface StringLength
	{
		void print(String s);
	}
	
}
