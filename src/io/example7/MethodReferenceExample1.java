package io.example7;

public class MethodReferenceExample1 {

	public static void main(String[] args) {
		
		Thread t = new Thread(MethodReferenceExample1::printMessage);

		t.start();
	}

	public static void printMessage()
	{
		System.out.println(Thread.currentThread().getName());
	}
}
