//package Scheduler;
/**
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class CheckPrime extends Process{

	/**
	 * Constructor pentru un proces de tip CheckPrime.
	 * Apeleaza constructorul clasei Process.
	 * 
	 * @param name - numele procesului
	 * @param weight - cota lui
	 */
	public CheckPrime(String name, int weight) {
		
		super(name, weight);
	
	}
	
	
	@Override
	/**
	 * Ruleaza procesul pentru numarul n
	 * 
	 */
	public int run(int n) {
		
		if (n <= 1)
			return 0;
		
		for (int d = 2; d <= Math.sqrt(n); d++)
			if (n % d == 0)
				return 0;
		
		return 1;
	}

	
	
	
}
