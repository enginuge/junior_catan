package decks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cards.Cutlass;
import cards.Goat;
import cards.Gold;
import cards.Molasses;
import cards.Resource;

public class Resource_Deck implements Deck
{
	private List<Resource> resources = new ArrayList<Resource>();
	
	/* Constructor. */
	public Resource_Deck()
	{
		resources.clear();
	}
	
	/* Method to add a resource to the deck for the player. */
	@Override
	public void add(Object o)
	{
		Resource r = (Resource)o;
		
		resources.add(r);
	}

	@Override
	public boolean remove(Object o)
	{
		Resource r = (Resource)o;
		
		for(int i=0; i < resources.size(); i++)
		{
			if(r == resources.get(i))
			{
				resources.remove(i);
				
				return true; // Was able to remove.
			}
		}
		
		return false; // Did not remove.
	}
	
	public List<Resource> list_resources()
	{
		return this.resources;
	}

	@Override
	public void shuffle() 
	{
		Collections.shuffle(resources);
	}

	@Override
	public void sort()
	{
		Resource temp_res = null;
		
		for(int i =0; i < resources.size(); i++)
		{
			for(int j =0; j < resources.size()-1; j++)
			{
				if( resources.get(j).compare(resources.get(j+1)) > 0)
				{
					temp_res = resources.get(j+1);
					
					resources.set(j+1, resources.get(j));
					
					resources.set(j, temp_res);
				}
			}
		}
	}
	
	public boolean cards_in(Resource_Deck smaller_deck)
	{
		List<Resource> temp_this = this.list_resources();
		
		List<Resource> temp_small = smaller_deck.list_resources();
		
		if(temp_this.isEmpty())
			return false;
		
		if(temp_small.isEmpty())
			return false;
		
		if(temp_this.size() < temp_small.size())
			return false;

		for(Resource r: temp_this)
		{
			for(Resource s: temp_small)
			{
				if(r.equals(s))
				{
					temp_this.remove(r);
					
					temp_small.remove(s);
				}
			}
			
		}
		
		if(!temp_small.isEmpty())
			return true;
		
		return false;
	}
	
	public String toString()
	{
		String s = "Resource Deck:\n";
		
		for(int i=0; i < resources.size(); i++)
		{
			s = s + String.format("%s, ", resources.get(i));
		}
		
		s = s.substring(0, s.length() -2); // Cut last ", " off string.
		
		return s;
	}
	
	public static void main(String[] args)
	{
		Resource_Deck deck = new Resource_Deck();
		
		deck.add(new Cutlass());
		deck.add(new Gold());
		deck.add(new Goat());
		deck.add(new Molasses());
		deck.add(new Cutlass());
		
		System.out.println(deck);
		
		deck.shuffle();
		
		System.out.println(deck);
		
		deck.sort();
		
		System.out.println(deck);		
		
		deck.shuffle();
		
		System.out.println(deck);
	}

}
