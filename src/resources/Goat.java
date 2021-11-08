package resources;

public class Goat extends Resource
{
	public Goat()
	{
		this.type = "Goat";
	}
	
	@Override
	public Resource give() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void receive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void build_with() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String return_type() {
		return this.type;
	}

	@Override
	public String toString() {
		return this.type;
	}

}
