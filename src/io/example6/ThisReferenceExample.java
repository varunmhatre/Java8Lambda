package io.example6;

public class ThisReferenceExample {

	public void execute() {
		
		System.out.println("Print \"this\" in execute(): " + this);
		doProcess(10 , i -> 
		{
			System.out.println("Print \"this\" in lambda" + this);
		});
	}
	
	public static void main(String[] args) {
		
		//Since doProcess is not a static function
		ThisReferenceExample thisRefVar = new ThisReferenceExample();
		
		System.out.println("Print thisRefVar: "+thisRefVar);
		thisRefVar.execute();
		
		System.out.println();
		thisRefVar.doProcess(10 , i -> 
		{
			System.out.println("In the lambda with no \"this\"");
			//Lambdas do not modify the "this" reference
			//Hence would be the same as using "this" outside the doProcess function
			//System.out.println(this);
		});

		System.out.println();
		thisRefVar.doProcess(10 , new Process()
		{

			@Override
			public void process(int i) {
				//Since we are in an instance of an object (type Process in this case)
				//We can use the "this" reference
				System.out.println("Print \"this\" in new Process: " + this);						
			}
						
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "This is an anonymous inner class - " + super.toString();
			}

		});
		
	}
	
	public void doProcess(int i, Process p)
	{
		p.process(i);
	}
	
	@Override
	public String toString() {
		return "Instance of ThisReferenceExample - " + super.toString();
	}
}

interface Process
{
	void process(int i);
}