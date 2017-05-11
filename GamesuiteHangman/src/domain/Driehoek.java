package domain;

import java.awt.Graphics;

public class Driehoek extends Vorm {
	
	private Punt hoekpunt1;
	private Punt hoekpunt2;
	private Punt hoekpunt3;
	
	public Driehoek( Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3)
	{
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}
	
	private void setHoekPunten(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3)
	{
		if(hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null)
		{
				throw new DomainException("Hoekpunten mogen niet null zijn.");
		}
		if(hoekPunt1.equals(hoekPunt2) || hoekPunt2.equals(hoekPunt3) || hoekPunt1.equals(hoekPunt3))
		{
				throw new DomainException("Hoekpunten mogen niet samenvallen.");
		}
		if(checkOpLijn(hoekPunt1, hoekPunt2, hoekPunt3))
		{
				throw new DomainException("Punten mogen niet op 1 lijn liggen.");
		}
		else
		{
			this.hoekpunt1 = hoekPunt1;
			this.hoekpunt2 = hoekPunt2;
			this.hoekpunt3 = hoekPunt3;
		}
		
	}

	public Punt getHoekPunt1() {
		return this.hoekpunt1;
	}

	public Punt getHoekPunt2() {
		return this.hoekpunt2;
	}

	public Punt getHoekPunt3() {
		return this.hoekpunt3;
	}
	
	public boolean checkOpLijn(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3)
	{
		if((hoekPunt2.getX()-hoekPunt1.getX()) * (hoekPunt3.getY()-hoekPunt1.getY()) == (hoekPunt3.getX()-hoekPunt1.getX()) * (hoekPunt2.getY()-hoekPunt1.getY())) return true;
		return false;
	}
	
	@Override
	public void teken(Graphics graphic)
	{
		int[] xPoints = { this.getHoekPunt1().getX(), this.getHoekPunt2().getX(),
				this.getHoekPunt3().getX() };
		int[] yPoints = { this.getHoekPunt1().getY(), this.getHoekPunt2().getY(),
				this.getHoekPunt3().getY() };
		graphic.drawPolygon(xPoints, yPoints, 3);
	}
	
	@Override
	public boolean equals(Object object)
	{
		if(object instanceof Driehoek)
		{
			Driehoek d = (Driehoek) object;
			if(this.getHoekPunt1().equals(d.getHoekPunt1())
					&& this.getHoekPunt2().equals(d.getHoekPunt2())
					&& this.getHoekPunt3().equals(d.getHoekPunt3()))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return "Driehoek: hoekpunt1: "+this.hoekpunt1.toString()+" - hoekpunt2: "+this.hoekpunt2.toString()+" - hoekpunt3: "+this.hoekpunt3.toString();
	}

	@Override
	public Omhullende getOmhullende() 
	{
		int hoekPunt1X = this.getHoekPunt1().getX();
		int hoekPunt1Y = this.getHoekPunt1().getY();
		
		int hoekPunt2X = this.getHoekPunt2().getX();
		int hoekPunt2Y = this.getHoekPunt2().getY();
		
		int hoekPunt3X = this.getHoekPunt3().getX();
		int hoekPunt3Y = this.getHoekPunt3().getY();
		
		int minX = 0;
		int maxX = 0;
		int maxY = 0;
		int minY = 0;

		if (hoekPunt1X <= hoekPunt2X) 
		{
			if (hoekPunt1X <= hoekPunt3X) maxX = hoekPunt1X;
			else maxX = hoekPunt3X;
		}
		else if (hoekPunt2X <= hoekPunt3X) maxX = hoekPunt2X;
		else maxX = hoekPunt3X;
		
		
		if (hoekPunt1X >= hoekPunt2X) 
		{
			if (hoekPunt1X >= hoekPunt3X) maxX = hoekPunt1X; 
			else maxX = hoekPunt3X;
		}
		else if (hoekPunt2X >= hoekPunt3X) maxX = hoekPunt2X;
		else maxX = hoekPunt3X;

		
		if (hoekPunt1Y >= hoekPunt2Y) 
		{
			if (hoekPunt1Y >= hoekPunt3Y) minY = hoekPunt1Y;
			else minY = hoekPunt3Y;
		}
		else if (hoekPunt2Y >= hoekPunt3Y) minY = hoekPunt2Y;
		else minY = hoekPunt3Y;

		
		if (hoekPunt1Y <= hoekPunt2Y)
		{
			if (hoekPunt1Y <= hoekPunt3Y) minY = hoekPunt1Y;
			else minY = hoekPunt3Y;
		}
		else if (hoekPunt2Y <= hoekPunt3Y) minY = hoekPunt2Y;
		else minY = hoekPunt3Y;

	    Punt linkerBovenHoek = new Punt(maxX, minY);
		int breedte = maxX - maxX;
		int hoogte = minY - minY;

		Omhullende omhullende = new Omhullende(linkerBovenHoek, breedte, hoogte);

		return omhullende;
	}
}
