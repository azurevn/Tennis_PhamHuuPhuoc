import static org.junit.Assert.*;

import org.junit.Test;

public class MatchTest {
	Player player1st = new Player("Sara");
	Player player2nd = new Player("Tom");
	Match m = new Match(player1st, player2nd);

	@Test
	public void testMatchNull() {
		m.setSets(null);
		assertNull(m.getSets());
	}

	@Test
	public void testPlayer1Win1Set() {
		m.player1stWinASetWithRandomScore();
		assertEquals(player1st.getName() + "=1;" + player2nd.getName() + "=0",
				m.printResultOfMatch());
	}

	@Test
	public void testPlayer1Win2Set_Player1WinMatch() {
		m.player1stWinASetWithRandomScore();
		m.player1stWinASetWithRandomScore();
		assertEquals(player1st.getName() + "=Win;" + player2nd.getName() + "=0",
				m.printResultOfMatch());
	}

	@Test
	public void testPlayer1Win1Set_Player2Win1Set() {
		m.player1stWinASetWithRandomScore();
		m.player2ndWinASetWithRandomScore();
		assertEquals(player1st.getName() + "=1;" + player2nd.getName() + "=1",
				m.printResultOfMatch());
	}

	@Test
	public void testPlayer1Win1Set_Player2Win2Set_Player2WinMatch() {
		m.player1stWinASetWithRandomScore();
		m.player2ndWinASetWithRandomScore();
		m.player2ndWinASetWithRandomScore();
		assertEquals(
				player1st.getName() + "=1;" + player2nd.getName() + "=Win",
				m.printResultOfMatch());
	}

	@Test
	public void testPlayMatchRandom() {
		assertNotNull(m.playAndReturnWinerOfMatchRandom());
	}

}
