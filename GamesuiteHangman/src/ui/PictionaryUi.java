package ui;

import javax.swing.JOptionPane;

import domain.Punt;
import domain.Speler;

public class PictionaryUi {
	private Speler speler;
	
	public PictionaryUi(Speler speler){
		
	}
	
	public void ShowMenu(){
		String optieString = JOptionPane.showInputDialog("Wat wilt u doen? \n 1:voeg punt toe.");
		switch (optieString){
			case "1":
				voegPuntToe();
			break;
		}
	}
		private void voegPuntToe(){
			String xString = JOptionPane.showInputDialog("X-coordinaat van het punt:");
			int x = Integer.parseInt(xString);
			String yString = JOptionPane.showInputDialog("Y-coordinaat van het punt:");
			int y = Integer.parseInt(yString);
			Punt p = new Punt(x,y);
			JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: ("+x+", "+y+")");
		}
}
