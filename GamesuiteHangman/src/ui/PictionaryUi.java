package ui;

import javax.swing.JOptionPane;

import domain.*;

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
			boolean isFout = true;
			Cirkel c = null;
			
			while(isFout){
				try {
					String xString = JOptionPane.showInputDialog("X-coordinaat van het punt:");
					int iX = Integer.parseInt(xString);

					String yString = JOptionPane.showInputDialog("Y-coordinaat van het punt:");
					int iY = Integer.parseInt(yString);
					
					Punt p = new Punt(iX, iY);
					
					String Sradius = JOptionPane.showInputDialog("Radius van de cirkel:");
					int radius = Integer.parseInt(Sradius);
					
					c = new Cirkel(p, radius);
					isFout = false;
					
				} catch (DomainException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					isFout = true;
				}
			}
			
			JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + c.toString());
		}
		
		private void voegRechthoekToe()
		{
			boolean isFout = true;
			Rechthoek r = null;
			
			while(isFout){
				try{
					String X = JOptionPane.showInputDialog("X-coördinaat van de linkerbovenhoek:");
					String Y = JOptionPane.showInputDialog("Y-coördinaat van de linkerbovenhoek:");
					
					int iX = Integer.parseInt(X);
					int iY = Integer.parseInt(Y);
					
					Punt bovenhoek = new Punt(iX, iY);
					
					String breedte = JOptionPane.showInputDialog("Breedte van de rechthoek:");
					String hoogte = JOptionPane.showInputDialog("Hoogte van de rechthoek:");
					
					int iBreedte = Integer.parseInt(breedte);
					int iHoogte = Integer.parseInt(hoogte);
					
					Omhullende omhullendNewRechthoek = new Omhullende(bovenhoek, iBreedte, iHoogte);
					
					r = new Rechthoek(bovenhoek, iBreedte, iHoogte, omhullendNewRechthoek);
					isFout = false;
					
				} catch (DomainException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					isFout = true;
				}
				
			}
			
			JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + r.toString());
		}
}
