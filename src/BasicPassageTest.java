import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicPassageTest {

	protected IRoom room1;
	protected IRoom room2;
	protected IPassage passage;

	@Before
	public void setUp() throws Exception {
		this.passage = new BasicPassage("door", null);
		this.room1 = new BasicRoom(Arrays.asList(this.passage),null);
		this.room2 = new BasicRoom(Arrays.asList(this.passage),null);
		this.passage.setTwoRooms(this.room1, this.room2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(this.passage.getOtherSideRoom(this.room1) == this.room2);
		assertTrue(this.passage.getOtherSideRoom(this.room2) == this.room1);
		BasicRoom otherRoom = new BasicRoom(new LinkedList<IPassage>(), null);
		assertNull(this.passage.getOtherSideRoom(otherRoom));
		assertFalse(this.passage.isLocked());
	}

}
