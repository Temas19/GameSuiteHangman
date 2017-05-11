package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import domain.DomainException;
import domain.WoordenLijst;

public class WoordenLezer {

	File woordenFile = new File("hangman.txt");
	ArrayList<String> woorden = new ArrayList<>();
	
	public WoordenLezer(String bestandsNaam){
		
		
		
	}
	
	public ArrayList<String> lees(){
		try {
			Scanner scannerFile = new Scanner(woordenFile);
			while(scannerFile.hasNext()){
				Scanner scannerLijn = new Scanner(scannerFile.nextLine());
				scannerLijn.useDelimiter(" / ");
				String woord = scannerLijn.next();
				woorden.add(woord);
			}
		}
		catch (FileNotFoundException e){
			throw new DomainException("Fout bij het inlezen", e);
		}
		return woorden;
	}
	
	
	public int getAantalWoorden(){
		return lees().size();
	}
}
