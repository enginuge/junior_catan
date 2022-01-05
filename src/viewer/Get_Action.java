package viewer;

import Player.Player;

public class Get_Action extends Get_Input
{
	public Get_Action(Player p)
	{
		super(p);
		
		this.add_option("Build");
		
		this.add_option("Trade");
		
		this.add_option("Finish");
		
		this.set_prompt(this.player_name()+" what would you like to do?\n");

	}
}
