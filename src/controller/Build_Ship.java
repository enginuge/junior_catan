package controller;

import java.util.ArrayList;

import Player.Player;
import board.Channel;
import board.Lair;
import cards.Goat;
import cards.Wood;
import decks.Resource_Deck;
import model.Model;
import viewer.Viewer;

public class Build_Ship extends Build_Turn
{

	public Build_Ship(Player p) 
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
		
		Build_Ship bs = new Build_Ship(p);
		
		System.out.println(bs);
	}
	
	public ArrayList<Channel> get_free_channel()
	{
		return this.get_player().get_free_channel();
	}

	@Override
	public boolean act() 
	{
		// Check the resources are in the players hand.
//		if(this.get_player().get_resource_deck().cards_in(this.get_cost()))
		if(super.check_cost())
		{
			// needs to pick lair to build on.
//			Viewer.getInstance().show_available_lairs(this.get_player());
			
			if(this.get_free_channel().size() > 0)
			{
				Channel build_on = Viewer.getInstance().ask_for_channel(this.get_player(), this.get_free_channel());
				
				Model.getInstance().table.board.set_channel_owner(build_on.get_id(), get_player());
				
				this.get_player().get_resource_deck().subtract_deck(this.get_cost());
				
				return true;
			}
			
			else
				System.out.println("No free channels.");
		}		
		
		System.out.println("Not Enough Resources to build a ship.");
		
		return false;
	}
	
}
