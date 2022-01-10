package viewer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Player.Player;
import trading_resources.Marketplace;
import decks.Resource_Deck;
import cards.Resource;

public class Ask_For_MarketCard extends Get_Input{

	public Ask_For_MarketCard(Player p, Resource_Deck availableCards)
	{
		super(p);
		
		List test = availableCards.list_resources();
		
		//for(Resource_Deck r:availableCards)
		for(int i=0; i<availableCards.size(); i++)
		{
			super.add_option(String.format("%s", test.get(i)));
		}
		this.set_prompt(this.player_name()+" which card would you like from the Stockpile?\n");
	}

}
