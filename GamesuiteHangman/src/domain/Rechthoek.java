package domain;

import java.awt.Graphics;

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
		if(linkerBovenhoek == null) throw new DomainException("De linkerbovenhoek maag niet leeg zijn");
		this.linkerBovenhoek = linkerBovenhoek;
	}

	private void setBreedte(int breedte) 
	{
		if(breedte <= 0) throw new DomainException("De breedte moet groter zijn dan nul");
		this.breedte = breedte;
	}

	private void setHoogte(int hoogte) 
	{
		if(hoogte <= 0) throw new DomainException("De hoogte moet groter zijn dan nul");
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
	
	public Omhullende getOmhullende()
	{
		return new Omhullende(linkerBovenhoek, breedte, hoogte);
	}
	
	@Override
	public void teken(Graphics graphic)
	{
		graphic.drawRect(this.getLinkerBovenhoek().getX(), 
				this.getLinkerBovenhoek().getY(), 
				this.getBreedte(), 
				this.getHoogte());
	}
	
	
	@Override
	public boolean equals(Object object)
	{
		if( object instanceof Rechthoek)
		{
			Rechthoek r = (Rechthoek) object;
				if(this.getBreedte() == r.getBreedte() 
						&& this.getHoogte() == r.getHoogte() 
						&& this.getLinkerBovenhoek().equals(r.getLinkerBovenhoek())
						&& this.getOmhullende().equals(r.getOmhullende()))
				{
					return true;
				}
		}
		return false;
	}
	
	public String toString()
	{
		return "Rechthoek: positie: (" + linkerBovenhoek.getX() + ", " + linkerBovenhoek.getY() + ") - breedte: " + this.getBreedte() + " - hoogte: " + this.getHoogte() + "\n" + this.getOmhullende().toString();
	}
	

}
