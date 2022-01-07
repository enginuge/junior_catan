package controller;

import java.util.ArrayList;

import Player.Player;
import cards.Cutlass;
import cards.Goat;
import cards.Molasses;
import cards.Resource;
import cards.Wood;
import decks.Resource_Deck;

public abstract class  Build_Turn extends Turn
{
	public Build_Turn(Player p)
	{
		super(p);
		
		this.cost = this.set_cost();
	}
	
	protected Resource_Deck cost;
	
//	public Resource_Deck get_ship_cost()
//	{
//		Resource_Deck cost = new Resource_Deck();
//
//		cost.add(new Goat());
//		cost.add(new Wood());
//		
//		return cost;
//	}
	
	public Resource_Deck set_cost()
	{
		cost = new Resource_Deck();
		
		return cost;
	}
	
	public Resource_Deck get_cost()
	{
		return this.cost;
	}
	
	/* Is the player able to afford the build costs? */
	public boolean check_cost()
	{
		if(this.get_player().get_resource_deck().cards_in(get_cost()))
			return true;
		
		return false;
	}
	
	public String toString()
	{
		String message = String.format("Build Turn.\nCost:\t%s", this.cost);
		
		return message; 
	}
}
