package domain;

public class HangMan {
	
	private Speler speler;
	private WoordenLijst woordenlijst;

	public HangMan (Speler speler, WoordenLijst woordenlijst){
		setSpeler(speler);
		setWoordenLijst(woordenlijst);
	}
	
	public String getHint(){
		return null;
	}
	
	public void setSpeler(Speler speler){
		if(speler == null){
			throw new DomainException("Speler mag niet null zijn!");
		}
	}
	
	public void setWoordenLijst(WoordenLijst woordenlijst){
		if(woordenlijst == null){
			throw new DomainException("Woordenlijst mag niet null zijn!");
		}
	}
	
	public Speler getSpeler(){
		return null;
	}
	
	public TekeningHangMan getTekening(){
		return null;
	}
	
	public void raad(char letter){
		
	}
	
	public boolean isGameOver(){
		return true;
	}
	
	public boolean isGewonnen(){
		return true;
	}
	
}
