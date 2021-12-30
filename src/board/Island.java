package board;

import java.util.ArrayList;

import Die.Die;
import cards.Resource;
import observable.Observer;
import observable.Subject;

/*
 * Class to describe an Island, abstract as there will be many Islands defined.
 */
public class Island extends Subject implements Observer
{
	public Island(String name, int number, Resource resource)
	{
		this.name = name;
		
		this.number = number;
		
		this.resource = resource;
	}
	
	// Island name/letter.
	public String name;
	
	// Enumerate the dice roll of the island.
	// Perhaps import the dice package and its enumerations.
	// rather than the integer.
	public int number;
	
	public Resource resource;
	
	// Have the node lairs listed in each island list.
	public ArrayList<Lair> lairs = new ArrayList<Lair>();

	/*
	 * When the dice rolls the number of this island.
	 * It will get updated.
	 * Which will then need to update its observers, aka the lairs around it.
	 */
	@Override
	public void update()
	{
		System.out.println("Update Island.");
		if(this.number == Die.getInstance().one2six())
			this.notify_observers(this.resource);
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}
	
	public void attach_lairs()
	{
		for(Lair lair: lairs)
			this.attach(lair);
	}
	
	@Override
	public String toString()
	{
		return String.format("Island %s:\tDice: %d\tResource: %s", this.name, this.number, this.resource);
	}

//	Moved to Subject Class.
//	@Override
//	public void notify_observers(Object object)
//	{
//		for (Observer observer : observers)
//		{
//			observer.update(object);
//		}
//	}
	
}
