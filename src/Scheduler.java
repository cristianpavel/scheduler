//package Scheduler
/**
 * Clasa abstracta pentru scheduler.
 * Pentru a fi instantiata trebuie implementata metoda getProcess.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
abstract public class Scheduler {

	/**
	 * vectorul de procese din care sa selectez
	 */
	private Process[] myProc;
	
	/**
	 * numarul de procese din vectorul myProcs
	 */
	private int nrProcs;
	
	/**
	 * numarul total de selectii de la inceputul programului
	 */
	private int nrSelections;
	
	/**
	 * Constructor ce aloca nr-ul maxim de procese disponibile.
	 */
	public Scheduler() {
		
		myProc = new Process[7];
	}
	
	/**
	 * Metoda ce returneaza un proces din vectorul de procese.
	 * 
	 * @param index - indexul procesului dorit
	 * @return procesul din vectorul de procese
	 */
	public Process getMyProc(int index) {
		return myProc[index];
	}

	/**
	 * 
	 * @return nr de procese
	 */
	public int getNrProcs() {
		return nrProcs;
	}
	
	/**
	 * Adauga un proces in vectorul de procese.
	 * 
	 * @param p - procesul adaugat
	 */
	public void addProcess(Process p) {
		myProc[nrProcs++] = p;
	}
	
	/**
	 * Intoarce nr-ul total de selectii de procese facut.
	 * 
	 * @return nr-ul de selectii
	 */
	public int getNrSelections() {
		return nrSelections;
	}

	/**
	 * Metoda abstracta ce intoarce un proces in functie de scheduler.
	 * 
	 * @return un proces 
	 */
	abstract public Process getProcess();
	
	/**
	 * Metoda ce creste numarul de selectii efectuat si returneaza procesul
	 * selectat de metoda getProcess.
	 * 
	 * @return un proces
	 */
	public Process selectProcess() {
		
		nrSelections++;
		return getProcess();
	}
	
}
