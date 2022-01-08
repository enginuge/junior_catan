package viewer;

import Player.Player;

public class Ask_Yes_No extends Get_Input
{
	public Ask_Yes_No(Player p)
	{
		super(p);
		
		this.add_option("Yes");
		this.add_option("yes");
		this.add_option("Y");
		this.add_option("y");
		this.add_option("No");
		this.add_option("no");
		this.add_option("N");
		this.add_option("n");
		
		this.set_prompt("Player "+this.player_name()+":\n");
	}
}