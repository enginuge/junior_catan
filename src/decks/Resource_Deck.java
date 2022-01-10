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
	
	public int size()
	{
		int s = resources.size();
		return s;
	}
	
	public void remove_all(Object o)
	{
		///get size of resource deck
		int totalcards = resources.size();
		
		//o is the resource we are removing from the hand
		Resource to_remove = (Resource)o;
		
		//cycle through entire list
		// if object i == object o, remove.
		
		for(int i=0; i < totalcards; i++)
		{
			if(resources.get(i) == to_remove)
			{
				resources.remove(i);
			}
		}
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
		{
			System.out.println("This resources empty.");
			return false;
		}
		
		if(temp_small.isEmpty())
		{
			System.out.println("small resources empty.");
			return false;
		}		
		
		if(temp_this.size() < temp_small.size())
		{
			System.out.println("This smaller than small.");
			return false;
		}

		int n = temp_this.size();

		int m = temp_small.size();
		
		int i, j;
		
		Resource r, s;
		
		for(i=0; i < n; i++)
		{
			// Debug.
//			System.out.println(temp_this);
//			System.out.println(temp_small);
			m = temp_small.size();

			r = temp_this.get(i);
			
			for(j = 0; j < m; j++)
			{
				s = temp_small.get(j);
				
				if(r.equals(s))
				{
					temp_this.remove(r);
					
					n = temp_this.size();
					
					temp_small.remove(s);
					
					m = temp_small.size();
					
					i = 0;
					j = 0;
				}
			}
		}
		
		// If the smaller temporary deck is empty then
		// All the cards were found in the bigger deck.
		if(temp_small.size() == 0)
			return true;
		
		System.out.println("Small is not empty after check.");
		return false;
	}
	
	public Resource_Deck subtract_deck(Resource_Deck other)
	{
		if(!this.cards_in(other))
			return this;
		
		List<Resource> temp_other = other.list_resources();

//		for(Resource r: this.resources)
//		{
//			for(Resource s: temp_other)
//			{
//				if(r.equals(s))
//				{
//					this.remove(s);
//					
//					// must remove the temp resources otherwise it will subtract until no resources are left in the players deck.
//					temp_other.remove(s);
//				}
//			}
//		}
		int n = this.resources.size();

		int m = temp_other.size();
		
		int i, j;
		
		Resource r, s;
		
		for(i=0; i < n; i++)
		{
			m = temp_other.size();

			r = this.resources.get(i);
			
			for(j = 0; j < m; j++)
			{
				s = temp_other.get(j);
				
				if(r.equals(s))
				{
					this.resources.remove(r);
					
					n = this.resources.size();
					
					temp_other.remove(s);
					
					m = temp_other.size();
				}
			}
		}
		
		return this;
	}
	
	@Override
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
