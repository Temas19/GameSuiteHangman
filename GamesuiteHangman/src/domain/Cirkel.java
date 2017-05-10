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

	private void setRadius(int radius) 
	{
		if(radius<=0) throw new DomainException("Radius mag niet kleiner dan of gelijk aan nul zijn");
		this.radius = radius;
	}

	public Punt getMiddelpunt() 
	{
		return middelpunt;
	}

	private void setMiddelpunt(Punt middelpunt) 
	{
		if(middelpunt == null) throw new DomainException("Middelpunt mag niet null zijn");
		this.middelpunt = middelpunt;
	}
	
	public Omhullende getOmhullende()
	{
		Punt linkerBovenhoek = new Punt(this.middelpunt.getX() - this.radius, this.middelpunt.getY() - this.radius);
		return new Omhullende(linkerBovenhoek, this.radius * 2, this.radius * 2);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Cirkel)
		{
			Cirkel cirkel = (Cirkel) o;
			if(this.radius == cirkel.getRadius() && this.middelpunt.equals(cirkel.getMiddelpunt())) return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return "Cirkel: middelPunt: " + this.middelpunt.toString() + " - straal: " + this.radius;
	}
}
