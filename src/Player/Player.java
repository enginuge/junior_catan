package Player;

import board.Channel;
import board.Lair;
import board.Occupied_Land;
import decks.Hand;
import decks.Resource_Deck;

public class Player
{
	protected String name;
	
	public Hand hand; // hand with both decks.
	
	private int score;
	
	private Occupied_Land occupied;
	
	public Player(String name)
	{
		this.name = name;
		
		this.hand = new Hand();
		
		this.score = 0;
		
		this.occupied = new Occupied_Land();
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
		this.score = this.occupied.get_lairs().size();
		
		return this.score;
	}
	
//	public void add_point()
//	{
//		this.score++;
//	}
	
	public String toString()
	{
		return String.format("Name: %s", this.name);
	}
	
	public Resource_Deck get_resource_deck()
	{
		return this.hand.get_resource_deck();
	}
	
	public void add_lair(Lair l)
	{
		this.occupied.add_lair(l);
	}
	
	public void add_channel(Channel c)
	{
		this.occupied.add_channel(c);
	}

	public String occupied_string() 
	{
		String message;
		
		message = String.format("%s", this.occupied);
		
		return message;
	}
}
