import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		TestRunner tr = new TestRunner();
		tr.allTests();
	}
	
	public void allTests() {
		Result result = JUnitCore.runClasses(
				Suite1.class,
				Suite2.class);
		System.out.println("All results passes: " + result.wasSuccessful());
		
		if(!result.wasSuccessful()) {
			System.out.println("failed Tests:");
			for(Failure failure: result.getFailures()) {
				System.out.println(failure.getMessage());
			}
		}
	}
}
