import static org.junit.Assert.*;

import org.junit.Test;

public class SetTest {
	Player p1 = new Player("p1");
	Player p2 = new Player("p2");
	Set s = new Set(p1,p2);
	@Test
	public void testNull() {
		s.setGames(null);
		assertNull(s.getGames());
	}

	@Test
	public void test_Player1_0_Player2_0() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(0, 0);
		assertEquals(p1.getName()+"=0;"+p2.getName()+"=0", s.printSetResult());
	}

	@Test
	public void test_Player1_1_Player2_0() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(1, 0);
		assertEquals(p1.getName()+"=1;"+p2.getName()+"=0", s.printSetResult());
	}

	@Test
	public void test_Player1_2_Player2_0() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(2, 0);
		assertEquals(p1.getName()+"=2;"+p2.getName()+"=0", s.printSetResult());
	}

	@Test
	public void test_Player1_3_Player2_0() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(3, 0);
		assertEquals(p1.getName()+"=3;"+p2.getName()+"=0", s.printSetResult());
	}

	@Test
	public void test_Player1_4_Player2_0() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(4, 0);
		assertEquals(p1.getName()+"=4;"+p2.getName()+"=0", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_0() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(5, 0);
		assertEquals(p1.getName()+"=5;"+p2.getName()+"=0", s.printSetResult());
	}

	@Test
	public void test_Player1_6_Player2_0() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(6, 0);
		assertEquals(p1.getName()+"=Win;"+p2.getName()+"=0", s.printSetResult());
	}

	@Test
	public void test_Player1_0_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(0, 0);
		s.addPlayer1stWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=1;"+p2.getName()+"=0", s.printSetResult());

	}

	@Test
	public void test_Player1_1_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(1, 0);
		s.addPlayer1stWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=2;"+p2.getName()+"=0", s.printSetResult());

	}

	@Test
	public void test_Player1_2_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(2, 0);
		s.addPlayer1stWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=3;"+p2.getName()+"=0", s.printSetResult());

	}

	@Test
	public void test_Player1_3_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(3, 0);
		s.addPlayer1stWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=4;"+p2.getName()+"=0", s.printSetResult());

	}

	@Test
	public void test_Player1_4_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(4, 0);
		s.addPlayer1stWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=5;"+p2.getName()+"=0", s.printSetResult());

	}

	@Test
	public void test_Player1_5_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(5, 0);
		s.addPlayer1stWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=Win;"+p2.getName()+"=0", s.printSetResult());

	}

	@Test
	public void test_Player1_6_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(6, 0);
		s.addPlayer1stWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=Win;"+p2.getName()+"=0", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_5_Player1Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(5, 5);
		s.addPlayer1stWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=6;"+p2.getName()+"=5", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_5_Player2Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(5, 5);
		s.addPlayer2ndWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=5;"+p2.getName()+"=6", s.printSetResult());
	}

	@Test
	public void test_Player1_4_Player2_5_Player2Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(4, 5);
		s.addPlayer2ndWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=4;"+p2.getName()+"=Win", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_4_Player1Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(5, 4);
		s.addPlayer1stWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=Win;"+p2.getName()+"=4", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_4_Player2Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(5, 4);
		s.addPlayer2ndWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=5;"+p2.getName()+"=5", s.printSetResult());
	}

	@Test
	public void test_Player1_6_Player2_5_Player1Win1Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(6, 5);
		s.addPlayer1stWinAGameWithRandomScore();
		
		assertEquals(p1.getName()+"=Win;"+p2.getName()+"=5", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_6_Player1Win3Game() {
		s.setScoreOfPlayer1stAndPlayer2ndInSet(5, 6);
		s.addPlayer1stWinAGameWithRandomScore();
		s.addPlayer1stWinAGameWithRandomScore();
		s.addPlayer1stWinAGameWithRandomScore();
		assertEquals(p1.getName()+"=Win;"+p2.getName()+"=6", s.printSetResult());
	}
//	@Test
//	public void test_xxxxxxxxxxxxxxxx() {
//		s.player2ndWinSetRandom();
//		assertTrue(p2.isWin());
//	}

}
