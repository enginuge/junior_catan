package Player;

public class Player
{
	protected String name;
	
	public Player(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return String.format("Name: %s", this.name);
	}
}
