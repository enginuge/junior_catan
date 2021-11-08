package board;

public class Board
{
	private static Board uniqueInstance = null;

	private int player_count = 0;
	
	public static Board getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new Board();
		
		return uniqueInstance;
	}
	
	private Board()
	{
		System.out.println("Beginning Game...\n");
	}
	
	public void set_player_count(int count)
	{
		this.player_count = count;
	}
	
	public int get_player_count()
	{
		return this.player_count;
	}
}
