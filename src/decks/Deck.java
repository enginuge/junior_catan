package decks;

public interface Deck 
{
	public void add(Object o); 
	
	public boolean remove(Object o);
	
	public void shuffle();
	
	public void sort();
}
