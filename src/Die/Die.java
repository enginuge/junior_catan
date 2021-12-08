package Die;

import java.util.Random;

import observable.Subject;

public class Die extends Subject 
{
	Random random = new Random();
	
	int result; 
	
	public Die()
	{
		this.result = 0;
	}
	
	public int roll()
	{
		this.result = this.random.nextInt(6);
		
		this.set_state(this.result);
		
		return this.result;
	}
	
	// Instead of having two variables just use a function.
	public int one2six()
	{
		return this.result + 1;
	}
	
	public static void main(String args[])
	{
		Die die = new Die();
		
		int[] results = new int[6];
		
		for(int i = 0; i < 10000; i++)
			results[die.roll()] ++;			

		// Results should appear evenly spread and prooves a suitable level of randomness.
		for(int i = 0; i < 6; i++)
			System.out.printf("%d: %d\n", i+1, results[i]);
	}
}
