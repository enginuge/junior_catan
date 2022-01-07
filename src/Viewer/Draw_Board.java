package viewer;

import board.Board;
import board.Island;
import board.Lair;
import decks.BoardStock;

public class Draw_Board
{
	public void draw_board()
	{
		Board board = Board.getInstance();
		
		System.out.println(board); // print board to see player count and if it is the one true singleton board.
		for(Island i : board.islands)
		{
			draw_island(i);
		}
	}
	
	public void draw_available_stock()
	{
		BoardStock stock = BoardStock.getInstance();
		System.out.println(stock);
	}
	
	public void draw_island(Island island)
	{
		System.out.println(island);

		for(Lair lair : island.lairs)
		{
			draw_lair(lair);
		}
	}
	
	public void draw_lair(Lair lair)
	{
//		String output;
//		
//		output = String.format("%s", lair);
		
		System.out.println(lair);
	}
	
//	public	static void main(String args[])
//	{
//		
//		draw_board();
//	}
}
