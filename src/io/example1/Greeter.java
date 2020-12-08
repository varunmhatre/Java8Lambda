package io.example1;

public class Greeter {

	public void greet(Greeting greeting)
	{
		greeting.perform();
	}
	
	public static void main(String[] args) {
		
		Greeter greeter = new Greeter();
		
		Greeting myLambdaFunction = () -> System.out.println("Hi 1");
		
		Greeting myAnonymousInnerClass = new Greeting() {
			
			@Override
			public void perform() {
				System.out.println("Greetings 1");
			}
		};
		
		//Anonymous Inner Class
		greeter.greet(myAnonymousInnerClass);

		//Inline Anonymous Inner Class
		greeter.greet(new Greeting() {
			
			@Override
			public void perform() {
				System.out.println("Greetings 2");
			}
		});
		
		//Lambda
		greeter.greet(myLambdaFunction);
		
		//Inline lambda
		greeter.greet(() -> {
			System.out.println("Hi 2");
			System.out.println("Hi 3");
		});
				
	}
	
}
