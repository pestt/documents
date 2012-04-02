package domain;

public class ControlStructures {
	
	private int x;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ControlStructures().singleBlock();
	}
		
	public void singleBlock () {
		int m1 = 2;
		System.out.println(m1);
	}
	
	public void ifThen () {
		if (x == 0) // note the label on the edge
			x = 2;
	}
	
	public void ifThenWithInitialNode () {
		int x = 0;
		if (x == 3)
			x = 2;
	}
	
	public void ifThenWithInitialAndFinalNode () {
		int x = 0;
		if (x == 0)
			x = 2;
		System.out.println(x);
	}
	
	public void ifThenElse () {
		if (x == 0)
			x = 1;
		else 		// note the predicate negation on the edge
			x = 2;
	}
	
	public void nestedIfThenElse () {
		if (x == 0) {
			int y = 2;
			if (y % 2 == 0)
				System.out.println("par");
			else 
				System.out.println("impar");
		}
	}
	
	public void nestedIfThenElseInBothBranches () {
		if (x == 0) {
			int y = 2;
			if (y % 2 == 0)
				System.out.println("par");
			else 
				System.out.println("impar");
		} else
			if (x > 2)
				System.out.println("aa");
			else 
				System.out.println("bb");
	}
	
	public void switchG () {  
		switch (x) {
		case 1: 
			System.out.println(x);
			break;
		case 2:
			System.out.println(x + 1);
			break;
		case 3:
			System.out.println("xx");
		}
	}
	
	public void switchSemBreak () {
		switch (x) {
		case 1: 
			System.out.println(x);
		case 2:
			System.out.println(x + 1);
			break;
		}		
	}
	
	public void switchSemBreak1 () {  
		switch (x) {
		case 1: 
			System.out.println(x);
		case 2:
			System.out.println(x + 1);
			break;
		case 3: 
			System.out.println("xx");
		}		
	}

	public void switchComDefault () {  
		switch (x) {
		case 1: 
			System.out.println(x);
		case 2:
			System.out.println(x + 1);
		default: 
			System.out.println("xx");
		}		
	}
	
	public void switchComDefault1 () {  
		switch (x) {
		default: 
			System.out.println("xx");
		case 1: 
			System.out.println(x);
		case 2:
			System.out.println(x + 1);
		}		
	}

	
	public void whileG () {
		while (x < 10)   // There are two edges: one from the loop node to its body
			             // another in the opposite direction
			x++;
	}
	
	public void whileWithInitialAndFinalNode () {
		int x = 0;
		while (x < 10) {
			x++;
		}
		System.out.println(x);
	}

	public void whileWithBlockInitialAndFinalNode () {
		int x = 0;
		while (x < 10) {
			x++;
			System.out.println(x);
		}
		System.out.println(x);
	}
	
	public void whileWithNestedIf () {
		while (x < 10) {
			if (x < 5)
				x++;
			x = x + 3;
		}
		System.out.println(x);
	}

	// same as an if? ;)
	public void whileWithBreak () {
		while (x < 10) {
			x = x + 3;
			break; // note the label on the edge
		}
		System.out.println(x);
	}

	public void whileWithNestedIfAndBreak () {
		int x = 0;
		while (x < 10) {
			if (x < 5) {
				x++;
				break;
			}
			x = x + 3;
		}
		System.out.println(x);
	}
	
	public void whileWithNestedIfAndContinue () {
		while (x < 10) {
			if (x < 5) {
				x++;
				continue;  
			}
			x = x + 3;
		}
		System.out.println(x);
	}

	public void nestedWhiles () {
		while (x < 10) {
			int y = 0;
			while (y < x)
				y++;
			x++;
		}
	}


	// sometimes we need to adjust the CFG to 
	// see it better :(
	public void nestedWhilesBreakInner () {
		while (x < 10) {
			int y = 1;
			while (y < x) {
				if (x %  y == 0)
					break;        
				y++;
			}
			System.out.println(y);
			x++;
		}
	}
	
	public void nestedWhilesBreakInnerNoNextNode () {
		while (x < 10) {
			int y = 1;
			while (y < x) {
				if (x %  y == 0)
					// Since there are no instructions after the loop, the control 
					// flow goes directly to the outermost loop
					break;        
				y++;

			}
		}
	}


	public void nestedWhilesBreakOuterNoNextNode () {
		while (x < 10) {
			int y = 1;
			while (y < x) 
				y++;
			if (y == 3)
				break;
			System.out.println("aaa");
		}
	}

	
	public void nestedWhilesContinueInner () {
		while (x < 10) {
			int y = 1;
			while (y < x) {
				if (x %  y == 0)
					continue;        // note the "continue" on the edge
				y++;
			}
			System.out.println(y);
			x++;
		}
	}
	
	public void nestedWhilesContinueOuter () {
		while (x < 10) {
			int y = 1;
			while (y < x) 
				y++;
			if (x % 3 == 0) {
				x += 2;
				continue;
			}
			x++;
		}
	}
	
	public void sequencialWhiles() {
		int x = 0;
		while (x < 10) {
			if (x % 3 == 0) 
				x += 2;
			x++;
		}
		while (x < 20) {
			if (x % 3 == 0) 
				x += 2;
			x++;			
		}
	}
	
	public void sequencialWhilesWithNesting() {
		int x = 0;
		while (x < 10) {
			int y = 1;
			while (y < x) 
				y++;
			if (x % 3 == 0) 
				x += 2;
			x++;
		}
		while (x < 20) {
			while (x % 3 == 0) 
				x += 2;
			x++;			
		}
	}

	
	public void forG () {
		for (int i = 0; i < 10; i++)  
			System.out.println(i);
	}

	public void forWithBlockBeforeInsideAndAfter () {
		int j = 0;
		for (int i = 0; i < 10; i++)  {
			System.out.println(i);
			j++;
		}
		System.out.println(j);
	}

	public void forWithMultipleInicializationsAndProgresses () {
		for (int i = 0, j = 10; i < 10; i++, j--)  
			System.out.println(i + j);  
		System.out.println("j");
	}

	// breaks and continues are a bit ugly, but they exist and we need 
	// to support them :(
	public void forWithBreak () {
		for (int i = 0, j = 10; i < 10; i++, j--)  {
			System.out.println(i + j); 
			if (j == 5)
				break;
			System.out.println("after break");
		}
		System.out.println("j");		
	}

	public void forWithContinue () {
		for (int i = 0, j = 10; i < 10; i++, j--)  {
			System.out.println(i + j); 
			if (j == 5)
				continue;
			System.out.println("after break");
		}
		System.out.println("j");		
	}

	public void forWithContinueNoNodeAfter () {
		for (int i = 0, j = 10; i < 10; i++, j--)  {
			System.out.println(i + j); 
			if (j == 5)
				continue;
		}
		System.out.println("j");		
	}

	
	public void nextedFors () {
		int soma = 0;
		for (int i = 0; i < 10; i++)   
			for (int j = 0; j < 10; j++)  
				soma = i + j;
		System.out.println(soma);		
	}

	
	public void nextedForsBreakInner () {
		int soma = 0;
		for (int i = 0; i < 10; i++)   
			for (int j = 0; j < 10; j++) { 
				soma = i + j;
				if (i % (j + 2) == 0)
					break;
			}
		System.out.println(soma);		
	}

	public void nextedForsBreakOuter () {
		int soma = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) 
				soma = i + j;
			if (i % 5 == 0)
				break;
		}
		System.out.println(soma);		
	}

	public void nextedForsBreakOuter1 () {
		int soma = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) 
				soma = i + j;
			if (i % 5 == 0)
				break;
			else 
				i = 6;
		}
		System.out.println(soma);		
	}

	public void forEach() {
		int [] elems = new int [10];
		for (int i = 0; i < elems.length; i++)
			elems [i] = i + 1;
		int soma = 0;
		for (int e : elems)  // note the hasNext on the edge ;)
			soma += e;
		System.out.println(soma);		
	}
	
	public void forEachBreak () {
		int [] elems = new int [10];
		int soma = 0;
		for (int e : elems) { 
			soma += e;
			if (soma > 10)
				break;
		}
		System.out.println(soma);		
	}

	public void forEachContinue () {
		int [] elems = new int [10];
		int soma = 0;
		for (int e : elems) { 
			if (soma > 10)
				continue;
			soma += e;
		}
		System.out.println(soma);		
	}

	public void doWhile() {
		do {					
			System.out.println(x);
			x++;
		} while (x < 10);
	}

	public void doWhileWithBlockBefore() {
		int x = 0;
		do {					
			System.out.println(x);
			x++;
		} while (x < 10);  
	}
	
	public void doWhileBreak() {
		do {					
			System.out.println(x);
			if (x % 3 == 0)
				break;
			x++;
		} while (x < 10);
	}

	public void doWhileContinue() {
		do {					
			System.out.println(x);
			if (x % 3 == 0)
				continue;
			x++;
		} while (x < 10);
	}

}
