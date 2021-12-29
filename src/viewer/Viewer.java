package viewer;

/*
 * The class responsible for showing and asking the
 * Player for inputs.
 */
public class Viewer
{
	private static Viewer uniqueInstance = null;

	public static Viewer getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new Viewer();
		
		return uniqueInstance;
	}
	
	public Draw_Board db;
	
	/* Constructor */
	public Viewer()
	{
		db = new Draw_Board();
	}
	
	public boolean ask_to_roll()
	{
		Ask_Yes_No ask = new Ask_Yes_No();
		
		String answer = ask.get_input();
		
		if(answer == "Yes")
			return true;
		
		return false; 
	}
	
}
