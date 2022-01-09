package controller;

import java.util.ArrayList;

import Player.Player;
import cards.Resource;
import decks.Resource_Deck;


public abstract class  Trade_Turn extends Turn
{
	protected Resource_Deck trade;
	
	public Trade_Turn(Player p)
	{
		//TODO: constructor 
		super(p);
		this.trade= this.set_trade();
	}
	
	public Resource_Deck set_trade() //what resources are being requested
	{
		trade = new Resource_Deck();
		return trade;
	}
	
	public Resource_Deck get_trade() //what resources are offered to trade
	{
		return this.trade;
	}
	
	/*public Resource_Deck get_trade(Player p, Object o) //what resources are being sought
	{
		Resource_Deck trade = new Resource_Deck();

		trade.add(o);
		
		return this.trade;
	}*/
	
	/* Is the player able to afford the build costs? */
	public boolean check_trade()
	{
		if(this.get_player().get_resource_deck().cards_in(get_trade()))
			return true;
		
		return false;
	}
	
	public String toString()
	{
		String message = String.format("Trade Turn.\nTrading:\t%s", this.trade);
		
		return message; 
	}
}
