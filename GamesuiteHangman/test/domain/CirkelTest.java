package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class CirkelTest {
	
	Omhullende omhullend = new Omhullende(new Punt(80,180), 40, 40);
	Cirkel cirkel1 = new Cirkel(new Punt(100,200), 20);
	
	@Test(expected = DomainException.class)
	public void cirkel_aanmaken_met_straal_nul_geeft_error()
	{
		new Cirkel(new Punt(1,1), 0);
	}
	
	@Test(expected = DomainException.class)
	public void cirkel_aanmaken_met_negatieve_straal_geeft_error()
	{
		new Cirkel(new Punt(1,1), -1);
	}
	
	@Test(expected = DomainException.class)
	public void cirkel_aanmaken_met_punt_null()
	{
		new Cirkel(null, 1);
	}
	
	@Test
	public void cirkel_aanmaken_met_geldige_waarden()
	{
		Punt testPunt = new Punt(100,200);
		assertEquals(cirkel1.getMiddelpunt(), testPunt);
		assertEquals(cirkel1.getRadius(), 20);
	}
	
	
	@Test
	public void twee_cirkels_zijn_gelijk()
	{
		Cirkel cirkel2 = new Cirkel(new Punt(100,200), 20);
		assertEquals(cirkel1, cirkel2);
	}
	
	@Test
	public void twee_cirkels_verschillend_wanneer_cirkel_null() throws Exception
	{
		Cirkel cirkel2 = null;
		assertEquals(cirkel1.equals(cirkel2), false);
	}
	
	@Test
	public void twee_cirkels_zijn_verschillend_wanner_middelpunt_verschillend()
	{
		Cirkel cirkel2 = new Cirkel(new Punt(50,100), 20);
		assertEquals(cirkel1.equals(cirkel2), false);
	}
	
	@Test
	public void twee_cirkels_zijn_verschillend_wanneer_straal_verschillend()
	{
		Cirkel cirkel2 = new Cirkel(new Punt(100,200), 10);
		assertEquals(cirkel1.equals(cirkel2),false);
	}

}
