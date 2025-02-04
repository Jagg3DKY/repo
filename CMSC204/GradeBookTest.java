import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	private GradeBook gB1, gB2;

	@BeforeEach
	void setUp() throws Exception {
		gB1 = new GradeBook(5);
		gB2 = new GradeBook(5);
		gB1.addScore(56.2);
		gB1.addScore(27.3);
		gB1.addScore(87.4);
		gB2.addScore(22.1);
		gB2.addScore(72.8);
		gB2.addScore(95.1);
		gB2.addScore(62.8);
	}

	@AfterEach
	void tearDown() throws Exception {
		gB1 = null;
		gB2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gB1.toString().equals("56.2 27.3 87.4"));
		assertEquals(3, gB1.getScoreSize());
		assertTrue(gB2.toString().equals("22.1 72.8 95.1 62.8"));
		assertEquals(4, gB2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(56.2 + 27.3 + 87.4, gB1.sum(), 0.01);
		assertEquals(22.1 + 72.8 + 95.1 + 62.8, gB2.sum(), 0.01);
	}

	@Test
	void testMinimum() {
		assertEquals(27.3, gB1.minimum(), 0.01);
		assertEquals(22.1, gB2.minimum(), 0.01);
	}

	@Test
	void testFinalScore() {
		assertEquals(56.2 + 87.4, gB1.finalScore(), .01);
		assertEquals(72.8 + 95.1 + 62.8, gB2.finalScore(), .01);
	}
	
}
