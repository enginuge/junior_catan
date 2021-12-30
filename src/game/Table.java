package game;

import java.util.ArrayList;
import java.util.Scanner;

import Die.Die;
import Player.Player;
import board.Board;

/*
 * The Table is a collection of all the players and the board.
 * Effectively the whole picture when it comes to playing the game.
 * This should handle all the happenings of the game and players and board.
 */
public class Table 
{	
	public int player_count;
	
	public ArrayList<Player> players = new ArrayList<Player>();
	
	public Board board;
	
	public Die die;

	private static Table uniqueInstance = null;

	public static Table getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new Table();
		
		return uniqueInstance;
	}
	
	public Table()
	{
		System.out.printf("Creating Table...\n");
		
//		this.players = this.create_players();
		
		this.board = Board.getInstance(); // Only get the board after the players are made.
		
		this.die = Die.getInstance();

//		Must be done after the Die is created.
		// But shouldn't matter as die is a singleton.
//		this.board.attach_islands();
	}
	
	/*
	 * Method to Scan the amount of players.
	 * And ask each player which color they want.
	 * Colors are case sensitive and disapear once selected.
	 */
	public ArrayList<Player> create_players()
	{
		System.out.println("Creating Players...");

		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		
		System.out.print("How many Players: ");  
		
		this.player_count= sc.nextInt();  
		sc.nextLine(); // Work around nextint skipping the first player name.
		
		System.out.println("Player Count= " + player_count); 
		
		ArrayList<String> colors = new ArrayList<String>();
		
		ArrayList<Player> players = new ArrayList<Player>();

		colors.add("White");
		colors.add("Orange");
		colors.add("Red");
		colors.add("Blue");
		
		String name;
		
		for(int i=0; i < player_count; i++)
		{
			// Ensure the player picks an actual color.
			for(name=""; !colors.contains(name); )
			{
				System.out.printf("Player %d, What Color would you like?\n", i+1);
				
				for(String c:colors)
					System.out.printf("%s ", c);
				
				System.out.printf("\nPlayer %d: ", i+1);
				
				name = sc.nextLine();
			} // end correct color loop.
			
			if(colors.contains(name))
			{
				Player p = new Player(name);
				
				players.add(p);
				
				colors.remove(name);
			}
			
		} // end player color selection loop.
		
//		sc.close(); // Close the scanner.
		
		return players;
	} 
	
	public void show_players()
	{
		for(Player p:this.players)
			System.out.println(p);
	}


	
	public static void main(String[] args) 
	{	
		Table t = new Table();
		
		t.players = t.create_players();
		
		t.show_players();
	}
}
