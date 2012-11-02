import static org.junit.Assert.*;

import org.junit.Test;

public class setTest {

	set s = new set();

	@Test
	public void test_Player1_0_Player2_0() {
		s.setScoreOfPlayer1AndPlayer2InSet(0, 0);
		assertEquals("p1:0;p2:0", s.printSetResult());
	}

	@Test
	public void test_Player1_1_Player2_0() {
		s.setScoreOfPlayer1AndPlayer2InSet(1, 0);
		assertEquals("p1:1;p2:0", s.printSetResult());
	}

	@Test
	public void test_Player1_2_Player2_0() {
		s.setScoreOfPlayer1AndPlayer2InSet(2, 0);
		assertEquals("p1:2;p2:0", s.printSetResult());
	}

	@Test
	public void test_Player1_3_Player2_0() {
		s.setScoreOfPlayer1AndPlayer2InSet(3, 0);
		assertEquals("p1:3;p2:0", s.printSetResult());
	}

	@Test
	public void test_Player1_4_Player2_0() {
		s.setScoreOfPlayer1AndPlayer2InSet(4, 0);
		assertEquals("p1:4;p2:0", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_0() {
		s.setScoreOfPlayer1AndPlayer2InSet(5, 0);
		assertEquals("p1:5;p2:0", s.printSetResult());
	}

	@Test
	public void test_Player1_6_Player2_0() {
		s.setScoreOfPlayer1AndPlayer2InSet(6, 0);
		assertEquals("p1:6;p2:0=>Win:p1", s.printSetResult());
	}

	@Test
	public void test_Player1_0_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(0, 0);
		s.player1WinAGame();
		assertEquals("p1:1;p2:0", s.printSetResult());

	}

	@Test
	public void test_Player1_1_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(1, 0);
		s.player1WinAGame();
		assertEquals("p1:2;p2:0", s.printSetResult());

	}

	@Test
	public void test_Player1_2_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(2, 0);
		s.player1WinAGame();
		assertEquals("p1:3;p2:0", s.printSetResult());

	}

	@Test
	public void test_Player1_3_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(3, 0);
		s.player1WinAGame();
		assertEquals("p1:4;p2:0", s.printSetResult());

	}

	@Test
	public void test_Player1_4_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(4, 0);
		s.player1WinAGame();
		assertEquals("p1:5;p2:0", s.printSetResult());

	}

	@Test
	public void test_Player1_5_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(5, 0);
		s.player1WinAGame();
		assertEquals("p1:6;p2:0=>Win:p1", s.printSetResult());

	}

	@Test
	public void test_Player1_6_Player2_0_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(6, 0);
		s.player1WinAGame();
		assertEquals("p1:6;p2:0=>Win:p1", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_5_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(5, 5);
		s.player1WinAGame();
		assertEquals("p1:6;p2:5", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_5_Player2Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(5, 5);
		s.player2WinAGame();
		assertEquals("p1:5;p2:6", s.printSetResult());
	}

	@Test
	public void test_Player1_4_Player2_5_Player2Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(4, 5);
		s.player2WinAGame();
		assertEquals("p1:4;p2:6=>Win:p2", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_4_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(5, 4);
		s.player1WinAGame();
		assertEquals("p1:6;p2:4=>Win:p1", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_4_Player2Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(5, 4);
		s.player2WinAGame();
		assertEquals("p1:5;p2:5", s.printSetResult());
	}

	@Test
	public void test_Player1_6_Player2_5_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(6, 5);
		s.player1WinAGame();
		assertEquals("p1:7;p2:5", s.printSetResult());
	}

	@Test
	public void test_Player1_5_Player2_6_Player1Win1Game() {
		s.setScoreOfPlayer1AndPlayer2InSet(5, 6);
		s.player1WinAGame();
		assertEquals("p1:6;p2:6", s.printSetResult());
	}

}
