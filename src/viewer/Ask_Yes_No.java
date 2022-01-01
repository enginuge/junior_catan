package viewer;

import Player.Player;

public class Ask_Yes_No extends Get_Input
{
	public Ask_Yes_No(Player p)
	{
		super(p);
		
		this.add_option("Yes");
		
		this.add_option("No");
		
		this.set_prompt("Player "+this.player_name()+": Yes or No?\n");
	}
}
