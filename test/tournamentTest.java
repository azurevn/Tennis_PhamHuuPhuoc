import static org.junit.Assert.*;

import org.junit.Test;

public class tournamentTest {
	tournament t = new tournament();

	@Test
	public void testGetMatchszNull() {
		t.setMatchs(null);
		assertNull(t.getMatchs());

	}

	@Test
	public void testNew() {
		
		player p1 = new player();
		player p2 = new player();
		t.createAMatchWith2Player(p1, p2);
		player p3 = new player();
		player p4 = new player();
		t.createAMatchWith2Player(p3, p4);
		t.setFirstPlayerWinMatch(0);
		t.setSecondPlayerWinMatch(1);
		t.playOff();
		t.setSecondPlayerWinMatch(0);
		assertEquals(p4,t.champion());
		
	}

}
