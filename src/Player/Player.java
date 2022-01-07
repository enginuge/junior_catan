package Player;

import decks.Hand;
import decks.BoardStock;
//import board.Board;

public class Player
{
	protected String name;
	
	public Hand hand; // hand with both decks.
	
	public int score;
	
	public BoardStock bStck;
	
	public Player(String name)
	{
		this.name = name;
		
		this.hand = new Hand();
		
		this.score = 0;
		
		//this.stock_deck = new Stockpile();
	}
	
	public void collect_resource(Object o)
	{
		System.out.printf("%s has collected %s.\n", this.name, o);
		
		this.hand.add_resource(o);  

		// MODIFY THIS TO TAKE FROM STOCKPILE ONLY *******************
		//Treat stockpile like another hand??
		//this.stock_deck.remove_card(o);
		
		//convert the object to a string, then compare strings
		//if the number of the resource drops to zero, then restock.
		

		//****************************
		// Stockpile will be exactly like a Player,
		// implementing a hand.
		//****************************
		
		
		//this.stock.remove_card(o);
		//this.stock.refresh_stock();
		// STOCKPILE = remove resource
		// stockpile refresh (will only do so if 0 anyways)
	}
	
	// this is the two to one trading system for Stockpile
	public void trade_resource(Object a, Object b)
	{
		System.out.printf("%s has traded for %s.\n", this.name, b);
		this.hand.add_resource(b);  // don't forget to remove resource b from the stockpile
		this.hand.remove_resource(a);
	}
	
	public void lose_all(Object o)
	{
		//TODO: Sort through the list in the players hand and remove every occurrence of o
		// print to user
		System.out.printf("All cards of type %s have been returned to the Stockpile.\n", o);
		// use method in Hand
		this.hand.remove_all_of_type(o);
	}
	
	public String get_name()
	{
		return this.name;
	}
	
	public int get_score()
	{
		return this.score;
	}
	
	public String toString()
	{
		return String.format("Name: %s", this.name);
	}
}
