import static org.junit.Assert.*;

import org.junit.Test;


public class matchTest {
	match m = new match();

	@Test
	public void testMatchNull() {
		m.setSets(null);
		assertNull(m.getSets());
	}
	@Test
	public void testPlayer1Win1Set(){
		m.player1WinASet();
		assertEquals("player1=1;player2=0", m.printResultOfMatch());
	}
	@Test
	public void testPlayer1Win2Set_Player1WinMatch(){
		m.player1WinASet();
		m.player1WinASet();
		assertEquals("player1=2;player2=0;Winner=player1", m.printResultOfMatch());
	}
	@Test
	public void testPlayer1Win1Set_Player2Win1Set(){
		m.player1WinASet();
		m.player2WinASet();
		assertEquals("player1=1;player2=1", m.printResultOfMatch());
	}
	@Test
	public void testPlayer1Win1Set_Player2Win2Set_Player2WinMatch(){
		m.player1WinASet();
		m.player2WinASet();
		m.player2WinASet();
		assertEquals("player1=1;player2=2;Winner=player2", m.printResultOfMatch());
	}


}
