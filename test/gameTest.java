import static org.junit.Assert.*;

import org.junit.Test;


public class GameTest {
	
	Game g = new Game();
	
	@Test
	public void testServer_0_Reciever_0() {
		assertEquals("Server=0:Reciever=0", g.printResultGame());
	}
	@Test
	public void testServer_0_Reciever_0_Server_winScore() {
	
		g.serverWinScore();
		assertEquals("Server=15:Reciever=0", g.printResultGame());
	}
	@Test
	public void testServer_15_Reciever_0_Server_winScore() {
		g.setScoreServerAndRecieverInGame("15", "0");
		g.serverWinScore();
		assertEquals("Server=30:Reciever=0", g.printResultGame());
	}
	@Test
	public void testServer_30_Reciever_0_Server_winScore() {
		g.setScoreServerAndRecieverInGame("30", "0");
		g.serverWinScore();
		assertEquals("Server=40:Reciever=0", g.printResultGame());
	}
	@Test
	public void testServer_40_Reciever_0_Server_winScore() {
		g.setScoreServerAndRecieverInGame("40", "0");
		g.serverWinScore();
		assertEquals("Server=Win:Reciever=0", g.printResultGame());
	}
	@Test
	public void testServer_0_Reciever_15_Reciever_winScore() {
		g.setScoreServerAndRecieverInGame("0", "15");
		g.recieverWinScore();
		assertEquals("Server=0:Reciever=30", g.printResultGame());
	}
	@Test
	public void testServer_0_Reciever_30_Reciever_winScore() {
		g.setScoreServerAndRecieverInGame("0", "30");
		g.recieverWinScore();
		assertEquals("Server=0:Reciever=40", g.printResultGame());
	}
	@Test
	public void testServer_0_Reciever_40_Reciever_winScore() {
		g.setScoreServerAndRecieverInGame("0", "40");
		g.recieverWinScore();
		assertEquals("Server=0:Reciever=Win", g.printResultGame());
	}
	@Test
	public void testServer_40_Reciever_40_Reciever_winScore() {
		g.setScoreServerAndRecieverInGame("40", "40");
		g.recieverWinScore();
		assertEquals("Server=40:Reciever=A", g.printResultGame());
	}
	@Test
	public void testServer_40_Reciever_40_Server_winScore() {
		g.setScoreServerAndRecieverInGame("40", "40");
		g.serverWinScore();
		assertEquals("Server=A:Reciever=40", g.printResultGame());
	}
	@Test
	public void testServer_40_Reciever_A_Reciever_winScore() {
		g.setScoreServerAndRecieverInGame("40", "A");
		g.recieverWinScore();
		assertEquals("Server=40:Reciever=Win", g.printResultGame());
	}
	
	@Test
	public void testServer_A_Reciever_40_Server_winScore() {
		g.setScoreServerAndRecieverInGame("A", "40");
		g.serverWinScore();
		assertEquals("Server=Win:Reciever=40", g.printResultGame());
	}
	@Test
	public void testServer_A_Reciever_40_Reciever_winScore() {
		g.setScoreServerAndRecieverInGame("A", "40");
		g.recieverWinScore();
		assertEquals("Server=40:Reciever=40", g.printResultGame());
	}
	@Test
	public void testServer_40_Reciever_A_Server_winScore() {
		g.setScoreServerAndRecieverInGame("40", "A");
		g.serverWinScore();
		assertEquals("Server=40:Reciever=40", g.printResultGame());
	}
	@Test
	public void testServer_40_Reciever_30_Server_winScore() {
		g.setScoreServerAndRecieverInGame("40", "30");
		g.serverWinScore();
		assertEquals("Server=Win:Reciever=30", g.printResultGame());
	}
	@Test
	public void testServer_30_Reciever_40_Server_winScore() {
		g.setScoreServerAndRecieverInGame("30", "40");
		g.serverWinScore();
		assertEquals("Server=40:Reciever=40", g.printResultGame());
	}
	@Test
	public void testServer_40_Reciever_30_Reciever_winScore() {
		g.setScoreServerAndRecieverInGame("40", "30");
		g.recieverWinScore();
		assertEquals("Server=40:Reciever=40", g.printResultGame());
	}
	@Test
	public void testServer_40_Reciever_30_Reciever_win2Score() {
		g.setScoreServerAndRecieverInGame("40", "30");
		g.recieverWinScore();
		g.recieverWinScore();
		assertEquals("Server=40:Reciever=A", g.printResultGame());
	}
	@Test
	public void testPlayRandom() {
		g.playGameTieBreakRandom();
		assertTrue(g.conditionEndGame());
	}

	
	
	
	

}
