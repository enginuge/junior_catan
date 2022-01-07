package decks;

import cards.Resource;

/* Each Player has one hand,
 * With a resource deck and coco tile deck. */
public class Hand
{
	private Resource_Deck resource_deck;
	
	private Coco_Deck coco_deck;
	
	public Hand()
	{
		this.resource_deck = new Resource_Deck();
		
		this.coco_deck = new Coco_Deck();
	}

	public void add_resource(Object o)
	{
		this.resource_deck.add(o);
	}
	
	public String resource_string()
	{
		this.resource_deck.sort();
		
		return this.resource_deck.toString();
	}
	
	public Resource_Deck get_resource_deck()
	{
		return this.resource_deck;
	}
}
