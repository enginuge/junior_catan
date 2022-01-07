package decks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import cards.Cutlass;
import cards.Goat;
import cards.Gold;
import cards.Molasses;
import cards.Wood;
import cards.Resource;
import decks.Hand;


public class Stockpile{

	/* TODO: Stockpile could be comprised of five stacks*/
	//public Stack<Gold> gold_card;
	//public Stack<Molasses> molasses_card;
	//public Stack<Wood> wood_card;
	//public Stack<Cutlass> cutlass_card;
	//public Stack<Goat> goat_card;
	
	private int maxResourceCount = 5;
	
	public int countGold = maxResourceCount;
	public int countCutlass = maxResourceCount;
	public int countWood = maxResourceCount;
	public int countMolasses = maxResourceCount;
	public int countGoat = maxResourceCount;
	
	private Hand stockpile;
	
	/* Constructor*/
	public Stockpile()
	{
		this.stockpile = new Hand();
	}
	
	/* Add a resource card to the stock pile */
	public void add_stock(Object o) //for trading
	{
		//this.stockpile.add(o);
		//modify to be i+1
	}
	
	/* Remove a resource card from the stock pile */
	public void remove_stock(Object o)
	{
		//this.stockpile.remove(o);
		//modify to be i-1
		String rs = o.toString();
	}
	
	public boolean refresh_stock()
	{
		
		if (countGold == 0 || countCutlass == 0 || countWood == 0 || countMolasses == 0 || countGoat == 0)
			return true;
		
		else
			return false;
	}
	
//
	public void restock(Object o)
	{
		String objectString = o.toString();
		if (objectString=="Gold") //restock gold count
			countGold = maxResourceCount;
	}
//
	
	public String resource_string()
	{
		return this.stockpile.toString();
	}

}
