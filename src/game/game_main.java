package game;

import controller.Controller;
import model.Model;
import viewer.Viewer;

public class game_main {
	public static void main(String[] args)
	{
		Model model = new Model();
		
		Controller controller = new Controller();
		
		Viewer viewer = new Viewer();
		
		controller.setup_game();
		
		viewer.db.draw_board();
		
		controller.persistence();
		
	}
}
