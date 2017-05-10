package domain;

import java.util.ArrayList;

public class Tekening extends Vorm
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
	
	private void setNaam(String naam){
		if(naam == null || naam.isEmpty()){
			throw new DomainException("Naam van tekening mag niet null of leeg zijn");
		}
		this.naam = naam;
	}
	
	public String getNaam()
	{
		return naam;
	}
	
	public void voegToe(Vorm vorm)
	{
		for(Vorm vormpje : vormen){
			if(vorm == null){
				throw new DomainException("Vorm mag niet null zijn!");
			}
			if(vormpje.equals(vorm)){
				throw new DomainException("Vorm komt reeds voor!");
			}
		}
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
		if(this.vormen.contains(vorm))
		{
			this.vormen.remove(vorm);
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
	
	public ArrayList<Vorm> getVormen(){
		return vormen;
	}
	
	public int getVormenSize(){
		return vormen.size();
	}

	@Override
	public boolean equals(Object o) 
	{
		boolean check = false;
		if(o instanceof Tekening)
		{
			ArrayList<Vorm> tekeningEquals = ((Tekening) o).getVormen();
			if(vormen.size() != tekeningEquals.size()) return false;
			
			for(Vorm vorm: vormen)
			{
				if(!tekeningEquals.contains(vorm)) 
				{
					return false;
				}
				else
				{
					check = true;
				}
			}
		}
		return check;
	}

	public String toString() {
		String lijst = null;
		for(Vorm vorm : vormen){
			lijst = lijst + vorm.toString() + "\n";
		}
		return "Tekening met naam " + getNaam() + " bestaat uit " + vormen.size() + " vormen:\n" + lijst;
	}
}
