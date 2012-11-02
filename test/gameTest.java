import static org.junit.Assert.*;

import org.junit.Test;


public class gameTest {
	game g = new game();


	@Test
	public void testServer_0_Reciever_0() {
		g.server.setScore("0");
		g.reciever.setScore("0");
		assertEquals("Server=0:Reciever=0", g.printGameResult());
	}
	@Test
	public void testServer_0_Reciever_0_Server_winScore() {
		g.server.setScore("0");
		g.reciever.setScore("0");
		g.server.winScore();
		assertEquals("Server=15:Reciever=0", g.printGameResult());
	}
	@Test
	public void testServer_15_Reciever_0_Server_winScore() {
		g.server.setScore("15");
		g.reciever.setScore("0");
		g.server.winScore();
		assertEquals("Server=30:Reciever=0", g.printGameResult());
	}
	@Test
	public void testServer_30_Reciever_0_Server_winScore() {
		g.server.setScore("30");
		g.reciever.setScore("0");
		g.server.winScore();
		assertEquals("Server=40:Reciever=0", g.printGameResult());
	}
	@Test
	public void testServer_40_Reciever_0_Server_winScore() {
		g.server.setScore("40");
		g.reciever.setScore("0");
		g.server.winScore();
		assertEquals("Server=Win:Reciever=0", g.printGameResult());
	}
	@Test
	public void testServer_0_Reciever_15_Reciever_winScore() {
		g.server.setScore("0");
		g.reciever.setScore("15");
		g.reciever.winScore();
		assertEquals("Server=0:Reciever=30", g.printGameResult());
	}
	@Test
	public void testServer_0_Reciever_30_Reciever_winScore() {
		g.server.setScore("0");
		g.reciever.setScore("30");
		g.reciever.winScore();
		assertEquals("Server=0:Reciever=40", g.printGameResult());
	}
	@Test
	public void testServer_0_Reciever_40_Reciever_winScore() {
		g.server.setScore("0");
		g.reciever.setScore("40");
		g.reciever.winScore();
		assertEquals("Server=0:Reciever=Win", g.printGameResult());
	}
	@Test
	public void testServer_40_Reciever_40_Reciever_winScore() {
		g.server.setScore("40");
		g.reciever.setScore("40");
		g.reciever.winScore();
		assertEquals("Server=40:Reciever=A", g.printGameResult());
	}
	@Test
	public void testServer_40_Reciever_40_Server_winScore() {
		g.server.setScore("40");
		g.reciever.setScore("40");
		g.server.winScore();
		assertEquals("Server=A:Reciever=40", g.printGameResult());
	}
	@Test
	public void testServer_40_Reciever_A_Reciever_winScore() {
		g.server.setScore("40");
		g.reciever.setScore("A");
		g.reciever.winScore();
		assertEquals("Server=40:Reciever=Win", g.printGameResult());
	}
	
	@Test
	public void testServer_A_Reciever_40_Server_winScore() {
		g.server.setScore("A");
		g.reciever.setScore("40");
		g.server.winScore();
		assertEquals("Server=Win:Reciever=40", g.printGameResult());
	}
	@Test
	public void testServer_A_Reciever_40_Reciever_winScore() {
		g.server.setScore("A");
		g.reciever.setScore("40");
		g.reciever.winScore();
		assertEquals("Server=40:Reciever=40", g.printGameResult());
	}
	@Test
	public void testServer_40_Reciever_A_Server_winScore() {
		g.server.setScore("40");
		g.reciever.setScore("A");
		g.server.winScore();
		assertEquals("Server=40:Reciever=40", g.printGameResult());
	}
	@Test
	public void testServer_40_Reciever_30_Server_winScore() {
		g.server.setScore("40");
		g.reciever.setScore("30");
		g.server.winScore();
		assertEquals("Server=Win:Reciever=30", g.printGameResult());
	}
	@Test
	public void testServer_30_Reciever_40_Server_winScore() {
		g.server.setScore("30");
		g.reciever.setScore("40");
		g.server.winScore();
		assertEquals("Server=40:Reciever=40", g.printGameResult());
	}
	@Test
	public void testServer_40_Reciever_30_Reciever_winScore() {
		g.server.setScore("40");
		g.reciever.setScore("30");
		g.reciever.winScore();
		assertEquals("Server=40:Reciever=40", g.printGameResult());
	}
	
	
	
	

}
