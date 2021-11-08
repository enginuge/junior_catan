package demos;
import board.Board;

public class Begin_Demo {

	public static void main(String[] args) {
		Board board = Board.getInstance();
		
		board.set_player_count(4);
		
		String string = String.format("Player Count: %d", board.get_player_count());
		
		System.out.println(string);
	}

}
