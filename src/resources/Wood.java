package resources;

public class Wood extends Resource
{
	public Wood()
	{
		this.type = "Wood";
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
