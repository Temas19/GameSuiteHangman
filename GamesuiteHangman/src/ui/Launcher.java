
package ui;

import javax.swing.JOptionPane;

import domain.*;

public class Launcher {

	public static void main(String[] args) 
	{
		Speler speler = nieuwSpeler();
		if(speler == null) return;
		PictionaryUi ui = new PictionaryUi(speler);
		ui.showMenu();
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
