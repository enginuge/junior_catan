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
	
	public Channel(Lair A, Lair B)
	{
		this.occupied = false;
		
		this.lairs.add(A);
		
		this.lairs.add(B);		
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
}
