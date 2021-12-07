package demos;
import Viewer.Draw_Board;
import board.Board;
import game.Table;

public class Begin_Demo {

	public static void main(String[] args) {
		Table table = Table.getInstance();
		
		table.show_players();
		
		Board board = Board.getInstance();
		
//		board.set_player_count(4);
		
		String string;
		
//		String string = String.format("Player Count: %d", board.get_player_count());
		
//		System.out.println(string);
		
		string = String.format("Coco Deck size: %d", board.coco_deck.size());
		
		System.out.println(string);
		
		Draw_Board view = new Draw_Board();
		
		view.draw_board();
		
		board.islands.get(0).lairs.get(5).set_owner(table.players.get(2));
		
		view.draw_board();
		
	}

}
