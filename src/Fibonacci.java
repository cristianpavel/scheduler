//package Scheduler;
/**
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class Fibonacci extends Process {
	
	/**
	 * Constructor pentru un proces de tip Fibonacci.
	 * Apeleaza constructorul clasei Process.
	 * 
	 * @param name - numele procesului
	 * @param weight - cota lui
	 */
	public Fibonacci(String name, int weight) {
		super(name, weight);
		
	}

	@Override
	/**
	 * Ruleaza procesul pentru numarul n
	 * 
	 */
	public int run(int n) {
		
		
		if (n < 0)
			return -1;
		int a = 0, b = 1, c = 0;
		
		while (n > 0) {
			c = (a  + b) % 9973;
			a = b;
			b = c;
			n--;
		}
		return a;
		
	}


}
