//package Scheduler;
/**
 * Clasa abstracta pentru un proces.
 * Pentru a fi instantiata trebuie implementata metoda run.
 *  
 * @author Cristian Pavel - 324 CB
 *
 */
abstract public class Process {
	/**
	 * numele procesului
	 */
	private String name;
	
	/**
	 * numarul de rulari / utilizari
	 */
	private int nrRuns;
	
	/**
	 * cota procesului
	 */
	private int weight;
	
	/**
	 * Constructor pentru un obiect care extinde clasa.
	 * 
	 * @param name - numele procesului
	 * @param weight - cota
	 */
	public Process(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	/**
	 * 
	 * @return cota procesului
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * 
	 * @return nr-ul de rulari
	 */
	public int getNrRuns() {
		return nrRuns;
	}

	/**
	 * Metoda abstracta ce trebuie implementata, 
	 * in functie de tipul procesului.
	 * 
	 * @param n - nr-ul ce trebuie procesat
	 * @return rezultatul
	 */
	abstract public int run(int n); 
	
	/**
	 * Creste numarul de rulari
	 */
	public void addNrRuns() {
		nrRuns++;	
	}
	
	@Override
	public String toString() {
		
		return name;
	}
	

}
