package domain;


public class Omhullende

{
	private int hoogte, breedte;
	private Punt linkerBovenhoek;
	
	public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte)
	{
		setHoogte(hoogte);
		setBreedte(breedte);
		setLinkerBovenhoek(linkerBovenhoek);
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) 
	{
		if(hoogte < 0) throw new DomainException("Hoogte mag niet kleiner dan of gelijk zijn aan 0");
		this.hoogte = hoogte;
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) 
	{
		if(breedte < 0) throw new DomainException("Breedte mag niet kleiner dan of gelijk zijn aan 0");
		this.breedte = breedte;
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	private void setLinkerBovenhoek(Punt linkerBovenhoek) 
	{
		if(linkerBovenhoek == null) throw new DomainException("Punt mag niet null zijn");
		this.linkerBovenhoek = linkerBovenhoek;
	}
	
	public int getMinX()
	{
		return this.getLinkerBovenhoek().getX();
	}
	
	public int getMaxX()
	{
		return this.getLinkerBovenhoek().getX() + this.getBreedte();
	}
	
	public int getMinY()
	{
		return this.getLinkerBovenhoek().getY();
	}
	
	public int getMaxY()
	{
		return this.getLinkerBovenhoek().getY() + this.getHoogte();
	}
	
	public boolean equals(Object o)
	{
		boolean check = false;
		if(o instanceof Omhullende)
		{
			Omhullende omhullende = (Omhullende) o;
			if(this.getHoogte() == omhullende.getHoogte() 
					&& this.getBreedte() == omhullende.getBreedte() 
					&& this.getLinkerBovenhoek().equals(omhullende.getLinkerBovenhoek()))
			{
				check = true;
			}
		}
		return check;
	}
	
	public String toString()
	{
		return "Omhullende: " + this.getLinkerBovenhoek().toString() + " - " + this.getBreedte() + " - " + this.getHoogte(); 
	}
}
