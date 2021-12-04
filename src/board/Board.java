package board;

import java.util.ArrayList;

import cards.Coco_Tile;
import cards.Coco_Tile_Free_Cutlass_Goat;
import cards.Coco_Tile_Free_Structure;
import cards.Coco_Tile_Free_Wood_Molasses;
import cards.Coco_Tile_Ghost_Pirate;
import decks.Coco_Deck;

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
		System.out.println("Beginning Game...\n");
		
		coco_deck = this.setup_coco_tiles();
		
		this.islands = this.setup_islands();
	}
	
	public void set_player_count(int count)
	{
		this.player_count = count;
	}
	
	public int get_player_count()
	{
		return this.player_count;
	}
	
	private Coco_Deck setup_coco_tiles()
	{
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
		ArrayList<Island> new_islands = new ArrayList<Island>();
		
		Island A = new Island("A", 3);
		
		new_islands.add(A);
		
		return new_islands;
	}
	
}
