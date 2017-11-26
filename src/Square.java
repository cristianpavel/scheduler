//package Scheduler;
/**
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class Square extends Process {

	/**
	 * Constructor pentru un proces de tip Square.
	 * Apeleaza constructorul clasei Process.
	 * 
	 * @param name - numele procesului
	 * @param weight - cota lui
	 */
	public Square(String name, int weight) {
		super(name, weight);
		
	}

	@Override
	/**
	 * 
	 * Ruleaza procesul pentru numarul n
	 * 
	 */
	public int run(int n) {
		
		return n * n;
	}
}
