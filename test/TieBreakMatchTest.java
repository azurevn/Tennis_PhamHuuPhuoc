import static org.junit.Assert.*;

import org.junit.Test;


public class TieBreakMatchTest {
	Player player1st = new Player("Sarapova");
	Player player2nd = new Player("KUKU");
	TieBreakMatch m = new TieBreakMatch(player1st, player2nd);
	

	@Test
	public void testGetPlayer1st() {
		assertEquals(player1st, m.getPlayer1st());
	}

	@Test
	public void testGetPlayer2nd() {
		assertEquals(player2nd, m.getPlayer2nd());
	}
	
	@Test
	public void testPlayer1stWinASet(){
		m.player1stWinASet();
		assertEquals(player1st.getName()+"=1;"+player2nd.getName()+"=0", m.printMatchResult());
		
	}
	
	@Test
	public void testPlayer2ndWinASet(){
		m.player2ndWinASet();
		assertEquals(player1st.getName()+"=0;"+player2nd.getName()+"=1", m.printMatchResult());
		
	}
	
	@Test
	public void testPlayer1stWin2Set(){
		m.player1stWinASet();
		m.player1stWinASet();
		
		assertEquals(player1st.getName()+"=Win;"+player2nd.getName()+"=Lose", m.printMatchResult());
		
	}
	
	@Test
	public void testPlayer1stPlayer2ndWin1Set(){
		m.player1stWinASet();
		m.player2ndWinASet();
		assertEquals(player1st.getName()+"=1;"+player2nd.getName()+"=1", m.printMatchResult());
		
	}
	
	

}
