package viewer;

/* Interface to make player inputs
 * become more standard for the controller's
 * benefit.
 */
public interface PlayerInput
{
	public String prompt();
	
	public String scan();
	
	public String get_input();
}
