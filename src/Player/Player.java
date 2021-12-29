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
		System.out.printf("%s has collected %s.\n", this.name, o);
		
		this.hand.add_resource(o);
	}
	
	public String get_name()
	{
		return this.name;
	}
	
	public String toString()
	{
		return String.format("Name: %s", this.name);
	}
}
