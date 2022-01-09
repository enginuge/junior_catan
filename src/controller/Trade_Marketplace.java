package controller;

import java.util.ArrayList;

import Player.Player;
import board.Channel;
import board.Lair;
import cards.Resource;
import cards.Cutlass;
import cards.Goat;
import cards.Molasses;
import cards.Wood;
import cards.Gold;
import decks.Resource_Deck;
import model.Model;
import viewer.Viewer;
import trading_resources.Marketplace;

public class Trade_Marketplace extends Trade_Turn{

	public Trade_Marketplace(Player p) {
		// TODO Auto-generated constructor stub
		super(p);
	}

	public Resource_Deck get_market_inventory()
	{
		Resource_Deck market = Model.getInstance().table.board.get_marketplace();
		return market;
	}
	
	
	public Resource_Deck set_DesiredResource(String a)
	{
		Resource_Deck desiredResource = super.set_trade();
		
		if (a == "goat")
			desiredResource.add(new Goat());
		
		else if (a == "gold")
			desiredResource.add(new Gold());
		
		else if (a == "molasses")
		desiredResource.add(new Molasses());
		
		else if (a == "wood")
			desiredResource.add(new Wood());
		
		else if (a == "cutlass")
			desiredResource.add(new Cutlass());
		
		return desiredResource;
	}
	
	public Resource_Deck get_PlayerResource(Object b)
	{
		Resource_Deck totrade = super.get_trade();
		totrade.add(b);
		return totrade;
	}

	@Override
	public boolean act() {
		// TODO Auto-generated method stub
		//swap desired tile for player resource
		
		//desired tile is WITHDRAWN from Marketplace and put into players hand
		
		//player resource ADDED to Marketplace and removed from player hand
		
		
		
		
		
		//ask player what card they are giving up (string = viewer ask for card prompt)
		//TODO: Make another viewer class "choose card player hand" for input choice.
		
		//this.get_player().get_resource_deck().
		
		if(this.get_market_inventory().size() > 0)
		{
			Resource_Deck playercard = new Resource_Deck();
			playercard = this.get_PlayerResource(new Goat());
			
			//show player the current marketplace inventory
			this.get_market_inventory();
			
			//ask player to pick a marketplace card
			String wantedCards = Viewer.getInstance().ask_for_marketcard(this.get_player(),this.get_market_inventory());
			Resource_Deck marketcard = new Resource_Deck();
			marketcard = this.set_DesiredResource(wantedCards);
			
			
			//MAKE TRADE: make sure to refresh the deck each time and restock if needed
			Model.getInstance().table.board.trade_to_marketplace(marketcard, playercard);
			
			//could also try this.get_marketplace().subtract_deck(this.get_trade)???
			return true;
			
		}
		else
			return false;
	}

}
