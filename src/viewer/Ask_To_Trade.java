package viewer;

import Player.Player;

public class Ask_To_Trade extends Get_Input
{
	public Ask_To_Trade(Player p)
	{
		super(p);
		
		this.add_option("Stockpile");
		
		this.add_option("Marketplace");
		
		this.set_prompt(this.player_name() + " what would you like to trade with?\n");
	}
}