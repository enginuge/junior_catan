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
import decks.Resource_Deck;
import trading_resources.Stockpile;
import trading_resources.Marketplace;

public class Board
{

	private int player_count = 0;
	
	private int maxResourceCount = 5; //how many cards of each resource exist in the Stockpile at the start of the game
	
	private int totalMarketCount = 5; //how many cards are listed in the marketplace
			
	public Coco_Deck coco_deck; // Deck to hold the coco_tiles.
	
	public Stockpile stockpile;
	
	public Marketplace marketplace;
	
	public ArrayList<Island> islands = new ArrayList<Island>(); 
	
	public ArrayList<Lair> lairs = new ArrayList<Lair>(); 

	public ArrayList<Channel> channels = new ArrayList<Channel>();
	
	public Occupied_Land occupied = new Occupied_Land();
	
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
		
		this.stockpile = this.setup_stock_cards();
		
		this.marketplace = this.setup_market();
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
	
	private Stockpile setup_stock_cards()
	{
		System.out.println("Setting up Board's Stockpile...");
		
		Stockpile stock = new Stockpile();
		
		for (int i = 0; i<maxResourceCount; i++)
		{
			stock.add_card(new Wood());
			stock.add_card(new Goat());
			stock.add_card(new Molasses());
			stock.add_card(new Cutlass());
			stock.add_card(new Gold());
			System.out.println("One round of Stockpile cards Added.");
		}
		//System.out.println("Stockpile is: %s \n");
		return stock;
	}
	
