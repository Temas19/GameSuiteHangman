package ui;

import javax.swing.JOptionPane;

import domain.*;

public class Launcher {
	
	public static void main(String[] args) 
	{
		Speler speler = nieuwSpeler();
		
		Object[] spelen = {"HangMan", "Pictionary"};
		Object keuzeSpel = JOptionPane.showInputDialog(null, "Dag " + speler.getNaam() + ", welk spel wil je spelen?", "input", JOptionPane.INFORMATION_MESSAGE, null, spelen, null);
		
		if(keuzeSpel == null) return;

		if(keuzeSpel.equals("HangMan")){
			HangManUI ui = new HangManUI(speler);
			ui.showMenu();
		}
		
		if(keuzeSpel.equals("Pictionary")){
			PictionaryUi ui = new PictionaryUi(speler);
			ui.showMenu();
		}
	}
	
	private static Speler nieuwSpeler()
	{
		String naam = "";
		Speler newSpeler = null;
		
		while(naam.trim().isEmpty())
		{
			naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");;
			if(naam == null) break;
			try
			{
				newSpeler = new Speler(naam);
			}
			catch(DomainException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				naam = "";
			}
		}
		
		return newSpeler;
	}

}
