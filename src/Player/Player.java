package Player;

import decks.Hand;
import decks.Resource_Deck;

public class Player
{
	protected String name;
	
	public Hand hand; // hand with both decks.
	
	public int score;
	
	public Player(String name)
	{
		this.name = name;
		
		this.hand = new Hand();
		
		this.score = 0;
	}
	
	public void collect_resource(Object o)
	{
		System.out.printf("%s has collected %s.\n", this.name, o);
		
		this.hand.add_resource(o);
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
	
	public Resource_Deck get_resource_deck()
	{
		return this.hand.get_resource_deck();
	}
}
