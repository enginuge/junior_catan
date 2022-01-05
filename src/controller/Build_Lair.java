package controller;

import Player.Player;
import cards.Cutlass;
import cards.Goat;
import cards.Molasses;
import cards.Wood;
import decks.Resource_Deck;

public class Build_Lair extends Build_Turn
{

	public Build_Lair(Player p) 
	{
		super(p);
	}
	
	@Override
	public Resource_Deck set_cost()
	{
		Resource_Deck cost = super.set_cost();
		
		cost.add(new Cutlass());
		cost.add(new Molasses());
		cost.add(new Goat());
		cost.add(new Wood());
		
		return cost;
	}
	
	
	public static void main(String[] args)
	{
		Player p = new Player("Red");
		
		Build_Lair bl = new Build_Lair(p);
		
		System.out.println(bl);
	}

	@Override
	public boolean act() {
		this.get_player().get_resource_deck().subtract_deck(this.get_cost());
		
		// needs to pick lair to build on.

		// needs to gain 1 score when the lair is built.
		this.get_player().add_point();
		
		return true;
	}
	
}
