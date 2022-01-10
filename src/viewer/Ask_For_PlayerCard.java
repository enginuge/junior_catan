package viewer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Player.Player;
import trading_resources.Marketplace;
import decks.Resource_Deck;
import cards.Resource;

public class Ask_For_PlayerCard extends Get_Input{

	public Ask_For_PlayerCard(Player p, Resource_Deck availableCards)
	{
		super(p);
		
		List test = availableCards.list_resources();
		
		//for(Resource_Deck r:availableCards)
		for(int i=0; i<availableCards.size(); i++)
		{
			super.add_option(String.format("%s", test.get(i)));
		}
		
		
		//*********************************/////
		//Check validity of types Resource_Deck and List<Resource> 
		//*********************************////
		
		//super.add_option(String.format("%d", availableCards.list_resources()));
		this.set_prompt(this.player_name()+" which card would you like to give up to trade?\n");
	}

}
