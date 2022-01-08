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


public abstract class Tradable_Deck{

	/* TODO: Stockpile could be comprised of five stacks*/
	//public Stack<Gold> gold_card;
	//public Stack<Molasses> molasses_card;
	//public Stack<Wood> wood_card;
	//public Stack<Cutlass> cutlass_card;
	//public Stack<Goat> goat_card;
	
	public Resource_Deck Tradable_Deck;
	
	/* Add a resource card to the stock pile */
	public void add_card(Object o) //for trading
	{
		this.Tradable_Deck.add(o);
	}
	
	/* Remove a resource card from the stock pile */
	public void remove_card(Object o)
	{
		this.Tradable_Deck.remove(o);
	}
	
	public abstract boolean refresh_deck();
	

	public abstract void restock(Object o); // add a max count of whatever was missing

	
	public String resource_string()
	{
		return this.Tradable_Deck.toString();
	}

}
