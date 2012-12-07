import static org.junit.Assert.*;

import org.junit.Test;

public class tournamentTest {
	Tournament t = new Tournament();

	@Test
	public void testGetMatchszNull() {
		t.setMatchs(null);
		assertNull(t.getMatchs());

	}

	@Test
	public void testRunPlayOff1Time() {
		t.createTour();
		t.playOffRandom();
		assertEquals(4, t.matchNumber);

	}
	@Test
	public void testRunPlayOff2Time() {
		t.createTour();
		t.playOffRandom();
		t.playOffRandom();
		assertEquals(2, t.matchNumber);

	}
	@Test
	public void testRunPlayOff3Time() {
		t.createTour();
		t.playOffRandom();
		t.playOffRandom();
		t.playOffRandom();
		assertEquals(1, t.matchNumber);

	}
	@Test
	public void testReturnChampionRandom() {
		t.createTour();
		assertNotNull(t.returnChampionRandom());

	}
	@Test
	public void testReturnNameChampionRandom() {
		t.createTour();
		assertNotNull(t.returnChampionRandom().name);

	}
	@Test
	public void testPrintChampionResult() {
		t.createTour();
		assertNotNull(t.returnChampionRandom().name);

	}
	@Test
	public void testCreateTourWithNumberPlayer() {
		t.createTourWithNumberPlayer(64);
		t.playOffRandom();
		assertEquals(16, t.matchNumber);

	}
	
}
