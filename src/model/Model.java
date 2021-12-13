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
	
	public Model()
	{
		table = new Table();
	}

}
