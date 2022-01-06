package controller;

import Player.Player;
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
					
					this.model.table.board.set_channel_owner(25, p);

					this.model.table.board.set_channel_owner(10, p);

					break;
				
				case "White":
					this.model.table.board.set_lair_owner(3, p);
					
					this.model.table.board.set_lair_owner(23, p);
					
					this.model.table.board.set_channel_owner(3, p);

					this.model.table.board.set_channel_owner(18, p);
					
					break;
			
				case "Red":
					this.model.table.board.set_lair_owner(10, p);
					
					this.model.table.board.set_lair_owner(29, p);
					
					this.model.table.board.set_channel_owner(5, p);
					
					this.model.table.board.set_channel_owner(16, p);

					break;
					
				case "Blue":
					this.model.table.board.set_lair_owner(7, p);
					
					this.model.table.board.set_lair_owner(30, p);
					
					this.model.table.board.set_channel_owner(12, p);

					this.model.table.board.set_channel_owner(23, p);

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
		String build_choice;
		
		Turn turn = null;
		
		Player current_player;
		
		while(keep_playing)
		{
			// Check Players Scores.
			for(Player p: this.model.table.players)
			{
				if(p.get_score() >= 7)
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
						build_choice = viewer.ask_to_build(current_player);
						
						if(build_choice.equals("Lair")) {
							turn = new Build_Lair(current_player);
							System.out.println("Lair case chosen.");
						}
						else if(build_choice.equals("Ship"))
							turn = new Build_Ship(current_player);
							
//						turn.act();
						this.play_turn(turn);
						
						break;
						
					case "Trade":
						
						break;
						
					case "Finish":
						
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

	private void play_turn(Turn turn) 
	{
		turn.act();
	}
	
	/* Where is the player allowed to build.
	 * Where they have neighboring areas and not already occupied.
	 * */
	public void available_to_build(Player p)
	{
		Model.getInstance();
		
		switch(p.get_name())
		{
			case "Orange":
				
				
				break;
		}
	}
} // end of class.
