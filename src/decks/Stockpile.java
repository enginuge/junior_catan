package decks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import cards.Cutlass;
import cards.Goat;
import cards.Gold;
import cards.Molasses;
import cards.Wood;


public class Stockpile{

	/* TODO: Stockpile could be comprised of five stacks*/
	public Stack<Gold> gold_card;
	public Stack<Molasses> molasses_card;
	public Stack<Wood> wood_card;
	public Stack<Cutlass> cutlass_card;
	public Stack<Goat> goat_card;
	
	private Resource_Deck stockpile;
	
	/* Constructor*/
	public Stockpile()
	{
		this.stockpile = new Resource_Deck();
	}
	
	/* Add a resource card to the stock pile */
	public void add_stock(Object o)
	{
		this.stockpile.add(o);
	}
	
	/* Remove a resource card from the stock pile */
	public void remove_stock(Object o)
	{
		this.stockpile.remove(o);
	}
	
	public String resource_string()
	{
		return this.stockpile.toString();
	}

}
