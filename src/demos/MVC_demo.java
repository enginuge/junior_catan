package demos;

import controller.Controller;
import model.Model;
import viewer.Viewer;

public class MVC_demo {

	public static void main(String[] args)
	{
		Model model = new Model();
		
		Controller controller = new Controller();
		
		Viewer viewer = new Viewer();
		
		controller.setup_game();
		
		viewer.db.draw_board();
		
		// Turn one players must pick their starting points.
		// The lairs must be owned by the players.
	}
}
