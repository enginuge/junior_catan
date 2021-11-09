package decks;

import java.util.Collections;
import java.util.Stack;

import cards.Coco_Tile;

public class Coco_Deck implements Deck 
{
	public Stack<Coco_Tile> coco_tiles;
	
	/* Initialize the deck,
	 * Initialising it as empty allows the board and the players to
	 * Collect cards with the same class.
	 * The player needs a deck to score a point for the most tiles. 
	 */
	public Coco_Deck()
	{
		this.coco_tiles = new Stack<Coco_Tile>();
	}
	
	@Override
	public void add(Object o) 
	{
		Coco_Tile ct = (Coco_Tile)o;
		
		coco_tiles.push(ct);
	}

	/* Probably not needed as this deck has a stack
	 * instead of an arraylist.
	 * But may be usefule to remove the top card.
	 */
	@Override
	public boolean remove(Object o) {
		if(coco_tiles.size() > 0)
		{
			coco_tiles.pop();
			
			return true; // true when a card has been removed.
		}
		
			
		return false;
	}

	@Override
	public void shuffle() 
	{
		Collections.shuffle(coco_tiles);
	}

	@Override
	public void sort()
	{
		// The stack cannot be sorted easily...
	}

}
