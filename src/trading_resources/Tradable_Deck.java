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


public class Tradable_Deck{

	/* TODO: Stockpile could be comprised of five stacks*/
	//public Stack<Gold> gold_card;
	//public Stack<Molasses> molasses_card;
	//public Stack<Wood> wood_card;
	//public Stack<Cutlass> cutlass_card;
	//public Stack<Goat> goat_card;
	
	private Resource_Deck Tradable_Deck;
	
	/* Constructor. Fills up the Stockpile to it's max amount*/
	public Tradable_Deck()
	{
		
	}
	
	/* Add a resource card to the stock pile */
	public void add_card(Object o) //for trading
	{
		
	}
	
	/* Remove a resource card from the stock pile */
	public void remove_card(Object o)
	{
		
	}
	
	public boolean refresh_deck()
	{
		return true;
	}
	
//
	public void restock(Object o) // add a max count of whatever was missing
	{
		
	}
//
	
	public String resource_string()
	{
		return this.Tradable_Deck.toString();
	}

}
