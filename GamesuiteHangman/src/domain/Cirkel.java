package domain;

public class Cirkel extends Vorm
{
	private int radius;
	private Punt middelpunt;
	
	public Cirkel(Punt middelpunt, int radius)
	{
		setMiddelpunt(middelpunt);
		setRadius(radius);
	}

	public int getRadius() 
	{
		return radius;
	}

	public void setRadius(int radius) 
	{
		if(radius<=0) throw new DomainException("Radius mag niet kleinder dan of gelijk aan nul zijn");
		this.radius = radius;
	}

	public Punt getMiddelpunt() 
	{
		return middelpunt;
	}

	public void setMiddelpunt(Punt middelpunt) 
	{
		if(middelpunt == null) throw new DomainException("Middelpunt mag niet null zijn");
		this.middelpunt = middelpunt;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Cirkel)
		{
			Cirkel cirkel = (Cirkel) o;
			if(this.radius == cirkel.getRadius() && this.middelpunt.equals(cirkel.getMiddelpunt()))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return "Cirkel: middelPunt: " + this.middelpunt.toString() + " - straal: " + this.radius;
	}
}
