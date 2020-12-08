package io.example4;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		int[] someNumbers = { 1, 2, 3, 4, 5 };
		List<Integer> numberList = Arrays.asList( 1, 2, 3, 4, 5 );
		int key = 0;
		
		process(someNumbers, key, BiConsumerWrapper((v,k) -> System.out.println(v/k)));
			
		System.out.println();
		
		numberList.forEach(ConsumerWrapper(i -> System.out.println(i/key), ArithmeticException.class));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) 
	{	
		for(int i : someNumbers)
		{
			consumer.accept(i, key);
		}		
	}

	private static BiConsumer<Integer, Integer> BiConsumerWrapper(BiConsumer<Integer, Integer> consumer) 
	{
		return (v,k) -> 
		{
			try
			{
				consumer.accept(v, k);
			}
			catch(ArithmeticException e)
			{
				System.err.println("Arithmetic Exception: " + e.getMessage());
			}
		};
	}
	
	private static <T, E extends Exception> Consumer<T> ConsumerWrapper(Consumer<T> consumer, Class<E> exception) 
	{
		return v -> 
		{
			try
			{
				consumer.accept(v);
			}
			catch(Exception e)
			{
				try 
				{
					E exCast = exception.cast(e);
					System.err.println("Exception Occured: " + exCast.toString());
				}
				catch(ClassCastException ccE)
				{
					//throw e;
					System.err.println("Exception Occured: " + ccE.toString());
				}
			}
		};
	}
}
