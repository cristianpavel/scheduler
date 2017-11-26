//package Scheduler;
/**
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class NextPrime extends Process {

	/**
	 * Constructor pentru un proces de tip NextPrime.
	 * Apeleaza constructorul clasei Process.
	 * 
	 * @param name - numele procesului
	 * @param weight - cota lui
	 */
	public NextPrime(String name, int weight) {
		super(name, weight);
	}

	@Override
	/**
	 * Ruleaza procesul pentru numarul n
	 * 
	 */
	public int run(int n) {
		
		
		CheckPrime c = new CheckPrime("CheckPrime", 0);
		for (int i = n + 1; ;i++) {
			if (c.run(i) == 1)
				return i;
		}
	}
	
	
}
