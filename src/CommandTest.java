import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CommandTest {

	@Test
	public void testVeryBasic() {
		Command cmd = new Command("do");
		assertEquals(cmd.getName(), "do");
		assertEquals(cmd.getParam(0), "do");
		assertNull(cmd.getParam(1));
		assertNull(cmd.getParam(-1));
		assertEquals(cmd.count(), 1);
	}

	@Test
	public void testEmpty() {
		Command cmd = new Command("");
		assertEquals(cmd.getName(), "");
		assertEquals(cmd.getParam(0), "");
		assertEquals(cmd.count(), 1);
	}

	
	@Test
	public void testBlank() {
		Command cmd = new Command("  	");
		assertEquals(cmd.getName(), "");
		assertEquals(cmd.getParam(0), "");
		assertEquals(cmd.count(), 1);
	}
		
	@Test
	public void testBasicWithSpace() {
		Command cmd = new Command(" do  	");
		assertEquals(cmd.getName(), "do");
		assertEquals(cmd.getParam(0), "do");
		assertNull(cmd.getParam(1));
		assertEquals(cmd.count(), 1);
	}

	@Test
	public void testMultipleParams() {
		Command cmd = new Command(" do  what   I want	");
		assertEquals(cmd.getName(), "do");
		assertEquals(cmd.getParam(0), "do");
		assertEquals(cmd.getParam(1), "what");
		assertEquals(cmd.getParam(2), "I");
		assertEquals(cmd.getParam(3), "want");
		assertNull(cmd.getParam(4));
		assertEquals(cmd.count(), 4);
	}

	@Test
	public void testInteger() {
		Command cmd = new Command("take 5 potions");
		assertEquals(cmd.getParamAsInteger(1), 5);
	}

	@Test
	public void testBadInteger() {
		Command cmd = new Command("take nine potions");
		try {
			cmd.getParamAsInteger(1);
			assertTrue(false);
		}
		catch (NumberFormatException e){}
		try {
			cmd.getParamAsInteger(8);
			assertTrue(false);
		}
		catch (NullPointerException e){}
	}
	
	@Test
	public void testMethodParamIs(){
		Command cmd = new Command("try keys toto");
		assertTrue(cmd.paramIs(1, "keys"));
		assertFalse(cmd.paramIs(1, "key"));
		assertFalse(cmd.paramIs(3, "toto"));
	}
	
	@Test
	public void testMethodParamIsIn(){
		Command cmd = new Command("try keys toto");
		assertTrue(cmd.paramIsIn(1, Arrays.asList("keys")));
		assertFalse(cmd.paramIsIn(1, Arrays.asList("key")));
		assertTrue(cmd.paramIsIn(1, Arrays.asList("key", "keys")));
		assertTrue(cmd.paramIsIn(1, Arrays.asList("keys", "key")));
		assertFalse(cmd.paramIsIn(1, Arrays.asList("key", "keyss")));
		assertTrue(cmd.paramIsIn(1, Arrays.asList("toto", "keys", "key")));
		assertFalse(cmd.paramIsIn(5, Arrays.asList("keys", "try", "toto")));
	}
}
