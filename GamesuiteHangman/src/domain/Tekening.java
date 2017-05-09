package domain;

import java.util.ArrayList;

public class Tekening extends Vorm
{
	private String naam;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 0;
	private static final int MAX_Y = 0;
	private ArrayList<Vorm> vormen = new ArrayList<>();
	
	public Tekening(String naam)
	{
		this.naam = naam;
	}
	
	public String getNaam()
	{
		return naam;
	}
	
	public void voegToe(Vorm vorm)
	{
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
		for(Vorm v : vormen)
		{
			if(v.equals(vorm))
			{
				vormen.remove(v);
			}
		}
	}
	
	public boolean bevat(Vorm vorm)
	{
		for(Vorm v : vormen)
		{
			if(v.equals(vorm))
			{
				return true;
			}
		}
		
		return false;	
	}
}
