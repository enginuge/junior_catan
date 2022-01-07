package decks;

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


public class BoardStock{

	/* TODO: Stockpile could be comprised of five stacks*/
	//public Stack<Gold> gold_card;
	//public Stack<Molasses> molasses_card;
	//public Stack<Wood> wood_card;
	//public Stack<Cutlass> cutlass_card;
	//public Stack<Goat> goat_card;
	
	public static BoardStock uniqueInstance = null; // A deck for the board's stockpile
	
	public static BoardStock getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new BoardStock();
		
		return uniqueInstance;
	}
	
	private int maxResourceCount = 5;
	
	private Resource_Deck stockpile;
	
	/* Constructor*/
	public BoardStock()
	{
		this.stockpile = new Resource_Deck();
		for (int i = 0; i<maxResourceCount; i++)
		{
			stockpile.add(new Wood());
			stockpile.add(new Goat());
			stockpile.add(new Molasses());
			stockpile.add(new Cutlass());
			stockpile.add(new Gold());
			System.out.println("One round of Stock Added");
		}
	}
	
	/* Add a resource card to the stock pile */
	public void add_stock(Object o) //for trading
	{
		this.stockpile.add(o);
	}
	
	/* Remove a resource card from the stock pile */
	public void remove_stock(Object o)
	{
		this.stockpile.remove(o);
	}
	
	public boolean refresh_stock()
	{
		//cycle through all items in stockpile, adding their count
		int total = this.stockpile.size();
		int countGold = 0;
		int countCutlass = 0;
		int countWood = 0;
		int countMolasses = 0;
		int countGoat = 0;
		
		
		//count how many resources of each type are left in the stock
		for (int i = 0; i<total; i++)
		{
			String currentResource = this.stockpile.toString();
			if (currentResource == "gold")
				countGold++;
			
			else if(currentResource == "goat")
				countGoat++;
			
			else if (currentResource == "molasses")
				countMolasses++;
			
			else if (currentResource == "wood")
				countWood++;
			
			else if (currentResource == "cutlass")
				countCutlass++;
		}
		
		if (countGold == 0 || countCutlass == 0 || countWood == 0 || countMolasses == 0 || countGoat == 0)
			return true;
		
		else
			return false;
	}
	
//
	public void restock(Object o) // add a max count of whatever was missing
	{
		//TODO: Made sure restock does not occur more than once
		for (int i = 0; i<maxResourceCount; i++)
		{
			this.stockpile.add(o);
		}
		System.out.printf("All resources of type %s have been restocked back on the board.\n", o);
	}
//
	
	public String resource_string()
	{
		return this.stockpile.toString();
	}

}
