package viewer;

import java.util.ArrayList;

import Player.Player;
import board.Channel;

public class Ask_For_Channel extends Get_Input
{
	public Ask_For_Channel(Player p, ArrayList<Channel> options)
	{
		super(p);
		
		for(Channel c: options)
		{
			super.add_option(String.format("%d", c.get_id()));
		}
		
		this.set_prompt(this.player_name()+" which Channel would you like to build on?\n");
	}
	
}
