package Die;

import java.util.Random;

import board.Board;
import observable.Subject;

public class Die extends Subject 
{
	Random random = new Random();
	
	int result; 

	private static Die uniqueInstance = null;

	public static Die getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new Die();
		
		return uniqueInstance;
	}
	
	public Die()
	{
		System.out.printf("Creating Die...\n");
		
		this.result = 0;
	}
	
	public int roll()
	{
		System.out.println("Rolling Die.");
		this.result = this.random.nextInt(6);
		
		this.set_state(this.result);
//		this.set_state(this.random.nextInt(6));
		
		return this.result;
	}
	
	// Instead of having two variables just use a function.
	public int one2six()
	{
		return this.result + 1;
	}
	
	public static void main(String args[])
	{
		Die die = Die.getInstance();
		
		int[] results = new int[6];
		
		for(int i = 0; i < 10000; i++)
			results[die.roll()] ++;			

		// Results should appear evenly spread and prooves a suitable level of randomness.
		for(int i = 0; i < 6; i++)
			System.out.printf("%d: %d\n", i+1, results[i]);
	}
}
