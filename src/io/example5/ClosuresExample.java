package io.example5;

public class ClosuresExample 
{

	public static void main(String[] args) 
	{
		int a = 10;
		/*final*/ int b = 20;
		
		/* 
		 * This is also ALLOWED
		 * int b;
		 * b = 20;
		 */
		
		//The point of using external variables in Anonymous inner classes and lambdas 
		//is to sync with the external function
		//Therefore it needs to be final or effectively final to remain consistent
		
		//A closure is a combination of a function bundled together (enclosed) with references to its surrounding state
		//A closure gives you access to an outer function’s scope from an inner function
		
		doProcess(a, i -> System.out.println(i + b));
		
		doProcess(a , new Process()
				{

					@Override
					public void process(int i) {
						//Not allowed
						//b = 40;
						System.out.println(i + b);						
					}
			
				});
		
		//Not allowed
		//b = 30;
	}
	
	public static void doProcess(int i, Process p)
	{
		p.process(i);
	}
}

interface Process
{
	void process(int i);
}