package Player;

import decks.Hand;

public class Player
{
	protected String name;
	
	public Hand hand; // hand with both decks.
	
	public Player(String name)
	{
		this.name = name;
		
		this.hand = new Hand();
	}
	
	public void collect_resource(Object o)
	{
		this.hand.add_resource(o);
	}
	
	public String toString()
	{
		return String.format("Name: %s", this.name);
	}
}
