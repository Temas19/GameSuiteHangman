package domain;

public class Driehoek extends Vorm {
	
	private Punt hoekpunt1;
	private Punt hoekpunt2;
	private Punt hoekpunt3;
	
	public Driehoek( Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3){
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}
	
	public void setHoekPunten(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3){
		if(hoekPunt1==null||hoekPunt2==null||hoekPunt3==null){
				throw new DomainException("Hoekpunten mogen niet null zijn.");
		}
		if(hoekPunt1.equals(hoekPunt2)||hoekPunt2.equals(hoekPunt3)||hoekPunt1.equals(hoekPunt3)){
				throw new DomainException("Hoekpunten mogen niet samenvallen.");
		}
		
		if(checkOpLijn(hoekPunt1, hoekPunt2, hoekPunt3)){
				throw new DomainException("Punten mogen niet op 1 lijn liggen.");
		}
		else{
			this.hoekpunt1 = hoekPunt1;
			this.hoekpunt2 = hoekPunt2;
			this.hoekpunt3 = hoekPunt3;
		}
		
	}

	public Punt getHoekPunt1() {
		return this.hoekpunt1;
	}

	public Punt getHoekPunt2() {
		return this.hoekpunt2;
	}

	public Punt getHoekPunt3() {
		return this.hoekpunt3;
	}
	public boolean checkOpLijn(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3){
		if((hoekPunt2.getX()-hoekPunt1.getX())*(hoekPunt3.getY()-hoekPunt1.getY())==(hoekPunt3.getX()-hoekPunt1.getX())*(hoekPunt2.getY()-hoekPunt1.getY())){
			return true;
		}
		return false;
	}
	@Override
	public boolean equals(Object object){
		if(object instanceof Driehoek){
			Driehoek d = (Driehoek) object;
			if(this.getHoekPunt1().equals(d.getHoekPunt1())&&this.getHoekPunt2().equals(d.getHoekPunt2())&&this.getHoekPunt3().equals(d.getHoekPunt3())){
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString(){
		return "Driehoek: hoekpunt1: "+this.hoekpunt1.toString()+" - hoekpunt2: "+this.hoekpunt2.toString()+" - hoekpunt3: "+this.hoekpunt3.toString();
	}
	
	
	
	
}
