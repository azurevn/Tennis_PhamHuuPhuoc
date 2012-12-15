import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest {
	Player p = new Player("player");
	@Test
	public void testPlayerString() {
		assertEquals("player", p.getName());
	}

	@Test
	public void testGetName() {
		p.setName("new Name");
		assertEquals("new Name", p.getName());
	}

	@Test
	public void testGetScore() {
		p.setScore("0");
		assertEquals("0", p.getScore());
	}

	@Test
	public void testIsWin() {
		assertFalse(p.isWin());
	}

	@Test
	public void testReset() {
		p.setScore("40");
		p.setWin(true);
		p.reset();
		assertFalse(p.isWin());
		assertEquals("0", p.getScore());
	}

	@Test
	public void testSetName() {
		p.setName("new Name2");
		assertEquals("new Name2", p.getName());
	}

	@Test
	public void testSetScore() {
		p.setScore("40");
		assertEquals("40", p.getScore());
	
	}

	@Test
	public void testSetWin() {
		p.setWin(true);
		assertTrue(p.isWin());
	}

}
