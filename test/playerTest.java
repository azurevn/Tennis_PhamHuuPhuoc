import static org.junit.Assert.*;

import org.junit.Test;


public class playerTest {
	player p = new player();

	@Test
	public void testGetScore15() {
		p.setScore("15");
		assertEquals("15", p.getScore());
	}
	@Test
	public void testGetScore30() {
		p.setScore("30");
		assertEquals("30", p.getScore());
	}
	@Test
	public void testGetScore40() {
		p.setScore("40");
		assertEquals("40", p.getScore());
	}
	@Test
	public void testGetScoreA() {
		p.setScore("A");
		assertEquals("A", p.getScore());
	}
	
	@Test
	public void testPlayer_Ghi_1_Diem() {
		p.setScore("0");
		p.winScore();
		assertEquals("15", p.getScore());
	}
	@Test
	public void testPlayer_Ghi_2_Diem() {
		p.setScore("0");
		p.winScore();
		p.winScore();
		assertEquals("30", p.getScore());
	}
	@Test
	public void testPlayer_Ghi_3_Diem() {
		p.setScore("0");
		p.winScore();
		p.winScore();
		p.winScore();
		assertEquals("40", p.getScore());
	}
	@Test
	public void testPlayer_Ghi_4_Diem() {
		p.setScore("0");
		p.winScore();
		p.winScore();
		p.winScore();
		p.winScore();
		assertEquals("A", p.getScore());
	}
	@Test
	public void testPlayer_Ghi_5_Diem() {
		p.setScore("0");
		p.winScore();
		p.winScore();
		p.winScore();
		p.winScore();
		p.winScore();
		assertEquals("Win", p.getScore());
	}


	
	

	

}
