package domain;

public class Rechthoek extends Vorm
{
	Punt linkerBovenhoek;
	int breedte, hoogte;
	
	public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte)
	{
		setLinkerBovenhoek(linkerBovenhoek);
		setBreedte(breedte);
		setHoogte(hoogte);
	}

	private void setLinkerBovenhoek(Punt linkerBovenhoek) // fix
	{
		if(linkerBovenhoek == null) throw new DomainException("");
		this.linkerBovenhoek = linkerBovenhoek;
	}

	private void setBreedte(int breedte) 
	{
		if(breedte <= 0) throw new DomainException("");
		this.breedte = breedte;
	}

	private void setHoogte(int hoogte) 
	{
		if(hoogte <= 0) throw new DomainException("");
		this.hoogte = hoogte;
	}

	public Punt getLinkerBovenhoek() 
	{
		return linkerBovenhoek;
	}

	public int getBreedte() 
	{
		return breedte;
	}

	public int getHoogte() 
	{
		return hoogte;
	}
	
	@Override
	public boolean equals(Object object)
	{
		if( object instanceof Rechthoek)
		{
			Rechthoek r = (Rechthoek) object;
				if(this.getBreedte() == r.getBreedte() && this.getHoogte() == r.getHoogte() && this.getLinkerBovenhoek().equals(r.getLinkerBovenhoek()))
				{
					return true;
				}
		}
		return false;
	}
	
	public String toString()
	{
		return "Rechthoek: positie: (" + linkerBovenhoek.getX() + ", " + linkerBovenhoek.getY() + ") - breedte: " + this.getBreedte() + " - hoogte: " + this.getHoogte();
	}
	

}
