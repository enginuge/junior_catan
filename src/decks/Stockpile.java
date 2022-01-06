package decks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import cards.Coco_Tile;
import cards.Coco_Tile_Free_Cutlass_Goat;
import cards.Coco_Tile_Free_Structure;
import cards.Coco_Tile_Free_Wood_Molasses;
import cards.Coco_Tile_Ghost_Pirate;
import cards.Cutlass;
import cards.Goat;
import cards.Gold;
import cards.Molasses;
import cards.Wood;
import cards.Resource;


public class Stockpile{

	/* Stockpile could be comprised of five stacks*/
	public Stack<Gold> gold_card;
	public Stack<Molasses> molasses_card;
	public Stack<Wood> wood_card;
	public Stack<Cutlass> cutlass_card;
	public Stack<Goat> goat_card;
	
	private Resource_Deck stockpile;
	
	/* Constructor. Creates 18 of each resource card*/
	public Stockpile()
	{
		this.stockpile = new Resource_Deck();
	}
	
	public void add_stock(Object o)
	{
		this.stockpile.add(o);
	}
	
	public void remove_stock(Object o)
	{
		this.stockpile.remove(o);
	}
	
	public String resource_string()
	{
		return this.stockpile.toString();
	}

}
