package observable;

import java.util.ArrayList;

public abstract class Subject 
{
	protected ArrayList<Observer> observers = new ArrayList<Observer>();
	
	private int state;
	
	public int get_state()
	{
		return this.state;
	}
	
	public void set_state(int state)
	{
		this.state = state;
		
		this.notify_observers();
	}
	
	public void attach(Observer observer)
	{
		observers.add(observer);
	}
	
	/*
	 * Notify the observers without an input.
	 */
	public void notify_observers()
	{
		for (Observer observer : observers)
		{
			observer.update();
		}
	}
	
	/*
	 * Notify the Observers with an input object.
	 */
	public void notify_observers(Object o)
	{
		for (Observer observer : observers)
		{
			observer.update(o);
		}
	}
}
