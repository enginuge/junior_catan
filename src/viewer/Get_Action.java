package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import Player.Player;

public class Get_Action implements PlayerInput
{

	@Override
	public String prompt() {
		return String.format("What would you like to do?\nRoll, Build or Trade.", null);
	}

	@Override
	public String scan() 
	{
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  

		ArrayList<String> options = new ArrayList<String>();
		options.add("Roll");
		options.add("Build");
		options.add("Trade");
		
		String choice = "";
		
		boolean valid = false;
		
		for(int i=0; !valid; i++)
		{
			// Ensure the player picks an actual option.
			for(choice=""; !options.contains(choice); )
			{
				for(String c:options)
					System.out.printf("%s ", c);
				
				System.out.printf("\nPlayer %d: ", i+1);
				
				choice = sc.nextLine();
			} // end correct color loop.
			
			if(options.contains(choice))
				valid = true;
			
			else
				System.out.printf("%s\n", this.prompt());

			
		} // end player color selection loop.
		
		sc.close(); // Close the scanner.

		return choice;
	}

	@Override
	public String get_input()
	{
		System.out.printf(this.prompt());
		
		return this.scan();
	}

}
