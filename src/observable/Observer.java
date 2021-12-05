package observable;

public interface Observer 
{
//	Subject is not necessary for the observer. I think.
//	public Subject subject;
	
	public void update();
	
	public void update(Object object);
}
