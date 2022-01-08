package controller;

import Player.Player;

/*
 * Abstract turns, can allow for different kinds of turns, like trading or building.
 */
public abstract class Turn
{
	private Player player;
	
	public Turn(Player p)
	{
		this.player = p;
	}
	
	public Player get_player()
	{
		return player;
	}
	
	public abstract boolean act(); 

}
