package demos;
import game.Table;
import viewer.Draw_Board;

public class Begin_Demo {

	public static void main(String[] args) 
	{
		Table table = Table.getInstance();
		
		table.show_players();

		String string;
		
		string = String.format("Coco Deck size: %d", table.board.coco_deck.size());
		
		System.out.println(string);
		
		Draw_Board view = new Draw_Board();
		
		table.board.islands.get(0).lairs.get(5).set_owner(table.players.get(2));
		
		view.draw_board();
		
		for(int i = 0; i < 10; i++)
		{
			table.die.roll();
			
			System.out.printf("Rolled a %d\n---\n", table.die.one2six());
		}
		
	}

}
