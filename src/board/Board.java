package board;

import java.util.ArrayList;

import Player.Player;
import cards.Coco_Tile;
import cards.Coco_Tile_Free_Cutlass_Goat;
import cards.Coco_Tile_Free_Structure;
import cards.Coco_Tile_Free_Wood_Molasses;
import cards.Coco_Tile_Ghost_Pirate;
import cards.Resource;
import cards.Wood;
import decks.Coco_Deck;
import game.Table;

public class Board
{
	private static Board uniqueInstance = null;

	private int player_count = 0;
			
	public Coco_Deck coco_deck; // Deck to hold the coco_tiles.
	
	public ArrayList<Island> islands = new ArrayList<Island>(); 
	
	public static Board getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new Board();
		
		return uniqueInstance;
	}
	
	private Board()
	{
		System.out.println("Creating Board...\n");

		coco_deck = this.setup_coco_tiles();

		this.islands = this.setup_islands();
		
	}
	
//	public void setup_board(int player_count)
//	{
//		this.set_player_count(player_count);
//	}
	
//	public void set_player_count(int count)
//	{
//		this.player_count = count;
//	}
//	
//	public int get_player_count()
//	{
//		return this.player_count;
//	}
	
//	public void create_players() 
//	{
////		for(int i; i < this.player_count; i++)
////		{
////			Player
////			this.players.add(null)
////		}
//		if(this.player_count==3)
//		{
//			this.players.add(one);
//			
//			this.players.add(two);
//			
//			this.players.add(three);
//		}
//		
//		if(this.player_count==4)
//		{
//			this.players.add(one);
//			
//			this.players.add(two);
//			
//			this.players.add(three);
//			
//			this.players.add(four);
//		}
//	}
	
	private Coco_Deck setup_coco_tiles()
	{
		System.out.println("Setting up Coco Tiles...");
		
		int i = 0;
		
		Coco_Deck deck = new Coco_Deck();
		
		int i_gp = 11; 	// Count of ghost pirate tiles.

		int i_fs = 3; 	// Count of free Structure tiles.

		int i_fcg = 3; 	// count of free resource cards.
		
		int i_fwm = 3; 	// count of free resource cards.		
		
		Coco_Tile ghost_pirate = new Coco_Tile_Ghost_Pirate();
		
		Coco_Tile free_structure = new Coco_Tile_Free_Structure();
		
		Coco_Tile free_cutlass_goat = new Coco_Tile_Free_Cutlass_Goat();
		
		Coco_Tile free_wood_molasses = new Coco_Tile_Free_Wood_Molasses();
	
		// Add the ghost pirate tiles.
		for(i = 0; i < i_gp; i++)
			deck.add(ghost_pirate);
		
		// Add the free structure tiles.
		for(i = 0; i < i_fs; i++)
			deck.add(free_structure);
		
		// Add the cutlass-goat tiles.
		for(i = 0; i < i_fcg; i++)
			deck.add(free_cutlass_goat);
		
		// Add the wood-molasses tiles.
		for(i = 0; i < i_fwm; i++)
			deck.add(free_wood_molasses);
		
		deck.shuffle();
		
		return deck;
	}
	
	private ArrayList<Island> setup_islands()
	{
		System.out.println("Setting up Islands...");
		Resource wood = new Wood();
		
		ArrayList<Island> new_islands = new ArrayList<Island>();
		
		Island A = new Island("A", 3, wood);
		
		new_islands.add(A);
		
		Lair l1 = new Lair(1);
		Lair l2 = new Lair(2);
		Lair l3 = new Lair(3);
		
//		l3.set_owner(Table.getInstance().players.get(0)); // Set the white player to owner of lair 3.
		
		Lair l4 = new Lair(4);
		Lair l5 = new Lair(5);
		Lair l6 = new Lair(6);
		
//		l6.set_owner(this.players.get(1));
		
		A.attach(l1);
		A.attach(l2);
		A.attach(l3);
		A.attach(l4);
		A.attach(l5);
		A.attach(l6);
		
		A.lairs.add(l1);
		A.lairs.add(l2);
		A.lairs.add(l3);
		A.lairs.add(l4);
		A.lairs.add(l5);
		A.lairs.add(l6);
		
		return new_islands;
	}
	
	public String toString()
	{
		String output;
		
		output = String.format("Board\nPlayer Count:\t%d", this.player_count);
		
//		System.out.println(output);
		
		return output;
	}
	
}
