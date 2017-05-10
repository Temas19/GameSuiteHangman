package domain;


public class Omhullende extends Vorm

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

	public void setHoogte(int hoogte) 
	{
		if(hoogte < 0) throw new DomainException("Hoogte mag niet kleiner dan of gelijk zijn aan 0");
		this.hoogte = hoogte;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) 
	{
		if(breedte < 0) throw new DomainException("Breedte mag niet kleiner dan of gelijk zijn aan 0");
		this.breedte = breedte;
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	public void setLinkerBovenhoek(Punt linkerBovenhoek) 
	{
		if(linkerBovenhoek == null) throw new DomainException("Punt mag niet null zijn");
		this.linkerBovenhoek = linkerBovenhoek;
	}
	
	public int getMinimum()
	{
		return this.getLinkerBovenhoek().getX();
	}
	
	public int getMaximumX()
	{
		return this.getLinkerBovenhoek().getX() + this.getBreedte();
	}
	
	public int getMinimumY()
	{
		return this.getLinkerBovenhoek().getY();
	}
	
	public int getMaximumY()
	{
		return this.getLinkerBovenhoek().getY() + this.getHoogte();
	}
	
	@Override
	public boolean equals(Object o)
	{
		boolean check = false;
		if(o instanceof Omhullende)
		{
			Omhullende omhullende = (Omhullende) o;
			if(this.getHoogte() == omhullende.getHoogte() && this.getBreedte() == omhullende.getBreedte() 
					&& this.getLinkerBovenhoek().equals(omhullende.getLinkerBovenhoek()))
			{
				check = true;
			}
		}
		return check;
	}
	
	@Override
	public String toString()
	{
		return "Omhullende: " + this.getLinkerBovenhoek().toString() + " - " + this.getBreedte() + " - " + this.getHoogte(); 
	}
}
