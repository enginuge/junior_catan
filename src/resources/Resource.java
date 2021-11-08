package resources;

/* Abstract class to help describe the types of resources and the methods they should all have in
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
	
	public int compare(Resource res2)
	{
		return (this.type.toString()).compareTo(res2.toString());
	}
}
