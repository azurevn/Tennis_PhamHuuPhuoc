import static org.junit.Assert.*;

import org.junit.Test;

public class TieBreakGameTest {
	TieBreakGame g = new TieBreakGame();
	Player playerTest = new Player();

	@Test
	public void testGetReciever() {
		g.setReciever(playerTest);
		assertEquals(playerTest, g.getReciever());
	}

	@Test
	public void testGetServer() {
		g.setServer(playerTest);
		assertEquals(playerTest, g.getServer());

	}

//	@Test
//	public void testGetWiner() {
//		g.setWiner(playerTest);
//		assertEquals(playerTest, g.getWiner());
//	}
//
//	@Test
//	public void testWinerFalse() {
//		assertFalse(g.getWiner().isWin());
//	}

	@Test
	public void testSetScoreSeverAndReciever() {
		g.setScoreServerAndReciever("1", "5");
		assertEquals("Server=1;Reciever=5", g.printGameTieBreakResual());
	}

	@Test
	public void test_Server_0_Reviever_5_ServerWin_7_Score() {
		g.setScoreServerAndReciever("0", "5");
		g.serverWinScoreTieBreak();
		g.serverWinScoreTieBreak();
		g.serverWinScoreTieBreak();
		g.serverWinScoreTieBreak();
		g.serverWinScoreTieBreak();
		g.serverWinScoreTieBreak();
		g.serverWinScoreTieBreak();
		g.serverWinScoreTieBreak();
		assertEquals("Server=7;Reciever=5", g.printGameTieBreakResual());
	}

	@Test
	public void test_Server_0_Reviever_5_RecieverWin_2_Score() {
		g.setScoreServerAndReciever("0", "5");
		g.recieverWinScoreTieBreak();
		g.recieverWinScoreTieBreak();
		assertEquals("Server=0;Reciever=7", g.printGameTieBreakResual());
	}

	@Test
	public void test_Server_6_Reviever_6_ServerWin_1_Score() {
		g.setScoreServerAndReciever("6", "6");
		g.serverWinScoreTieBreak();
		assertEquals("Server=7;Reciever=6", g.printGameTieBreakResual());
	}

	@Test
	public void test_Server_6_Reviever_6_ServerWin_2_Score() {
		g.setScoreServerAndReciever("6", "6");
		g.serverWinScoreTieBreak();
		g.serverWinScoreTieBreak();
		assertEquals("Server=8;Reciever=6", g.printGameTieBreakResual());
	}
	@Test
	public void test_Server_6_Reviever_6_ReciverWin_1_Score() {
		g.setScoreServerAndReciever("6", "6");
		g.recieverWinScoreTieBreak();
		assertEquals("Server=6;Reciever=7", g.printGameTieBreakResual());
	}
	@Test
	public void testPlayRandomGameTieBreak(){
		g.playRandomGameTieBreak();
		assertTrue(g.conditionEndTieBreak());
	}
	

}
