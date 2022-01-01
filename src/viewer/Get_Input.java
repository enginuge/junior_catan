/**
 * 
 */
package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import Player.Player;

/**
 * @author jackn
 *
 */
public abstract class Get_Input implements PlayerInput
{
	private Player player;
	
	private String prompt;
	
	private ArrayList<String> options = new ArrayList<String>();
	
	public Get_Input(Player p)
	{
		this.player = p;
	}
	
	public String player_name()
	{
		return this.player.get_name();
	}
	
	@Override
	public String get_prompt() 
	{
		return this.prompt;
	}
	
	@Override
	public String set_prompt(String message)
	{
		this.prompt = message;
		
		return this.get_prompt();
	}
	
	public void add_option(String option)
	{
		this.options.add(option);
	}
	
	public String string_options()
	{
		String output = "";
		
		int size = this.options.size();
		
		for(int i = 0; i < size; i++)
		{
//			String.format("%s, %s", output, this.options.get(i));
			output += this.options.get(i);
			
			if(i == (size-1) )
				output += ".\n";
//				String.format("%s.\n", output);
			
			else
				output += ", ";
		}
		
		return output;
	}
	
	@Override
	public String scan() 
	{
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  

		String choice = "";
		
		boolean valid = false;
		
		while(!valid)
		{
			// Ensure the player picks an actual option.
			for(choice=""; !options.contains(choice); )
			{
				System.out.printf("%s", this.string_options());
				
				choice = sc.nextLine();
			} // end correct color loop.
			
			if(options.contains(choice))
				valid = true;
			
			else
				System.out.printf("%s\n", this.get_prompt());

			
		} // end player color selection loop.
		

		return choice;
	}

	@Override
	public String get_input()
	{
		System.out.printf(this.get_prompt());
		
		return this.scan();
	}
}
