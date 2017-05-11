package ui;

import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi 
{
	private Speler speler;
	private Tekening newTekening;
	private Object[] shapes = {"Cirkel", "Driehoek", "Lijnstuk", "Rechthoek"};

	public PictionaryUi(Speler speler) 
	{
		
		setSpeler(speler);
	}
	
	private void setSpeler(Speler speler)
	{
		if(speler == null) throw new DomainException("Speler kan niet null zijn");
		this.speler = speler;
	}

	public void showMenu()
	{
		boolean running = true;
		newTekening = voegToeNaamTekening();
		GameHoofdScherm mainScherm = new GameHoofdScherm("", newTekening);
		mainScherm.setVisible(true);
		while(running)
		{
			JOptionPane.showMessageDialog(null, "...heeft als score: " + speler.getScore(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			
			String keuze = JOptionPane.showInputDialog("1. Vorm maken \n2. Tekening tonen  \n\n0. Stop \nMaak uw keuze:");
			if(keuze == null || keuze.equals("0"))
			{
				running = false;
			}
			else if(keuze.equals("1"))
			{
				newVormMaken();
				
			}
			else if(keuze.equals("2"))
			{
				mainScherm.teken();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Foute input", "Fout", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	private Tekening voegToeNaamTekening()
	{
		String naam = "";	
		Tekening tekening = null;
		while(naam.trim().isEmpty())
		{
			naam = JOptionPane.showInputDialog("Geef de naam van de tekening:");
			if(naam == null) break;
			try
			{
				tekening = new Tekening(naam);
			}
			catch(DomainException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		return tekening;
	}
	
	private Punt newPuntMaken()
	{
		Punt newPunt = null;
		while(newPunt == null)
		{
			String xCoordinaatStr = JOptionPane.showInputDialog("Geef de X coordinaat in :");
			String yCoordinaatStr = JOptionPane.showInputDialog("Geef de Y coordinaat in :");
			if(xCoordinaatStr == null || yCoordinaatStr == null ||  xCoordinaatStr.trim().isEmpty() || yCoordinaatStr.trim().isEmpty()) break;
			int xCoordinaat = Integer.parseInt(xCoordinaatStr);
			int yCoordinaat = Integer.parseInt(yCoordinaatStr);
			try
			{
				newPunt = new Punt(xCoordinaat, yCoordinaat);
			}
			catch(DomainException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				newPunt = null;
			}
		}
		return newPunt;
	}
	
	private void newVormMaken()
	{
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		if(keuze == null) return;
		
		if(keuze.equals("Cirkel"))
		{
			Cirkel newCirkel = voegCirkelToe();
			if(newCirkel == null) return;
			newTekening.voegToe(newCirkel);
			JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: \n" + newCirkel.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		} 
		else if(keuze.equals("Rechthoek"))
		{
			Rechthoek newRechthoek = voegRechthoekToe();
			if(newRechthoek == null) return;
			newTekening.voegToe(newRechthoek);
			JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: \n" + newRechthoek.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		} 
		else if(keuze.equals("Driehoek"))
		{
			Driehoek newDriehoek = voegDriehoekToe();
			if(newDriehoek == null) return;
			newTekening.voegToe(newDriehoek);
			JOptionPane.showMessageDialog(null, "U heeft een correcte driehoek aangemaakt: \n" + newDriehoek.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		} 
		else if(keuze.equals("Lijnstuk"))
		{
			LijnStuk newLijnstuk = voegLijnStukToe();
			if(newLijnstuk == null) return;
			newTekening.voegToe(newLijnstuk);
			JOptionPane.showMessageDialog(null, "U heeft een correcte lijnstuk aangemaakt: \n" + newLijnstuk.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private Cirkel voegCirkelToe() 
	{
		Cirkel newCirkel = null;
		
		while(newCirkel == null)
		{
			try
			{
				JOptionPane.showMessageDialog(null, "Geef nu de x en y waarde van de middelpunt", null, JOptionPane.INFORMATION_MESSAGE);
				Punt middelPunt = newPuntMaken();
				String radiusStr = JOptionPane.showInputDialog("Geef de radius in :");
				if(middelPunt == null || radiusStr == null || radiusStr.trim().isEmpty()) return null;
				int radius = Integer.parseInt(radiusStr);
				newCirkel = new Cirkel(middelPunt, radius);
			}
			catch(DomainException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				newCirkel = null;
			}
		}
		
		return newCirkel;
	}

	private Rechthoek voegRechthoekToe() 
	{
		Rechthoek newRechthoek = null;
		
		while(newRechthoek == null)
		{
			try
			{
				JOptionPane.showMessageDialog(null, "Geef nu de x en y waarde van de linker boven hoek", null, JOptionPane.INFORMATION_MESSAGE);
				Punt linkerBovenHoek = newPuntMaken();
				String breedteStr = JOptionPane.showInputDialog("Geef de breedte in :");
				String hoogteStr = JOptionPane.showInputDialog("Geef de hoogte in :");
				if(linkerBovenHoek == null || breedteStr == null || hoogteStr == null) return null;
				int breedte = Integer.parseInt(breedteStr);
				int hoogte = Integer.parseInt(hoogteStr);
				
				newRechthoek = new Rechthoek(linkerBovenHoek, breedte, hoogte);
			}
			catch(DomainException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				newRechthoek = null;
			}
		}
		return newRechthoek;
	}

	private Driehoek voegDriehoekToe() 
	{
		Driehoek newDriehoek = null;
		
		while(newDriehoek == null)
		{
			try
			{
				JOptionPane.showMessageDialog(null, "Geef nu de x en y waarde van de eerste hoek", null, JOptionPane.INFORMATION_MESSAGE);
				Punt eersteHoek = newPuntMaken();
				JOptionPane.showMessageDialog(null, "Geef nu de x en y waarde van de tweede hoek", null, JOptionPane.INFORMATION_MESSAGE);
				Punt tweedeHoek = newPuntMaken();
				JOptionPane.showMessageDialog(null, "Geef nu de x en y waarde van de derde hoek", null, JOptionPane.INFORMATION_MESSAGE);
				Punt derdeHoek = newPuntMaken();
				if(eersteHoek == null || tweedeHoek == null || derdeHoek == null) return null;
				
				newDriehoek = new Driehoek(eersteHoek, tweedeHoek, derdeHoek);
			}
			catch(DomainException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				newDriehoek = null;
			}
		}
		
		return newDriehoek;
	}
	
	private LijnStuk voegLijnStukToe()
	{
		LijnStuk newLijnStuk = null;
		
		while(newLijnStuk == null)
		{
			try
			{
				JOptionPane.showMessageDialog(null, "Geef nu de x en y waarde van de eerste hoek", null, JOptionPane.INFORMATION_MESSAGE);
				Punt eerstePunt = newPuntMaken();
				JOptionPane.showMessageDialog(null, "Geef nu de x en y waarde van de tweede hoek", null, JOptionPane.INFORMATION_MESSAGE);
				Punt tweedePunt = newPuntMaken();
				if(eerstePunt == null || tweedePunt == null) return null;
				
				newLijnStuk = new LijnStuk(eerstePunt, tweedePunt);
			}
			catch(DomainException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				newLijnStuk = null;
			}
		}
		
		return newLijnStuk;
	}

}
