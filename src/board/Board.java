package board;

public class Board
{
	private static uniqueInstance = null;
	
	public static Board getInstance()
	{
		if(uniqueInstance = null)
			uniqueInstance = new  Board(4);
		
		return uniqueInstance;
	}
	
	private Board(int player_count)
	{
		private int player_count = player_count;
	}
}
