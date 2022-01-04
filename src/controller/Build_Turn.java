package controller;

import java.util.ArrayList;

import Player.Player;
import cards.Cutlass;
import cards.Goat;
import cards.Molasses;
import cards.Resource;
import cards.Wood;
import decks.Resource_Deck;

public class Build_Turn extends Turn
{
	public Build_Turn(Player p)
	{
		super(p);
	}
	
	public Resource_Deck get_lair_cost()
	{
		Resource_Deck cost = new Resource_Deck();
		
		cost.add(new Cutlass());
		cost.add(new Molasses());
		cost.add(new Goat());
		cost.add(new Wood());
		
		return cost;
	}
	
	public Resource_Deck get_ship_cost()
	{
		Resource_Deck cost = new Resource_Deck();

		cost.add(new Goat());
		cost.add(new Wood());
		
		return cost;
	}
	
	/* Is the player able to afford the build costs? */
	public boolean check_costs()
	{
		
		
		return false;
	}
}
