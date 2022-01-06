package board;

import java.util.ArrayList;

import Player.Player;
import cards.Resource;
import observable.Observer;

/*
 * Class to describe each lair/node on the board.
 * The Lair should observe an Island, and be notified of that Island producing resources
 * After the dice rolls the islands number.
 */
public class Lair implements Observer
{
	// THe  number to identify the lair on the board.
	private int identity=0;
	
	public boolean occupied;
	
	public Player owner;
	
	// Array of Lairs connected to this Lair.
	public ArrayList<Lair> neighbours = new ArrayList<Lair>();
	
	// The channels to the neighboring lairs.
	public ArrayList<Channel> channels = new ArrayList<Channel>();
	
	
	public Lair(int id)
	{
		this.identity = id;
		
		this.occupied = false;
		
		// Build Neighbors too, as an input perhaps.
	}
	
	public int get_id()
	{
		return this.identity;
	}
	
	public ArrayList<Channel> get_channels()
	{
		return this.channels;
	}
	
	public int set_owner(Player player)
	{
		this.occupied = true;
		
		// Check Player has a connected lair in the neighbours list.
		this.owner = player;
		
		player.add_lair(this);
		
		// all okay.
		return 0;
	}
	
	public boolean is_occupied()
	{
		return this.occupied;
	}
	
	public Channel add_neighbour(Lair neighbour)
	{
		Channel new_channel = new Channel(0);
		
		this.neighbours.add(neighbour);
		
//		this.channels.add(new_channel);
		
		return new_channel;
	}
	
	public void add_channel(Channel c)
	{
		this.channels.add(c);
	}

	/*
	 * When the lair is updated, each owner must receive the resource of the island that won.
	 */
//	@Override // Not an Override as it has an input, which makes it a different fnuction.
	public void update(Object o)
	{
		if(this.occupied)
			this.owner.collect_resource(o);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean equals(Lair other)
	{
		if(this.get_id() == other.get_id())
			return true;
		
		return false;
	}
	
	public String toString()
	{
		return String.format("Lair %02d:\tOwner:\t%s", this.identity, this.owner);
	}
}
