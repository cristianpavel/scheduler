//package Scheduler;
/**
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class Sqrt extends Process {
	
	/**
	 * Constructor pentru un proces de tip NextPrime.
	 * Apeleaza constructorul clasei Process.
	 * 
	 * @param name - numele procesului
	 * @param weight - cota lui
	 */
	public Sqrt(String name, int weight) {
		super(name, weight);
	
	}

	@Override
	/**
	 * 
	 * Ruleaza procesul pentru numarul n
	 * 
	 */
	public int run(int n) {
		
		return (int)Math.floor(Math.sqrt(Math.abs(n)));
	}

}
