package ui;

import javax.swing.JOptionPane;

import domain.DomainException;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);


		JOptionPane.showMessageDialog(null, speler.getNaam() + " zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		Object[] shapes = {"Cirkel", "Rechthoek"};
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen?", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		
		switch(keuze.toString())
		{
		case "Rechthoek":
			Rechthoek r = null;
			try
			{
				String breedte = JOptionPane.showInputDialog("Breedte van de rechthoek:");
				String hoogte = JOptionPane.showInputDialog("Hoogte van de rechthoek:");
				String X = JOptionPane.showInputDialog("X-coördinaat van de linkerbovenhoek:");
				String Y = JOptionPane.showInputDialog("Y-coördinaat van de linkerbovenhoek:");
				
				int iX = Integer.parseInt(X);
				int iY = Integer.parseInt(Y);
				Punt bovenhoek = new Punt(iX, iY);
				
				int iBreedte = Integer.parseInt(breedte);
				int iHoogte = Integer.parseInt(hoogte);
				
				r = new Rechthoek(bovenhoek, iBreedte, iHoogte);
			}
			catch(DomainException e)
			{
				e.getMessage();
			}
			
			JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + r.toString());
			
		}

		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		PictionaryUi pu = new PictionaryUi(speler);
		pu.ShowMenu();

	}

}
