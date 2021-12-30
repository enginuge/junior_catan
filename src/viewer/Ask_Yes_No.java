package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import Player.Player;

public class Ask_Yes_No implements PlayerInput
{
	private Player player;
	
	public Ask_Yes_No(Player p)
	{
		player = p;
	}
	
	@Override
	public String prompt() {
		String message = String.format("Player %s, Yes or No?", this.player.get_name());
		
		return message;
	}

	@Override
	public String scan() {
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  

		ArrayList<String> options = new ArrayList<String>();
		options.add("Yes");
		options.add("No");
		
		String choice = "";
		
		boolean valid = false;
		
		for(; !valid;)
		{
			// Ensure the player picks an actual option.
			for(choice=""; !options.contains(choice); )
			{
				for(String c:options)
					System.out.printf("%s ", c);
				
				System.out.printf("\nPlayer?\n");

				if(sc.hasNextLine())
					choice = sc.nextLine();
				
			} // end correct color loop.
			
			if(options.contains(choice))
				valid = true;
			
			else
				System.out.printf("%s\n", this.prompt());
			
		} // end selection loop.
		
//		sc.close(); // Close the scanner.

		return choice;

	}

	@Override
	public String get_input()
	{
		System.out.printf(this.prompt());
		
		return this.scan();
	}

}
