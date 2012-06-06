import org.junit.Test;

public class PESTTClassTest {
	
	// [0, 1, 2]
	@Test
	public void testDemo_1() {
		PESTTClass tester = new PESTTClass();
		tester.demo(0);
	}
	
	// [0, 1, 3, 4, 5, 6, 7, 1, 3, 9, 5, 6, 7, 1, 3, 4, 5, 6, 7, 1, 3, 9, 5, 8, 7, 1, 2]
	@Test
	public void testDemo_2() {
		PESTTClass tester = new PESTTClass();
		tester.demo(4);
	}
	
	// [0, 1, 3, 4, 5, 6, 7, 1, 3, 9, 5, 6, 7, 1, 3, 4, 5, 8, 7, 1, 2]	
	@Test
	public void testDemo_3() {
		PESTTClass tester = new PESTTClass();
		tester.demo(3);
	}
	
	// [0, 1, 3, 4, 5, 6, 7, 1, 3, 9, 5, 8, 7, 1, 2]
	@Test
	public void testDemo_4() {
		PESTTClass tester = new PESTTClass();
		tester.demo(2);
	}
	
	// [0, 1, 3, 4, 5, 8, 7, 1, 2]
	@Test
	public void testDemo_5() {
		PESTTClass tester = new PESTTClass();
		tester.demo(1);
	}	
}