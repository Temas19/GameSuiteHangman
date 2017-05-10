package domain;

public class LijnStuk extends Vorm
{
	private Punt startPunt, eindPunt;
	
	public LijnStuk(Punt startPunt, Punt eindPunt)
	{
		setStartEnEindPunt(startPunt, eindPunt);
	}

	public Punt getEindPunt() {
		return eindPunt;
	}

	public Punt getStartPunt() {
		return startPunt;
	}
	
	private Omhullende getOmhullende()
	{
		Punt linkerBovenhoek = null;
		if(this.startPunt.getY() > this.eindPunt.getY())
		{
			linkerBovenhoek = startPunt;
			int breedte = this.startPunt.getX() - this.eindPunt.getX();
			int hoogte = this.startPunt.getY() - this.eindPunt.getY();
			return new Omhullende(linkerBovenhoek, breedte, hoogte);
		}
		linkerBovenhoek = new Punt(this.startPunt.getX(), this.eindPunt.getY());
		int breedte = this.eindPunt.getX() - this.startPunt.getX();
		int hoogte = this.eindPunt.getY() - this.startPunt.getY();
		return new Omhullende(linkerBovenhoek, breedte, hoogte);
	}
	
	public void setStartEnEindPunt(Punt startPunt, Punt eindPunt)
	{
		if(startPunt == null || eindPunt == null) throw new DomainException("Punten mogen niet null zijn");
		if(startPunt.equals(eindPunt)) throw new DomainException("Punten mogen niet gelijk zijn");
		this.startPunt = startPunt;
		this.eindPunt = eindPunt;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof LijnStuk)
		{
			LijnStuk LijnStuk = (LijnStuk) o;
			if(this.getStartPunt().equals(LijnStuk.getStartPunt()) && this.getEindPunt().equals(LijnStuk.getEindPunt()))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return "Lijn: startpunt: " + startPunt.toString() + " - eindpunt: " + eindPunt.toString();
	}

}
