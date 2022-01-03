package board;

import java.util.ArrayList;

import Player.Player;

/*
 * Class to describe the Channel/channel a ship can be built on.
 * It will be joined to two lairs.
 */
public class Channel {
	public ArrayList<Lair> lairs = new ArrayList<Lair>();
	
	public boolean occupied;
	
	public Player owner;
	
	private int identity;
	
	public Channel(int id)
	{
		this.identity = id;
		
		this.occupied = false;
		
		this.lairs.add(new Lair(0));
		
		this.lairs.add(new Lair(0));		
	}
	
	public int get_id()
	{
		return this.identity;
	}
	
	public void add_lair(Lair lair)
	{
		int n = 2;
		
		for(int i=0; i<n; i++)
		{
			if(this.lairs.get(i)==new Lair(0)) // the lair in the channel is 0 and unused,
			{
				this.lairs.set(i, lair);
				
				i = 2; // End the loop.
			}
		}
	}
	
	public int set_owner(Player player)
	{
		this.occupied = true;
		
		this.owner = player;
		
		// All okay.
		return 0;
	}
	
	public boolean equals(Channel other)
	{
		if(this.lairs.get(0).equals(other.lairs.get(0)) )
		{
			if(this.lairs.get(1).equals(other.lairs.get(1)) )
					return true;
		}
		
		else if(this.lairs.get(0).equals(other.lairs.get(1)) )
		{
			if(this.lairs.get(1).equals(other.lairs.get(0)) )
					return true;
		}

		return false;
	}
	
	public String toString()
	{
		return String.format("%s to %s", this.lairs.get(0), this.lairs.get(1));
	}
	
	
}
