package domain;

import java.awt.Graphics;
import java.util.*;

public class Tekening implements Drawable
{
	private String naam;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	private ArrayList<Vorm> vormen = new ArrayList<>();
	
	public Tekening(String naam)
	{
		setNaam(naam);
	}
	
	public void setNaam(String naam)
	{
		if(naam == null || naam.isEmpty()) throw new DomainException("Naam van tekening mag niet null of leeg zijn");
		this.naam = naam;
	}
	
	public String getNaam()
	{
		return naam;
	}
	
	public boolean bevat(Vorm vorm)
	{
		if(vormen.contains(vorm)) return true;
		return false;
	}
	
	public void voegToe(Vorm vorm)
	{
		if(vorm == null) throw new DomainException("Vorm mag niet null zijn!");

		if(this.bevat(vorm)) throw new DomainException("Vorm komt reeds voor!");
		if(vorm.getOmhullende().getMinX() < MIN_X 
				|| vorm.getOmhullende().getMinY() < MIN_Y 
				|| vorm.getOmhullende().getMaxX() > MAX_X 
				|| vorm.getOmhullende().getMaxY() > MAX_Y) throw new DomainException("Jouw omhullende is niet correct");
		
		vormen.add(vorm);
	}
	
	public Vorm getVorm(int index)
	{
		return vormen.get(index);
	}
	
	public int getAantalVormen()
	{
		return vormen.size();
	}
	
	public void verwijder(Vorm vorm)
	{
		if(this.bevat(vorm))
		{
			this.vormen.remove(vorm);
		}
	}
	
	public ArrayList<Vorm> getVormen()
	{
		return vormen;
	}
	
	public int getVormenSize()
	{
		return vormen.size();
	}
	
	public void teken(Graphics graphic)
	{
		for(Vorm vorm: vormen) vorm.teken(graphic);
	}
	
	@Override
	public boolean equals(Object o) 
	{
		boolean check = false;
		if(o instanceof Tekening)
		{
			List<Vorm> tekeningEquals = ((Tekening) o).getVormen();
			if(vormen.size() != tekeningEquals.size()) return false;
			
			for(Vorm vorm: vormen)
			{
				if(!tekeningEquals.contains(vorm)) return false;
				else check = true;
			}
		}
		return check;
	}

	public String toString() 
	{
		String lijst = null;
		for(Vorm vorm : vormen) lijst = lijst + vorm.toString() + "\n";
		return "Tekening met naam " + getNaam() + " bestaat uit " + vormen.size() + " vormen:\n" + lijst;
	}
}
