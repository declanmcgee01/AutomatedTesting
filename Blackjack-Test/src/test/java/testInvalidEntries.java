import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testInvalidEntries {
	
Blackjack blackjack;
	
	@Before
	public void setUp() {
		blackjack = new Blackjack();
	}
	
	@Test
	public void test1() {
		assertEquals("Error: Invalid entries, input must be between 2 and 31", -1, blackjack.play(1, 1));
	}
	
	@Test
	public void test2() {
		assertEquals("Error: Invalid entries, input must be between 2 and 31", -1, blackjack.play(1, 10));
	}
	
	@Test
	public void test3() {
		assertEquals("Error: Invalid entries, input must be between 2 and 31", -1, blackjack.play(10, 1));
	}
	
	@Test
	public void test4() {
		assertEquals("Error: Invalid entries, input must be between 2 and 31", -1, blackjack.play(32, 32));
	}
	
	@Test
	public void test5() {
		assertEquals("Error: Invalid entries, input must be between 2 and 31", -1, blackjack.play(32, 10));
	}
	
	@Test
	public void test6() {
		assertEquals("Error: Invalid entries, input must be between 2 and 31", -1, blackjack.play(10, 32));
	}
	
	@Test
	public void test7() {
		assertEquals("Error: Invalid entries, cant have negative numbers", -1, blackjack.play(-10, -10));
	}
	
	@Test
	public void test8() {
		assertEquals("Error: Invalid entries, cant have negative numbers", -1, blackjack.play(-10, 10));
	}
	
	@Test
	public void test9() {
		assertEquals("Error: Invalid entries, cant have negative numbers", -1, blackjack.play(10, -10));
	}

}
