package model;

import game.Table;

/*
 * The representation of data.
 * The stored information of the game.
 * Keeps track of what is happening in the game.
 * Know as the Persistence Mechanism.
 * Should be edited and updated by the controller package and classes.
 */
public class Model {
	
	public Table table;

	private static Model uniqueInstance = null;

	public static Model getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new Model();
		
		return uniqueInstance;
	}
	public Model()
	{
		table = new Table();
	}

}
