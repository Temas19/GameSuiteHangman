package ui;

import javax.swing.JOptionPane;
import domain.*;

public class HangManUI {
	private Speler speler;
	private Object[] spelen = {"HangMan", "Pictionary"};
	private HintWoord newHintWoord = new HintWoord("Projectweek");
	
	public HangManUI(Speler speler)
	{
		setSpeler(speler);
	}

	private void setSpeler(Speler speler)
	{
		if(speler == null) throw new DomainException("Speler kan niet null zijn");
		this.speler = speler;
	}
	
	public void showMenu(){
		boolean running = true;
		while(running){
			
			String keuze = JOptionPane.showInputDialog(null, "Rarara, welk woord zoeken we \n\n" + newHintWoord.toString() + "\n\n Geef een letter:", "HangMan - " + speler.getNaam(), 1);
			
			if (keuze == null){
				running = false;
			}
			else {
				if(newHintWoord.raad(keuze) == true){
					
				}
			}
			
			// Hier verder werken om letters te raden en te tonen 
		}
	}
}
	
	

