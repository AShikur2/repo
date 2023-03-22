import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	GradeBook grade1;
	GradeBook grade2;

	@BeforeEach
	void setUp() throws Exception {
		grade1 = new GradeBook(5);
		grade2 = new GradeBook(5);
		grade1.addScore(75.0);
		grade1.addScore(80.0);
		grade2.addScore(85.0);
		grade2.addScore(92.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		grade1 = null;
		grade2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(grade1.toString().equals("75.0 80.0"));
	    assertTrue(grade2.toString().equals("85.0 92.0"));
	    assertEquals(grade1.getScoreSize(), 2);
	    assertEquals(grade2.getScoreSize(), 2);
	}

	@Test
	void testSum() {
		assertEquals(grade1.sum(), 155.0);
	    assertEquals(grade2.sum(), 177.0);
	}

	@Test
	void testMinimum() {
		assertEquals(grade1.minimum(), 75.0);
	    assertEquals(grade2.minimum(), 85.0);
	}

	@Test
	void testFinalScore() {
		assertEquals(grade1.finalScore(), 80.0);
	    assertEquals(grade2.finalScore(), 92.0);
	}

}