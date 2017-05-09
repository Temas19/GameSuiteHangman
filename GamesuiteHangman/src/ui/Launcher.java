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
		
		
		PictionaryUi pu = new PictionaryUi(speler);
		pu.ShowMenu();

	}

}
