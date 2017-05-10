package domain;

public class Punt {
	private int x;
	private int y;
	
	public Punt(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}

	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Punt)
		{
			Punt p = (Punt) o;
			if(this.getX() == p.getX() && this.getY() == p.getY()) return true;
		}
		return false;
	}

	@Override
	public String toString() 
	{
		return "(" + this.x + "," + this.y + ")";
	}
}
