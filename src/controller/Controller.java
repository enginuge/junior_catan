package controller;

import Player.Player;
import board.Lair;
import model.Model;
import viewer.Viewer;

/* The class responsible for interacting with the viewer
 * and the model.
 * Player inputs are put into action and the model is adjusted by
 * the controller.
 * The controller then updates the game.
 */
public class Controller
{
	private static Controller uniqueInstance = null;

	public static Controller getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new Controller();
		
		return uniqueInstance;
	}
	
	/* Constructor */
	public Controller()
	{
		
	}

	Model model = Model.getInstance();
	
	Viewer viewer = Viewer.getInstance();
	
	public void setup_game()
	{
		this.model.table.players = model.table.create_players();
		
//		model.table.board.coco_deck = model.table.board.setup_coco_tiles();
//
//		model.table.board.islands = model.table.board.setup_islands();
		
		this.model.table.board.setup();
		
		// Attach the Islands after the Die is created in Table.
		// And the Islands are made in the board setup.
		this.model.table.board.attach_islands();
		
		this.set_lair_owners();
	}
	
	private void set_lair_owners()
	{
		for(Player p: this.model.table.players)
		{
			switch(p.get_name())
			{
				case "Orange":
					this.model.table.board.set_lair_owner(6, p);
					
					this.model.table.board.set_lair_owner(26, p);
					
					break;
				
				case "White":
					this.model.table.board.set_lair_owner(3, p);
					
					this.model.table.board.set_lair_owner(23, p);
					
					break;
			
				case "Red":
					this.model.table.board.set_lair_owner(10, p);
					
					this.model.table.board.set_lair_owner(29, p);
					
					break;
					
				case "Blue":
					this.model.table.board.set_lair_owner(7, p);
					
					this.model.table.board.set_lair_owner(30, p);
					
					break;
			
				default:
					break;
			} // end of switch
		} // end of player loop
	} // end of lair owner function.
	
	/* The game runs persistently until someone wins.
	 * 
	 */
	public void persistence()
	{
		boolean keep_playing = true;
		
		int t;
		String a;
		String action; // the move the player wants to make. 
		
		Player current_player;
		
		while(keep_playing)
		{
			// Check Players Scores.
			for(Player p: this.model.table.players)
			{
				if(p.score >= 7)
				{
					keep_playing = false;
					
					model.set_winner(p);
				}
			}
			
			for(t=0; t<model.table.player_count; t++ )
			{
				current_player = model.table.players.get(t);
				
				for(a="No"; a.equals("No"); )
				{
					a = viewer.ask_to_roll(current_player);	
				}
				
				if(a.equals("Yes"))
				{
					model.table.die.roll();
					
					viewer.display_roll();
				}
				
				viewer.show_inventory(current_player);
				
				// Ask for the next move.
				action = viewer.ask_for_action(current_player);
				
				switch(action)
				{
					case "Build":
						viewer.ask_to_build(current_player);
						
						break;
						
					case "Trade":
						
						break;
						
					default:
						break;
				}
				// Do the next move.
				
				// Possibly followed by another move after trading
			
				// Trade and then build or build and then trade.
				// Or many times in no order.
				// Either stop by knowing the player can do no more.
				// Or ask them to end their turn.

			}
		} // Game ends.
		
		viewer.game_over();
	}
} // end of class.