	private Marketplace setup_market()
	{
		System.out.println("Setting up cards in the marketplace...");
		
		Marketplace market = new Marketplace();

		//ad one of each resource card to the marketplace
		market.add_card(new Wood());
		market.add_card(new Goat());
		market.add_card(new Molasses());
		market.add_card(new Cutlass());
		market.add_card(new Gold());
		System.out.println("Marketplace filled up.");
		
		return market;
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
	
	public ArrayList<Channel> create_channels(ArrayList<Lair> lairs)
	{
		ArrayList<Channel> new_channels = new ArrayList<Channel>();
		
		int i;
		
		int n = 37;
		
		for(i = 1; i <= n; i++)
		{
			new_channels.add(new Channel(i));
		}
		
		for(Channel c: new_channels)
		{
			switch(c.get_id())
			{
			case(1):
				c.add_pair(get_lair_by_id(lairs, 1), get_lair_by_id(lairs, 2));
				break;
			case(2):
				c.add_pair(get_lair_by_id(lairs, 2), get_lair_by_id(lairs, 3));
				break;
			case(3):
				c.add_pair(get_lair_by_id(lairs, 3), get_lair_by_id(lairs, 4));
				break;
			case(4):
				c.add_pair(get_lair_by_id(lairs, 4), get_lair_by_id(lairs, 9));
				break;
			case(5):
				c.add_pair(get_lair_by_id(lairs, 9), get_lair_by_id(lairs, 10));
				break;
			case(6):
				c.add_pair(get_lair_by_id(lairs, 10), get_lair_by_id(lairs, 14));
				break;
			case(7):
				c.add_pair(get_lair_by_id(lairs, 14), get_lair_by_id(lairs, 18));
				break;
			case(8):
				c.add_pair(get_lair_by_id(lairs, 18), get_lair_by_id(lairs, 22));
				break;
			case(9):
				c.add_pair(get_lair_by_id(lairs, 22), get_lair_by_id(lairs, 26));
				break;
			case(10):
				c.add_pair(get_lair_by_id(lairs, 25), get_lair_by_id(lairs, 26));
				break;
			case(11):
				c.add_pair(get_lair_by_id(lairs, 25), get_lair_by_id(lairs, 28));
				break;
			case(12):
				c.add_pair(get_lair_by_id(lairs, 28), get_lair_by_id(lairs, 30));
				break;
			case(13):
				c.add_pair(get_lair_by_id(lairs, 30), get_lair_by_id(lairs, 32));
				break;
			case(14):
				c.add_pair(get_lair_by_id(lairs, 31), get_lair_by_id(lairs, 32));
				break;
			case(15):
				c.add_pair(get_lair_by_id(lairs, 31), get_lair_by_id(lairs, 29));
				break;
			case(16):
				c.add_pair(get_lair_by_id(lairs, 27), get_lair_by_id(lairs, 29));
				break;
			case(17):
				c.add_pair(get_lair_by_id(lairs, 24), get_lair_by_id(lairs, 27));
				break;
			case(18):
				c.add_pair(get_lair_by_id(lairs, 23), get_lair_by_id(lairs, 24));
				break;
			case(19):
				c.add_pair(get_lair_by_id(lairs, 19), get_lair_by_id(lairs, 23));
				break;
			case(20):
				c.add_pair(get_lair_by_id(lairs, 15), get_lair_by_id(lairs, 19));
				break;
			case(21):
				c.add_pair(get_lair_by_id(lairs, 11), get_lair_by_id(lairs, 15));
				break;
			case(22):
				c.add_pair(get_lair_by_id(lairs, 7), get_lair_by_id(lairs, 11));
				break;
			case(23):
				c.add_pair(get_lair_by_id(lairs, 7), get_lair_by_id(lairs, 8));
				break;
			case(24):
				c.add_pair(get_lair_by_id(lairs, 5), get_lair_by_id(lairs, 8));
				break;
			case(25):
				c.add_pair(get_lair_by_id(lairs, 5), get_lair_by_id(lairs, 6));
				break;
			case(26):
				c.add_pair(get_lair_by_id(lairs, 1), get_lair_by_id(lairs, 6));
				break;
			case(27):
				c.add_pair(get_lair_by_id(lairs, 4), get_lair_by_id(lairs, 5));
				break;
			case(28):
				c.add_pair(get_lair_by_id(lairs, 9), get_lair_by_id(lairs, 13));
				break;
			case(29):
				c.add_pair(get_lair_by_id(lairs, 12), get_lair_by_id(lairs, 13));
				break;
			case(30):
				c.add_pair(get_lair_by_id(lairs, 8), get_lair_by_id(lairs, 12));
				break;
			case(31):
				c.add_pair(get_lair_by_id(lairs, 13), get_lair_by_id(lairs, 17));
				break;
			case(32):
				c.add_pair(get_lair_by_id(lairs, 17), get_lair_by_id(lairs, 18));
				break;
			case(33):
				c.add_pair(get_lair_by_id(lairs, 17), get_lair_by_id(lairs, 21));
				break;
			case(34):
				c.add_pair(get_lair_by_id(lairs, 20), get_lair_by_id(lairs, 21));
				break;
			case(35):
				c.add_pair(get_lair_by_id(lairs, 16), get_lair_by_id(lairs, 20));
				break;
			case(36):
				c.add_pair(get_lair_by_id(lairs, 15), get_lair_by_id(lairs, 16));
				break;
			case(37):
				c.add_pair(get_lair_by_id(lairs, 12), get_lair_by_id(lairs, 16));
				break;
				
			}
		}
		
		// Need to connect all the lairs together with known connections
		// eg. 1 to 2 and 1 to 6.
		// They are irregular.
		
		// Mark the neighbouring lairs into the lairs themselves, 1 to 2 and 1 to 6...
		// Make a method that creeates a channel between them.
		// And another method that marks it as occupied in both lairs. or each lair checks from both lairs perspectives...
		
		return new_channels;
	}
	
	public ArrayList<Lair> join_lairs_to_channels(ArrayList<Lair> lairs, ArrayList<Channel> channels)
	{
		for(Lair l: lairs)
		{
			for(Channel c: channels)
			{
				for(Lair l2: c.get_lairs())
				{
					if(l.equals(l2))
					{
						l.add_channel(c);
					} // end conditional.
				} // end lair in channel loop.
			} // end all channel loop
		} // end all lairs loop
		
		return lairs;
	}
	
	public Lair get_lair_by_id(ArrayList<Lair> lairs, int id)
	{
		for(Lair l: lairs)
		{
			if(l.get_id() == id)
				return l;
		}
		
		return new Lair(0);
	}
	
	public Channel get_channel_by_id(int id)
	{
		for(Channel c: this.channels)
		{
			if(c.get_id()==id)
				return c;
		}
		
		return new Channel(0);
	}
	
	/* Use on the full list of lairs. */
//	public ArrayList<Lair> connect_lairs(ArrayList<Lair> lairs)
//	{
//		for(Lair l: lairs)
//		{
//			switch(l.get_id())
//			{
//				case 1:
//					
//					break;
//				
//			}
//		}
//		
//		return lairs;
//	}
	
	
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
		
		this.channels = this.create_channels(made_lairs);
		
		made_lairs = this.join_lairs_to_channels(made_lairs, this.channels);
		
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
				if(l.get_id() == lair_id)
					l.set_owner(player);
			}
		}
	}
	
	public void set_channel_owner(int channel_id, Player player)
	{
		for(Channel c: this.channels)
		{
			if(c.get_id() == channel_id)
			{
				c.set_owner(player);
			}
		}
	}
	
	public void get_owned()
	{
//		ArrayList<Lair> owned_lairs = new ArrayList<Lair>();
//		
//		ArrayList<Channel> owned_channels = new ArrayList<Channel>();
		
		for(Island i: this.islands)
		{
			for(Lair l: i.lairs)
			{
				if(l.occupied)
					this.occupied.add_lair(l);
			}
		}
		
		// Owned channels will only be connected to owned lairs.
		for(Channel c: this.channels)
		{
			for(Lair l: this.occupied.get_lairs())
			{
				if(c.connects_to(l))
					this.occupied.add_channel(c);
			}	
		}
		
	}
	
	// retrieve current cards listed in the marketplace
	public Resource_Deck get_marketplace()
	{
		//see what cards are currently in the market
		//list through market instance
		return this.marketplace.get_marketplace();
		//return this.marketplace.resource_string();
		//

	}
	
	public void trade_to_marketplace(Object a, Object b)
	{
		//take cards in/out of marketplace.
		//also refresh and restock as needed
		//Resource c = 
		//Resource d = 
		
		//take out resource A, replace empty slot with resource B
		this.marketplace.add_card(b);
		this.marketplace.remove_card(a);
		//player updated
		
		if(this.marketplace.refresh_deck())
		{
			//restock marketplace: assuming all cards are now of type b, remove the deck and replace with 5 fresh resource cards
			this.marketplace.restock(b);
			//TODO: Add all five of that resource back to stockpile
		}
	}
	
	
	public String toString()
	{
		String output;
		
		output = String.format("Board\nPlayer Count:\t%d", this.player_count);
		
		return output;
	}
	
}
