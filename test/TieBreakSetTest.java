import static org.junit.Assert.*;

import org.junit.Test;


public class TieBreakSetTest {
	Player player1st = new Player("Djokovic");
	Player player2nd = new Player("Federer");
	TieBreakSet s = new TieBreakSet(player1st,player2nd);

	@Test
	public void testSetPlayer1st() {
		assertEquals(player1st, s.getPlayer1st());
	}

	@Test
	public void testSetPlayer2nd() {
		assertEquals(player2nd, s.getPlayer2nd());
	}

	@Test
	public void testPlayer1stWinAGame() {
		s.player1stWinAGameTieBreak();
		assertEquals(1, s.getSetNormal().getGamesPlayer1stWin());
	}

	@Test
	public void testPlayer2ndWinAGame() {
		s.player2ndWinAGameTieBreak();
		assertEquals(1, s.getSetNormal().getGamesPlayer2ndWin());
	}
	@Test
	public void testNewSetHasNoScore(){
		assertEquals(player1st.getName()+"=0;"+player2nd.getName()+"=0", s.printResult());
	}
	
	@Test
	public void testSetScore(){
		s.setScorePlayer1stPlayer2nd(2, 3);
		assertEquals(player1st.getName()+"=2;"+player2nd.getName()+"=3", s.printResult());
	}
	
	@Test
	public void testPlayer1stWin6Game(){
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		assertEquals(player1st.getName()+"=Win;"+player2nd.getName()+"=0", s.printResult());
	}
	
	@Test
	public void testPlayer2ndWin6Game(){
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		
		
		assertEquals(player1st.getName()+"=0;"+player2nd.getName()+"=Win", s.printResult());
	}
	
	@Test
	public void testPlayer1stWin7Game(){
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		s.player1stWinAGameTieBreak();
		
		assertEquals(player1st.getName()+"=Win;"+player2nd.getName()+"=0", s.printResult());
	}
	
	@Test
	public void testPlayer2ndWin7Game(){
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		s.player2ndWinAGameTieBreak();
		assertEquals(player1st.getName()+"=0;"+player2nd.getName()+"=Win", s.printResult());
	}
	
	@Test
	public void testPlayer1stWinWithTieBreak() {
		s.setScorePlayer1stPlayer2nd(6,6);
		s.player1stWinAGameTieBreak();
		assertEquals(player1st.getName()+"=WinTieBreak;"+player2nd.getName()+"=Lose", s.printResult());
		
	}
	
	@Test
	public void testPlayer2ndWinWithTieBreak() {
		s.setScorePlayer1stPlayer2nd(6,6);
		s.player2ndWinAGameTieBreak();
		assertEquals(player1st.getName()+"=Lose;"+player2nd.getName()+"=WinTieBreak", s.printResult());
		
	}
	


}
