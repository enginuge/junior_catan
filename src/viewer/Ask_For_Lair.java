package viewer;

import java.util.ArrayList;

import Player.Player;
import board.Lair;

public class Ask_For_Lair extends Get_Input
{
	public Ask_For_Lair(Player p, ArrayList<Lair> options)
	{
		super(p);
		
		for(Lair l: options)
		{
			super.add_option(String.format("%d", l.get_id()));
		}
		
		this.set_prompt(this.player_name()+" which Lair would you like to build on?\n");
	}
	
}
