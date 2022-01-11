package cards;

/* Abstract class to help describe the types of cards and the methods they should all have in
 * common.
 * Some of these methods may be suitable to complete here.
 */
public abstract class Resource
{
	/* Variable to hold a string of the resource type. */
	public String type;
	
	/*A method to give away the resource.
	 * It should take it away from the player and return the 
	 * resource of the right type.
	 * 
	 * notes: May need to have a specified player as input. */
	public abstract Resource give();
	
	/* Method for the resource to be collected by a player or market.
	 * Could be unnescesary.
	 */
	public abstract void receive();
	
	/* Method that will take the resource to build with it,
	 * Basically take it out of the players hand.
	 */
	public abstract void build_with();
	
	/* Method to return the type of resource. */
	public abstract String return_type();
	
	/* Create the to string method */
	public abstract String toString();
	
	public Object stringToResour(String a)
	{
		int countGold = 0;
		int countCutlass = 0;
		int countWood = 0;
		int countMolasses = 0;
		int countGoat = 0;
		String gd = "Gold";
		String gt = "Goat";
		String m = "Molasses";
		String c = "Cutlass";
		String w = "Wood";
		
		countGold = a.split(gd, -1).length-1;
		countGoat = a.split(gt, -1).length-1;
		countCutlass = a.split(c, -1).length-1;
		countMolasses = a.split(m, -1).length-1;
		countWood = a.split(w, -1).length-1;
		
		Object desiredResource = 0;
		if (countGoat > 0)
			desiredResource = (new Goat());
		
		else if (countGold > 0)
			desiredResource = (new Gold());
		
		else if (countMolasses > 0)
		{
			System.out.printf("option molasses chosen\n");
			desiredResource = (new Molasses());
		}
		
		else if (countWood > 0)
			desiredResource = (new Wood());
		
		else if (countCutlass > 0)
			desiredResource = (new Cutlass());
		
		return desiredResource;
	}
	
	public int compare(Resource res2)
	{
		return (this.type.toString()).compareTo(res2.toString());
	}
	
	public String get_type()
	{
		return this.type;
	}
	
	public boolean equals(Resource other)
	{
		if(this.type.equals(other.get_type() ) )
			return true;
		
		return false;
	}
}
