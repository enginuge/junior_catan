package board;

import java.util.ArrayList;

import Die.Die;
import Player.Player;
import cards.Coco_Tile;
import cards.Coco_Tile_Free_Cutlass_Goat;
import cards.Coco_Tile_Free_Structure;
import cards.Coco_Tile_Free_Wood_Molasses;
import cards.Coco_Tile_Ghost_Pirate;
import cards.Cutlass;
import cards.Goat;
import cards.Gold;
import cards.Molasses;
import cards.Resource;
import cards.Wood;
import decks.Coco_Deck;
import decks.Stockpile;

public class Board
{

	private int player_count = 0;
	
	private int maxResourceCount = 18;
			
	public Coco_Deck coco_deck; // Deck to hold the coco_tiles.
	
	public Stockpile stock_deck; // A deck for the board's stockpile
	
	public ArrayList<Island> islands = new ArrayList<Island>(); 

	private static Board uniqueInstance = null;

	public static Board getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new Board();
		
		return uniqueInstance;
	}
	
	private Board()
	{
		System.out.println("Creating Board...\n");

//		// Moved to Setup method to keep the specific functions private.
//		this.coco_deck = this.setup_coco_tiles();
//
//		this.islands = this.setup_islands();
		
	}
	
	public void setup()
	{
		this.coco_deck = this.setup_coco_tiles();

		this.islands = this.setup_islands();
		
		this.stock_deck = this.setup_stockpile();
	}
	
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
		
		// Add the cut lass goat tiles.
		for(i = 0; i < i_fcg; i++)
			deck.add(free_cutlass_goat);
		
		// Add the wood-molasses tiles.
		for(i = 0; i < i_fwm; i++)
			deck.add(free_wood_molasses);
		
		deck.shuffle();
		
		return deck;
	}
	
	private Stockpile setup_stockpile()
	{
		System.out.println("Setting up Stockpile...");
		
		int i = 0;
		
		Stockpile stock = new Stockpile();
		
		Resource gold = new Gold();
		Resource molasses = new Molasses();
		Resource wood = new Wood();
		Resource cutlass = new Cutlass();
		Resource goat = new Goat();
		
		// Add the ghost pirate tiles.
		for(i = 0; i < maxResourceCount; i++)
		{
			stock.add_stock(gold);
			stock.add_stock(molasses);
			stock.add_stock(wood);
			stock.add_stock(cutlass);
			stock.add_stock(goat);
		}
		return stock;
	}
	
	/* Create Islands A to M.
	 * Returns Array List of Islands.
	 */
	private ArrayList<Island> create_islands()
	{
		Resource wood = new Wood();
		Resource cutlass = new Cutlass();
		Resource gold = new Gold();
		Resource goat = new Goat();
		Resource molasses = new Molasses();
			
		ArrayList<Island> new_islands = new ArrayList<Island>();

		new_islands.add(new Island("A", 3, wood));
		new_islands.add(new Island("B", 4, cutlass));
		new_islands.add(new Island("C", 1, cutlass));
		new_islands.add(new Island("D", 5, gold));
		new_islands.add(new Island("E", 1, wood));
		new_islands.add(new Island("F", 2, wood));
		// Ghost Pirate 	Island  G.	6
		new_islands.add(new Island("H", 2, goat));
		new_islands.add(new Island("I", 1, goat));
		new_islands.add(new Island("J", 3, gold));
		new_islands.add(new Island("K", 4, molasses));
		new_islands.add(new Island("L", 2, molasses));
		new_islands.add(new Island("M", 5, goat));
		
		return new_islands;
	}
	
	/* Create Lairs 1 to 32.
	 * Return array list of lairs.
	 */
	private ArrayList<Lair> create_lairs()
	{
		ArrayList<Lair> new_lairs = new ArrayList<Lair>();
		
		int n = 32;
		
		for(int i = 1; i <= n; i++)
			new_lairs.add(new Lair(i));
		
		return new_lairs;
	}
	
	/* Add the Lairs to the Islands.
	 * Because it is a fixed board game it must
	 * be a fixed setup.
	 * Also attaches the Lairs as observers of the islands.
	 */
	private void place_lairs(ArrayList<Island> islands, ArrayList<Lair> lairs)
	{
		for(Island i: islands)
		{
			switch(i.name)
			{
				case "A":
					i.lairs.add(lairs.get(0));
					i.lairs.add(lairs.get(1));
					i.lairs.add(lairs.get(2));
					i.lairs.add(lairs.get(3));
					i.lairs.add(lairs.get(4));
					i.lairs.add(lairs.get(5));
					break;
				
				case "B":
					i.lairs.add(lairs.get(4));
					i.lairs.add(lairs.get(5));
					i.lairs.add(lairs.get(6));
					i.lairs.add(lairs.get(7));
					break;
					
				case "C":
					i.lairs.add(lairs.get(2));
					i.lairs.add(lairs.get(3));
					i.lairs.add(lairs.get(8));
					i.lairs.add(lairs.get(9));
					break;
					
				case "D":
					i.lairs.add(lairs.get(2));
					i.lairs.add(lairs.get(3));
					i.lairs.add(lairs.get(7));
					i.lairs.add(lairs.get(8));
					i.lairs.add(lairs.get(11));
					i.lairs.add(lairs.get(12));
					break;
					
				case "E":
					i.lairs.add(lairs.get(6));
					i.lairs.add(lairs.get(7));
					i.lairs.add(lairs.get(10));
					i.lairs.add(lairs.get(11));
					i.lairs.add(lairs.get(14));
					i.lairs.add(lairs.get(15));
					break;
					
				case "F":
					i.lairs.add(lairs.get(8));
					i.lairs.add(lairs.get(9));
					i.lairs.add(lairs.get(12));
					i.lairs.add(lairs.get(13));
					i.lairs.add(lairs.get(16));
					i.lairs.add(lairs.get(17));
					break;
					
				case "G":
					i.lairs.add(lairs.get(11));
					i.lairs.add(lairs.get(12));
					i.lairs.add(lairs.get(15));
					i.lairs.add(lairs.get(16));
					i.lairs.add(lairs.get(19));
					i.lairs.add(lairs.get(20));
					break;
					
				case "H":
					i.lairs.add(lairs.get(14));
					i.lairs.add(lairs.get(15));
					i.lairs.add(lairs.get(18));
					i.lairs.add(lairs.get(19));
					i.lairs.add(lairs.get(22));
					i.lairs.add(lairs.get(23));
					break;
					
				case "I":
					i.lairs.add(lairs.get(17));
					i.lairs.add(lairs.get(17));
					i.lairs.add(lairs.get(20));
					i.lairs.add(lairs.get(21));
					i.lairs.add(lairs.get(24));
					i.lairs.add(lairs.get(25));
					break;
					
				case "J":
					i.lairs.add(lairs.get(19));
					i.lairs.add(lairs.get(20));
					i.lairs.add(lairs.get(23));
					i.lairs.add(lairs.get(24));
					i.lairs.add(lairs.get(26));
					i.lairs.add(lairs.get(27));
					break;
					
				case "K":
					i.lairs.add(lairs.get(22));
					i.lairs.add(lairs.get(23));
					i.lairs.add(lairs.get(26));
					i.lairs.add(lairs.get(28));
					break;
					
				case "L":
					i.lairs.add(lairs.get(24));
					i.lairs.add(lairs.get(25));
					i.lairs.add(lairs.get(27));
					i.lairs.add(lairs.get(29));
					break;
					
				case "M":
					i.lairs.add(lairs.get(26));
					i.lairs.add(lairs.get(27));
					i.lairs.add(lairs.get(28));
					i.lairs.add(lairs.get(29));
					i.lairs.add(lairs.get(30));
					i.lairs.add(lairs.get(31));
					break;
				
				default:
					System.out.printf("Island %s, No lairs found.", i.name);
			} // End Island Name Switch Statement.
		} // End Island Loop.
		
		// Attach lairs as observers for each Island.
		for(Island i: islands)
			i.attach_lairs();
	} // End place_lairs function.
	
	private ArrayList<Island> setup_islands()
	{
		System.out.println("Setting up Islands...");

		ArrayList<Island> made_islands = new ArrayList<Island>();
		
		ArrayList<Lair> made_lairs = new ArrayList<Lair>();

		made_islands = this.create_islands();
		
		made_lairs = this.create_lairs();
		
		this.place_lairs(made_islands, made_lairs);
		
		return made_islands;
	}
	
	public void attach_islands()
	{
		for(Island i: this.islands)
			Die.getInstance().attach(i);	// Attach every Island as an Observer of the Die.
	}
	
	public void set_lair_owner(int lair_id, Player player)
	{
		for(Island i: this.islands)
		{
			for(Lair l: i.lairs)
			{
				if(l.identity == lair_id)
					l.set_owner(player);
			}
		}
	}
	public String toString()
	{
		String output;
		
		output = String.format("Board\nPlayer Count:\t%d", this.player_count);
		
		return output;
	}
	
}
