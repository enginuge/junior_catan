package game;

import java.util.ArrayList;

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
	
	private ArrayList<Player> players = new ArrayList<Player>();

	private Player one 		= new Player("White");
	private Player two 		= new Player("Orange");
	private Player three 	= new Player("Red");
	private Player four 	= new Player("Blue");
}
