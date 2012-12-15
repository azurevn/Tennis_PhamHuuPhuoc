import static org.junit.Assert.*;

import org.junit.Test;

public class TournamentTest {
	Tournament t = new Tournament();

	@Test
	public void testGetMatchszNull() {
		t.setMatchs(null);
		assertNull(t.getMatchs());

	}

	@Test
	public void testRunPlayOff1Time() {
		t.createTour();
		t.playOffRandom1Time();
		assertEquals(4, t.getMatchNumber());

	}
	@Test
	public void testRunPlayOff2Time() {
		t.createTour();
		t.playOffRandom1Time();
		t.playOffRandom1Time();
		assertEquals(2, t.getMatchNumber());

	}
	@Test
	public void testRunPlayOff3Time() {
		t.createTour();
		t.playOffRandom1Time();
		t.playOffRandom1Time();
		t.playOffRandom1Time();
		assertEquals(1, t.getMatchNumber());

	}
	@Test
	public void testReturnChampionRandom() {
		t.createTour();
		assertNotNull(t.playAndReturnChampionRandom());

	}
	@Test
	public void testReturnNameChampionRandom() {
		t.createTour();
		assertNotNull(t.playAndReturnChampionRandom().getName());

	}
	@Test
	public void testPrintChampionResult() {
		t.createTour();
		assertNotNull(t.playAndReturnChampionRandom().getName());

	}
	@Test
	public void testCreateTourWithNumberPlayer() {
		t.createTourWithNumberPlayer(64);
		t.playOffRandom1Time();
		assertEquals(16,t.getMatchNumber());

	}
	@Test
	public void testNumberMatchChampionWin() {
		t.createTourWithNumberPlayer(16);
		assertEquals(4,t.playAndReturnChampionRandom().getNumberMatchWin());

	}
	
}
