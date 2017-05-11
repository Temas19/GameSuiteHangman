package domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WoordenLijst {

	File woorden = new File("hangman.txt");
	ArrayList<String> woorden2 = new ArrayList<>();
	
	public WoordenLijst(){
		
	}
	
	
	public int getAantalWoorden(){
		try(Scanner sc = new Scanner(new FileInputStream(woorden))){
		    int count= 0;
		    
		    while(sc.hasNext()){
		        sc.next();
		        count++;
		    }
		    return count;
		}
		catch(FileNotFoundException e){
			throw new DomainException("File not found", e);
		}
	}
	
	public void voegToe(String woord){
		if(woord == null || woord.trim().isEmpty()){
			throw new DomainException("Woord mag niet leeg zijn!");
		}
		try {
			PrintWriter writer = new PrintWriter(woorden);
			writer.println(woord);
			writer.close();
		}
		catch(FileNotFoundException e){
			throw new DomainException("File not found", e);
		}
	}
	
	public String getRandomWoord(){
		
		Random random = new Random();
		int i = woorden2.size();
		int index = random.nextInt(i);
		
		return woorden2.get(index);
		
	}
	
	public ArrayList<String> lees(){
		try {
			Scanner scannerFile = new Scanner(woorden);
			while(scannerFile.hasNext()){
				Scanner scannerLijn = new Scanner(scannerFile.nextLine());
				scannerLijn.useDelimiter(" / ");
				String woord = scannerLijn.next();
				woorden2.add(woord);
				scannerLijn.close();
			}
			scannerFile.close();
			
		}
		catch (FileNotFoundException e){
			throw new DomainException("Fout bij het inlezen", e);
		}
		return woorden2;
	}
	
}
