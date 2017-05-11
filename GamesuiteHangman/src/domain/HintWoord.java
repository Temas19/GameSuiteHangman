package domain;

import java.util.ArrayList;

public class HintWoord {
	ArrayList<HintLetter> letters = new ArrayList<>();
	private String woord;
	
	public HintWoord(String woord) {
		if (woord == null || woord.isEmpty()) {
			throw new DomainException("Woord mag niet leeg zijn.");
		}
		this.woord = woord;
		for (int i = 0; i < woord.length(); i++) {
			this.letters.add(new HintLetter(woord.charAt(i)));
			System.out.println(woord.charAt(i));
		}

	}

	public String getWoord() {
		return this.woord;
	}

	public boolean isGeraden() {
		for (HintLetter hintLetter : letters) {
			if (!hintLetter.isGeraden()) {
				return false;
			}
		}
		return true;
	}

	public boolean raad(char c) {
		boolean letterGevonden = false;
		for (HintLetter hintLetter : letters) {
			if (hintLetter.raad(c)) {
				letterGevonden = true;
			}
		}
		if (letterGevonden) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String voorstellingVoorSpeler = "";
		HintLetter hintLetter = null;
		
		hintLetter = letters.get(0);
		if (!hintLetter.isGeraden()){
			voorstellingVoorSpeler += "_";
		}else {
			voorstellingVoorSpeler += hintLetter.getLetter();
		}
		for (int i = 1; i < letters.size(); i++) {
			hintLetter = letters.get(i);
			if (hintLetter.equals(" ")) {
				voorstellingVoorSpeler += "  ";
			} else if (!hintLetter.isGeraden()) {	
				voorstellingVoorSpeler += " _";
			} else {
				voorstellingVoorSpeler += " " + hintLetter.getLetter();
			}
		}
		return voorstellingVoorSpeler;
	}

}
