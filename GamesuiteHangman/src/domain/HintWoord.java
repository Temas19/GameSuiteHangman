package domain;

public class HintWoord {
	//private char[] hintLetters;

	public HintWoord(String woord) {
		char[] charArray = woord.toCharArray();
		this.hintLetters = charArray;
	}

	public boolean raad(char letter) {
		for (char c : hintLetters) {
			if (c == letter) {
				return true;
			}
		}
		return false;

	}
	public boolean isGeraden
}
