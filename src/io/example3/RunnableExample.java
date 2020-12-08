package io.example3;

public class RunnableExample {

	public static void main(String[] args) {
		
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Runnable 1");
				
			}
		});
		
		myThread.run();
		
		myThread = new Thread(() -> System.out.println("Runnable 2"));

		myThread.run();
	}

}
