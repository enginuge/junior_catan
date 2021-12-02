package board;

import java.util.ArrayList;

import Player.Player;

/*
 * Class to describe each lair/node on the board.
 */
public class Lair 
{
	// THe  number to identify the lair on the board.
	public int identity=0;
	
	public boolean occupied;
	
	public Player owner;
	
	// Array of Lairs connected to this Lair.
	public ArrayList<Lair> neighbours = new ArrayList<Lair>();
	
	// The channels to the neighbouring lairs.
	public ArrayList<Channel> channels = new ArrayList<Channel>();
	
	
	public Lair(int id)
	{
		this.identity = id;
		
		this.occupied = false;
		
		// Build Neighbours too, as an input perhaps.
	}
	
	public int set_owner(Player player)
	{
		this.occupied = true;
		
		// Check Player has a connected lair in the neighbours list.
		this.owner = player;
		
		// all okay.
		return 0;
	}
}
