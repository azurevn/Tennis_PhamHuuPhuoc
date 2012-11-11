import static org.junit.Assert.*;

import org.junit.Test;


public class tournamentTest {
	tournament t = new tournament();
	@Test
	public void testGetMatchszNull() {
		t.setMatchs(null);
		assertNull(t.getMatchs());
		
	}

}
