package domain;

public class HintWoord {
	private char[] hintLetters;
	private String woord;


	public HintWoord(String woord) {
		setWoord(woord);
		setHintLetters(woord);
	}
	private void setHintLetters(String woord) {
		char[] charArray = woord.toCharArray();
		this.hintLetters = charArray;
	}
	private void setWoord(String woord){
		if(woord==null||woord.trim().isEmpty()){
			throw new DomainException("woord moet geldig zijn.");
		}
		this.woord=woord;
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
