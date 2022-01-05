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
	
}
