package board;

import java.util.ArrayList;

public class Occupied_Land 
{
	ArrayList<Lair> lairs;
	
	ArrayList<Channel> channels;
	
	public Occupied_Land()
	{
		lairs = new ArrayList<Lair>();
		
		channels = new ArrayList<Channel>();
	}
	
	public ArrayList<Lair> add_lair(Lair l)
	{
		this.lairs.add(l);
		
		return this.lairs;
	}
	public ArrayList<Lair> get_lairs()
	{
		return this.lairs;
	}
	
	public ArrayList<Channel> add_channel(Channel l)
	{
		this.channels.add(l);
		
		return this.channels;
	}
	
	public ArrayList<Channel> get_channels()
	{
		return this.channels;
	}
	
}
