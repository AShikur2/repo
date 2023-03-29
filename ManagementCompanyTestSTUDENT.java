import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	// Variables
	ManagementCompany mgmt;
	
	@Before
	public void setUp() throws Exception {
		// Variables
		mgmt = new ManagementCompany("Some company", "123456", 6);
		
		// Add properties
		mgmt.addProperty("Property 1", "Potomac", 100, "JC Tucker0", 2, 1, 2, 2);
		mgmt.addProperty("Property 2", "Rockville", 200, "JC Tucker1", 4, 1, 2, 2);
		mgmt.addProperty("Property 3", "Rockville", 300, "JC Tucker2", 6, 1, 2, 2);			
	}

	@After
	public void tearDown() {
		mgmt = null;  
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		assertEquals(mgmt.addProperty("Sunsational", "Beckman", 2, "BillyBob Wilson", 0, 0 , 1, 1), 3, 0); // 4 arguemnt
		assertEquals(mgmt.addProperty("Property 1", "Potomac", 999, "JC Tucker4", 4,5,2,2), 4, 0); // 8 argument
		assertEquals(mgmt.addProperty("Property 1", "Potomac", 111, "JC Tucker5"), -1, 0); // out of bounds (6th one)	
	}
 
	@Test
	public void testMaxPropertyRent() {
		assertEquals(mgmt.maxRentProp(), 300.0, 0);
	}

	@Test
	public void testTotalRent() {
		assertEquals(mgmt.totalRent(), 600, 0);
	}

 }