import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LockedPassageTest {

	private IPassage passage;
	
	@Before
	public void setUp() throws Exception {
		this.passage = new LockedPassage("golden-door", null, "big-key");
	}

	@Test
	public void testInitiallyLocked() {
		assertTrue(this.passage.isLocked());
	}
	
	@Test
	public void testGoodKey() {
		Key key = new Key("big-key", "A key");
		assertTrue(this.passage.tryUnlock(key));
	}

	@Test
	public void testBadKey() {
		Key key = new Key("small-key", "A key");
		assertFalse(this.passage.tryUnlock(key));
	}
}
