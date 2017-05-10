package ui;

import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi {
	private Speler speler;

	public PictionaryUi(Speler speler) {
	}

	public void ShowMenu() {
		try {
			// boolean running = true;
			// while (running) {
			Object[] shapes = { "Punt", "Cirkel", "Rechthoek", "Driehoek" };
			Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen?", "input",
					JOptionPane.INFORMATION_MESSAGE, null, shapes, null);

			// if (keuze == null) {
			// running = false;
			// } else {
			switch (keuze.toString()) {
			case "Punt":
				voegPuntToe();
				break;

			case "Cirkel":
				voegCirkelToe();
				break;

			case "Rechthoek":
				voegRechthoekToe();
				break;

			case "Driehoek":
				voegDriehoekToe();
				break;
			// }
			}
			// }
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
			// JOptionPane.ERROR_MESSAGE);
		}

	}

	private Punt voegPuntToe() {

		String xString = JOptionPane.showInputDialog("X-coordinaat van het punt:");
		int x = Integer.parseInt(xString);

		String yString = JOptionPane.showInputDialog("Y-coordinaat van het punt:");
		int y = Integer.parseInt(yString);

		Punt p = new Punt(x, y);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: (" + x + ", " + y + ")");
		return p;
	}

	private void voegCirkelToe() {
		boolean isFout = true;
		Cirkel c = null;

		while (isFout) {
			try {

				Punt p = voegPuntToe();

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

	private void voegRechthoekToe() {
		boolean isFout = true;
		Rechthoek r = null;

		while (isFout) {
			try {

				Punt bovenhoek = voegPuntToe();

				String breedte = JOptionPane.showInputDialog("Breedte van de rechthoek:");
				String hoogte = JOptionPane.showInputDialog("Hoogte van de rechthoek:");

				int iBreedte = Integer.parseInt(breedte);
				int iHoogte = Integer.parseInt(hoogte);

				r = new Rechthoek(bovenhoek, iBreedte, iHoogte);
				isFout = false;

			} catch (DomainException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				isFout = true;
			}

		}

		JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + r.toString());
	}

	private void voegDriehoekToe() {
		boolean isFout = true;
		Driehoek d = null;

		while (isFout) {
			try {
				Punt p1 = voegPuntToe();
				Punt p2 = voegPuntToe();
				Punt p3 = voegPuntToe();
				// hier moet nog een omhullende driehoek bij komen.

				d = new Driehoek(p1, p2, p3);
				isFout = false;
			} catch (DomainException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				isFout = true;
			}
		}
		JOptionPane.showMessageDialog(null, "U heeft een correcte driehoek aangemaakt: " + d.toString());
	}

}
