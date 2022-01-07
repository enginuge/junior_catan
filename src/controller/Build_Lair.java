package controller;

import java.util.ArrayList;

import Player.Player;
import board.Lair;
import cards.Cutlass;
import cards.Goat;
import cards.Molasses;
import cards.Wood;
import decks.Resource_Deck;
import model.Model;
import viewer.Viewer;

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
	
	public ArrayList<Lair> get_free_lair()
	{
		return this.get_player().get_free_lair();
	}

	@Override
	public boolean act() {
		// Check the resources are in the players hand.
		if(this.get_player().get_resource_deck().cards_in(this.get_cost()))
		{
			// needs to pick lair to build on.
			Viewer.getInstance().show_available_lairs(this.get_player());
			
			Lair build_on = Viewer.getInstance().ask_for_lair(this.get_player(), this.get_free_lair());
			
			Model.getInstance().table.board.set_lair_owner(build_on.get_id(), get_player());
			
			this.get_player().get_resource_deck().subtract_deck(this.get_cost());
			
	
			// needs to gain 1 score when the lair is built.
	//		this.get_player().add_point();
			
			return true;
		}		
		
		return false;
		
	}
	
}
