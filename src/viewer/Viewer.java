package viewer;

import java.util.ArrayList;

import Player.Player;
import board.Channel;
import board.Lair;
import decks.Resource_Deck;
import model.Model;

/*
 * The class responsible for showing and asking the
 * Player for inputs.
 */
public class Viewer
{
	private static Viewer uniqueInstance = null;

	public static Viewer getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new Viewer();
		
		return uniqueInstance;
	}
	
	public Draw_Board db;
	
	/* Constructor */
	public Viewer()
	{
		db = new Draw_Board();
	}
	
	public String ask_to_roll(Player player)
	{
		Ask_Yes_No ask = new Ask_Yes_No(player);
		
		System.out.printf("Are you ready to roll?\n");
		
		return ask.get_input();
	}
	
	public String ask_for_action(Player p)
	{
		Get_Action ga = new Get_Action(p);
		
		return ga.get_input();
	}
	
	public String ask_to_build(Player p)
	{
		Ask_Building ab = new Ask_Building(p);
		
		return ab.get_input();
	}
	
	public String ask_to_trade(Player p)
	{
		Ask_To_Trade att = new Ask_To_Trade(p);
		
		return att.get_input();
	}
	
	public String show_Marketplace()
	{
		Resource_Deck marketdeck = Model.getInstance().table.board.get_marketplace();
		String mstring = marketdeck.toString();
		return mstring;
	}
	
	public String ask_for_marketcard(Player p, Resource_Deck availableCards)
	{
		Ask_For_MarketCard card = new Ask_For_MarketCard(p, availableCards);
		
		return card.get_input();
	}
	
	public String display_roll()
	{
		String message;
		
		message = String.format("Rolled a %d.\n", Model.getInstance().table.die.one2six());
		
		System.out.printf(message);
		
		return message;
	}
	
	public String show_inventory(Player p)
	{
		String message;
		
		message = String.format("=====\n%s\n----\nScore:\t%d\n%s\n=====", p.get_name(), p.get_score(), p.hand.resource_string());
		
		System.out.println(message);
		
		return message;
	}
	
	public String show_occupied(Player p)
	{
		String message;
		
		message = String.format("=====\n%s\n----\nScore:\t%d\n%s\n=====", p.get_name(), p.get_score(), p.occupied_string());
		
		System.out.println(message);
		
		return message;
	}
	
	public String show_available_lairs(Player p)
	{
		String message="";
		
		for(Lair l: p.get_free_lair())
		{
			message += l.toString() + "\n";
		}
		
		message = String.format("Available Lairs to build for %s:\n%s", p.get_name(), message);
		
		System.out.println(message);
		
		return message;
	}
	
	public Lair ask_for_lair(Player p,  ArrayList<Lair> lairs)
	{
		Lair chosen;
		
		String answer;

		int lair_id;
		
		Ask_For_Lair ask = new Ask_For_Lair(p, lairs);
		
		answer = ask.get_input();
		
		lair_id = Integer.valueOf(answer);
		
		chosen = Model.getInstance().table.board.get_lair_by_id(lairs, lair_id);
		
		return chosen;
	}
	
	public Channel ask_for_channel(Player p,  ArrayList<Channel> channels)
	{
		Channel chosen;
		
		String answer;

		int id;
		
		Ask_For_Channel ask = new Ask_For_Channel(p, channels);
		
		answer = ask.get_input();
		
		id = Integer.valueOf(answer);
		
		chosen = Model.getInstance().table.board.get_channel_by_id(id);
		
		return chosen;
	}
	
	public String game_over()
	{
		String message = String.format("Player %s Wins the Game!\n", Model.getInstance().get_winner());
		
		return message;
	}
	
}
