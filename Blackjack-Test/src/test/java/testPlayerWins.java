import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testPlayerWins {
	
Blackjack blackjack;
	
	@Before
	public void setUp() {
		blackjack = new Blackjack();
	}
	
	
	@Test
	public void test1() {
		assertEquals("Error: Player beats dealer when dealer goes bust", 10, blackjack.play(10, 22));
	}
	
	@Test
	public void test2() {
		assertEquals("Error: Player beats dealer when player is closer to 21", 20, blackjack.play(20, 5));
	}

}
