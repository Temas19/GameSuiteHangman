package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class DriehoekTest {
	private Punt punt1 = new Punt(10, 20);
	private Punt zelfdeAlsPunt1 = new Punt(10, 20);
	private Punt verschillendVanPunt1 = new Punt(15, 20);
	private Punt punt2 = new Punt(20, 40);
	private Punt zelfdeAlsPunt2 = new Punt(20, 40);
	private Punt verschillendVanPunt2 = new Punt(40, 20);
	private Punt punt3 = new Punt(190, 30);
	private Punt zelfdeAlsPunt3 = new Punt(190, 30);
	private Punt verschillendVanPunt3 = new Punt(120, 100);

	@Test
	public void Driehoek_moet_DrieHoek_aanmaken_met_gegeven_hoekpunten() {
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);

		assertEquals(punt1, drieHoek.getHoekPunt1());
		assertEquals(punt2, drieHoek.getHoekPunt2());
		assertEquals(punt3, drieHoek.getHoekPunt3());
	}
	
	@Test (expected = DomainException.class)
	public void Driehoek_Moet_exception_gooien_als_hoekpunt1_null()  {
		new Driehoek(null, punt2, punt3);
	}
	
	@Test (expected = DomainException.class)
	public void Driehoek_Moet_exception_gooien_als_hoekpunt2_null()  {
		new Driehoek(punt1, null, punt3);
	}
	
	@Test (expected = DomainException.class)
	public void DrieHoek_Moet_exception_gooien_als_hoekpunt3_null()  {
		new Driehoek(punt1, punt2, null);
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoekPunt1_verschillend(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(verschillendVanPunt1, zelfdeAlsPunt2, zelfdeAlsPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoekPunt2_verschillend(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, verschillendVanPunt2, zelfdeAlsPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoekPunt3_verschillend(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, zelfdeAlsPunt2, verschillendVanPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		assertFalse(drieHoek.equals(null));
	}
	@Test  (expected = DomainException.class)
	public void setHoekPunten_gooit_DomainException_als_punten_1_en_2_samenvallend_zijn(){
		new Driehoek(punt1, zelfdeAlsPunt1, punt3);
	}
	@Test  (expected = DomainException.class)
	public void setHoekPunten_gooit_DomainException_als_punten_1_en_3_samenvallend_zijn(){
		new Driehoek(punt1, punt2 , zelfdeAlsPunt1);
	}
	@Test  (expected = DomainException.class)
	public void setHoekPunten_gooit_DomainException_als_punten_2_en_3_samenvallend_zijn(){
		new Driehoek(punt1, punt2, zelfdeAlsPunt2);
	}
	@Test  (expected = DomainException.class)
	public void setHoekPunten_gooit_DomainException_als_punten_op_1_lijn_liggen(){
		new Driehoek(punt1, verschillendVanPunt1, verschillendVanPunt2);
	}

}
