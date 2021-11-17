
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany m;
	Property p1, p2, p3, p4, p5, p6;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		//student add three properties, with plots, to mgmt co
		m = new ManagementCompany("Dayma", "18799", 14);
		Property p1 = new Property("Dally", "Libreville", 5000, "Hale", 1, 2, 2, 2);
		Property p2 = new Property("Kojd", "Germantown", 4300, "Hale", 2, 1, 1, 1);
		Property p3 = new Property("This place", "Silver Spring", 3900, "Hale", 3, 3, 1, 1);

		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null
		m = null;
		p1 = p2 = p3 = p4 = p5 = p6 = null;
	}
	@Test
	public void testAddPropertyDefaultPlot() {
	//fail("STUDENT test not implemented yet");
		p4 = new Property("Doyma", "grte", 2443, "Sallyea");
		assertEquals(m.addProperty(p4), 3, 0);
		
		//student should add property with 8 args
		p5 = new Property("Kdse", "bsde", 3500, "lyrt", 4, 6, 2, 2);
		assertEquals(m.addProperty(p5), 4, 0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, 
		//add property should return -1
		p6 = new Property("not existing", "City not existing", 30505, "rgdte", 5, 5, 1, 1);
		assertEquals(m.addProperty(p6), -1, 0);
		
		
	}
 
	@Test
	public void testMaxRentProp() {
		//fail("STUDENT test not implemented yet");
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(), 5000, 0);
	}

	@Test
	public void testTotalRent() {
		//fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(), 13200, 0);
		  
	}

 }