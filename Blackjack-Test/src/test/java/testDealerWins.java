import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testDealerWins {
	
Blackjack blackjack;
	
	@Before
	public void setUp() {
		blackjack = new Blackjack();
	}
	
	@Test
	public void test1() {
		assertEquals("Error: Dealer wins when both parties go bust", 0, blackjack.play(22, 22));
	}
	
	@Test
	public void test2() {
		assertEquals("Error: Dealer wins when player goes bust", 10, blackjack.play(22, 10));
	}
	
	@Test
	public void test3() {
		assertEquals("Error: Dealer wins when dealer is closer to 21", 20, blackjack.play(5, 20));
	}

}
