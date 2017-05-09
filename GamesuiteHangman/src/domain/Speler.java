package domain;

public class Speler {
	private String naam;
	private int score;
	
	public Speler(String naam){
		this.setNaam(naam);
		this.setScore(0);
	}
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		if(naam.trim().isEmpty()||naam==null){
			throw new DomainException("Naam mag niet leeg zijn");
		}
		else{
		this.naam = naam;
		}
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if(score<0){
			throw new DomainException("Score mag niet negatief zijn.");
		}
		else{
		this.score = score;
		}
	}
	public void addToScore(int score){
		setScore(this.score+score);
	}
	@Override
	public boolean equals(Object object){
		if( object instanceof Speler){
			Speler s = (Speler) object;
				if(this.getNaam().equals(s.getNaam())&&this.getScore()==s.getScore()){
					return true;
					}
		}
		return false;
	}
	public String toString(){
		return this.getNaam()+" heeft als score: "+this.getScore();
	}
	
	
	
}
