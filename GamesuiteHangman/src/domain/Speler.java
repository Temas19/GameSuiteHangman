package domain;

public class Speler {
	private String naam;
	private int score;
	
	public Speler(String naam)
	{
		setNaam(naam);
		setScore(0);
	}
	
	public String getNaam() 
	{
		return naam;
	}
	
	private void setNaam(String naam) 
	{ 
		if(naam == null || naam.trim().isEmpty())
		{
			throw new DomainException("Naam mag niet leeg zijn");
		}
		this.naam = naam;
	}
	public int getScore() 
	{
		return score;
	}
	
	private void setScore(int score) 
	{
		if(score < 0) throw new DomainException("Score mag niet negatief zijn.");
		this.score = score;
	}
	
	public void addToScore(int score)
	{
		if(score < 0) throw new DomainException("Score mag niet negatief zijn.");
		setScore(this.score + score);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Speler)
		{
			Speler s = (Speler) o;
			if(this.getNaam().equals(s.getNaam()) && this.getScore() == s.getScore()) return true;
		}
		return false;
	}
	public String toString()
	{
		return this.getNaam() + " heeft als score: " + this.getScore();
	}
	
	
	
}
