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
import trading_resources.Stockpile;

public class Trade_Stockpile extends Trade_Turn{

	public Trade_Stockpile(Player p) {
		// TODO Auto-generated constructor stub
		super(p);
	}

	public Resource_Deck get_stock()
	{
		Resource_Deck stock = Model.getInstance().table.board.get_stockpile();
		return stock;
	}
	
	
	//string to resource conversion
	public Resource set_DesiredResource(String a)
	{
		Resource desiredResource = super.set_trade();
		//System.out.printf("%s\n",a);
		
		if (a.equals("Goat"))
			desiredResource = (new Goat());
		
		else if (a.equals("Gold"))
			desiredResource = (new Gold());
		
		else if (a.equals("Molasses"))
			desiredResource = (new Molasses());
		
		else if (a.equals("Wood"))
			desiredResource = (new Wood());
		
		else if (a.equals("Cutlass"))
			desiredResource = (new Cutlass());
		
		return desiredResource;
	}
	
	/*
	public Resource set_DesiredResource(String a)
	{
		Resource desire = super.set_trade();
		desire = resourceToString(a)
		return desire;
	}*/
	
	public Resource get_PlayerResource(String a)
	{
		Resource totrade = super.get_trade();
		totrade = findCard(a);
		//totrade.add(playercard);
		return totrade;
	}

	@Override
	public boolean act() {
		
		if(this.get_stock().size() > 0)
		{
			//Ask the player to select a card from their hand
			String giveCard = Viewer.getInstance().check_valid_hand(this.get_player(),this.get_player().get_resource_deck());
			if (giveCard.equals("exit"))
				return false;
			else
			{
				Object playercard = this.get_PlayerResource(giveCard);
				
				//show player the cards currently listed on the Stockpile
				this.get_stock();
				
				//Ask player to pick a marketplace card
				String wantedCards = Viewer.getInstance().ask_for_marketcard(this.get_player(),this.get_stock());
				Object stockcard = this.set_DesiredResource(wantedCards);
				
				//MAKE TRADE: make sure to refresh the deck each time and restock if needed
				this.get_player().remove_resource(playercard);
				this.get_player().remove_resource(playercard);
				Model.getInstance().table.board.trade_to_stockpile(stockcard, playercard);
				
				//give the resources to the player
				this.get_player().collect_resource(stockcard);
				
				return true;
			}
			
			
		}
		else
			return false;
	}

}
