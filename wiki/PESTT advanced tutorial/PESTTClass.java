
public class PESTTClass {

	
	
	public void demo (int x) {
		for (int i = 0; i < x; i++) {
			if (i % 2 == 0)
				System.out.println("par  " + i);
			else
				System.out.println("impar " + i);
			if (i < x - 1)
				System.out.println("menor que x - 1");
			else
				System.out.println("vai acabar");
		}
	}
}