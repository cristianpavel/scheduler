//package Scheduler;
/**
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class Factorial extends Process {
	
	/**
	 * Constructor pentru un proces de tip Factotial.
	 * Apeleaza constructorul clasei Process.
	 * 
	 * @param name - numele procesului
	 * @param weight - cota lui
	 */
	public Factorial(String name, int weight) {
		super(name, weight);
	}

	@Override
	/**
	 * Ruleaza procesul pentru numarul n
	 * 
	 */
	public int run(int n) {
		
		if (n < 0)
			return 0;
		
		int factorial = 1;
		if (n > 9973)
			return 0;
		
		while (n > 0) {
			factorial *= n;
			n--;
			factorial %= 9973;
		}
		
		return factorial;
	}

}
