package controller;

import model.Model;

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
	
	public void setup_game()
	{
		Model model = Model.getInstance();
		
		model.table.players = model.table.create_players();
		
//		model.table.board.coco_deck = model.table.board.setup_coco_tiles();
//
//		model.table.board.islands = model.table.board.setup_islands();
		
		model.table.board.setup();
		
		// Attach the Islands after the Die is created in Table.
		// And the Islands are made in the board setup.
		model.table.board.attach_islands();


	}
}
