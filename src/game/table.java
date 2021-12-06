package game;

import java.util.ArrayList;
import java.util.Scanner;

import Player.Player;
import board.Board;

/*
 * The table is a collection of all the players and the board.
 * Effectively the whole picture when it comes to playing the game.
 * This should handle all the happenings of the game and players and board.
 */
public class table 
{
	public Board board = Board.getInstance();
	
//	public ArrayList<Player> players = new ArrayList<Player>();

	private Player one 		= new Player("White");
	private Player two 		= new Player("Orange");
	private Player three 	= new Player("Red");
	private Player four 	= new Player("Blue");
	
	
	
	public static void main(String[] args) 
	{	
		// ask for number of players
		// ask each player what colour they want. cant be same colour.
		// begin the game.
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.print("How many Players: ");  
		
		int player_count= sc.nextInt();  
		sc.nextLine(); // Work around nextint skipping the first player name.
		
		System.out.println("Player Count= " + player_count); 
		
		ArrayList<String> colors = new ArrayList<String>();
		ArrayList<Player> players = new ArrayList<Player>();

		colors.add("White");
		colors.add("Orange");
		colors.add("Red");
		colors.add("Blue");
		
		for(int i=0; i < player_count; i++)
		{
			System.out.println("Player "+ i +", What Color would you like?");
			for(String c:colors)
				System.out.print(c);
			
			System.out.print("\nPlayer "+ i +": ");
			
			String name = sc.nextLine();
			
			if(name)
			
			Player p = new Player(name);
			
			players.add(p);
		}
		
		for(Player player:players)
			System.out.println(player);
	}
}
