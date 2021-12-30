package viewer;

import Player.Player;
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
	
	public String game_over()
	{
		String message = String.format("Player %s Wins the Game!\n", Model.getInstance().get_winner());
		
		return message;
	}
	
}
