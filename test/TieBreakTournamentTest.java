import static org.junit.Assert.*;

import org.junit.Test;


public class TieBreakTournamentTest {
	TieBreakTournament t = new TieBreakTournament();
	
	@Test
	public void testCreateAMatchWith2Player() {
		t.createTourWithNumberPlayer(4);
		assertEquals(2, t.getMatchNumber());
	}

	@Test
	public void testGetMatchNumber() {
		assertEquals(0, t.getMatchNumber());
	}


	@Test
	public void testCreateTourWithNumberPlayer() {
		Player player1st = new Player("Tran Van A");
		Player player2nd = new Player("Nguyen Thi B");
		t.createAMatchWith2Player(player1st, player2nd);
		assertEquals(1, t.getMatchNumber());
		
	}
	
	@Test
	public void testPlayOff1Time(){
		t.createTourWithNumberPlayer(16);
		t.playOffRandom();
		assertEquals(4, t.getMatchNumber());
	}
	@Test
	public void testPlayOff2Time(){
		t.createTourWithNumberPlayer(16);
		t.playOffRandom();
		t.playOffRandom();
		assertEquals(2, t.getMatchNumber());
	}
	
	@Test
	public void testPlayOffRandomToFinal(){
		t.createTourWithNumberPlayer(16);
		t.playTourRandomToFinal();
		assertEquals(1, t.getMatchNumber());
	}
	@Test
	public void testPlayOffRandomToFinalReturnChampion(){
		t.createTourWithNumberPlayer(16);
		t.playTourRandomToFinal();
		assertNotNull(t.returnChampion().getName());
	}
}

