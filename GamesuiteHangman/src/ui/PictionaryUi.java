package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;

public class PictionaryUi 
{
	private Speler speler;
	
	public PictionaryUi(Speler speler)
	{}
	
	public void ShowMenu()
	{
		Object[] shapes = {"Punt", "Cirkel", "Rechthoek"};
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen?", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		switch (keuze.toString())
		{
			case "Punt":
				voegPuntToe();
				break;
			
			case "Cirkel": 
				voegCirkelToe();
				break;
				
			case "Rechthoek": 
				voegRechthoekToe();
				break;
		}
	}


		private void voegPuntToe()
		{
			String xString = JOptionPane.showInputDialog("X-coordinaat van het punt:");
			int x = Integer.parseInt(xString);
			
			String yString = JOptionPane.showInputDialog("Y-coordinaat van het punt:");
			int y = Integer.parseInt(yString);
			
			Punt p = new Punt(x,y);
			JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: ("+x+", "+y+")");
		}
		
		private void voegCirkelToe() 
		{
			String xString = JOptionPane.showInputDialog("X-coordinaat van het punt:");
			int x = Integer.parseInt(xString);
			
			String yString = JOptionPane.showInputDialog("Y-coordinaat van het punt:");
			int y = Integer.parseInt(yString);
			
			Punt p = new Punt(x,y);
			
			String Sradius = JOptionPane.showInputDialog("Radius van de cirkel:");
			int radius = Integer.parseInt(Sradius);
			
			Cirkel c = new Cirkel(p, radius);
			
			JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + c.toString());
		}
		
		private void voegRechthoekToe()
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
			
			Rechthoek r = new Rechthoek(bovenhoek, iBreedte, iHoogte);
			JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + r.toString());
		}
}
