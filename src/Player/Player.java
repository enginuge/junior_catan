package Player;

import decks.Hand;

public class Player
{
	protected String name;
	
	private Hand hand = new Hand(); // hand with both decks.
	
	public Player(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return String.format("Name: %s", this.name);
	}
}
