package trading_resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cards.Cutlass;
import cards.Goat;
import cards.Gold;
import cards.Molasses;
import cards.Wood;
import cards.Resource;
import decks.Hand;
import decks.Resource_Deck;


public class Stockpile extends Tradable_Deck{
	
	private int maxCardCount = 18;
	
	private Resource_Deck stockpile;
	
	/* Constructor. Fills up the Marketplace with its starting cards*/
	public Stockpile()
	{
		this.stockpile = new Resource_Deck();
	}
	
	
	/* Add a resource card to the stock pile */
	@Override
	public void add_card(Object o) //for trading
	{
		//Resource r = (Resource)o;
		this.stockpile.add(o);
		System.out.printf("%s added to Stockpile.\n", o);
	}
	
	/* Remove a resource card from the marketplace */
	@Override
	public void remove_card(Object o)
	{
		//Resource r = (Resource)o;
		if(this.stockpile.remove(o))
			System.out.printf("%s removed from Stockpile.\n", o);
	}
	
	//cycle through the deck to check whether it must be updated or not
	
	public Resource_Deck get_stockpile()
	{
		return this.stockpile;
	}

	
	public String resource_string()
	{
		return this.stockpile.toString();
	}


	@Override
	public boolean refresh_deck() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public void restock(Object o) {
		// TODO Auto-generated method stub
		
	}


}
