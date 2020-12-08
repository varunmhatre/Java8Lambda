package io.example4;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CheckedExceptionHandling {

	public static void main(String[] args) {
		
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(throwingConsumerWrapper(i -> writeToFile(i), IOException.class));

	}

	@FunctionalInterface
	public interface ThrowingConsumer<T, E extends Exception> 
	{
	    void accept(T t) throws E;
	}
	
	static void writeToFile(Integer integer) throws IOException {
	    // logic to write to file which throws IOException
	}

	static <T, E extends Exception> Consumer<T> throwingConsumerWrapper(ThrowingConsumer<T, Exception> throwingConsumer, Class<E> exception) 
	{
		return i -> 
		{
	        try 
	        {
	            throwingConsumer.accept(i);
	        } 
	        catch (Exception e) 
	        {
	        	try
	        	{
					E exCast = exception.cast(e);
					System.err.println("Exception Occured: " + exCast.toString());
	        	}
	        	catch(ClassCastException ccE)
	        	{
	        		//throw new RuntimeException(e);
					System.err.println("Exception Occured: " + ccE.toString());
	        	}
	        }
	    };
	}

}
