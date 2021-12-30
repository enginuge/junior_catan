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
		
		return ask.get_input();
		
	}
	
	public String game_over()
	{
		String message = String.format("Player %s Wins the Game!", Model.getInstance().get_winner());
		
		return message;
	}
	
}
