//package Scheduler;
/**
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class WeightedScheduler extends Scheduler {

	private int checkPeriod;
	private int sumWeights;
	
	/**
	 * Metoda ce face cmmdc a doua numere a si b
	 * 
	 * @param a
	 * @param b
	 * @return cmmdc(a,b)
	 */
	private int commonDivisor(int a, int b) {
		
		if (a == 0) return b;
		
		if (b == 0) return a;
		
		return commonDivisor(b, a % b);
	}
	/**
	 * Calculez t-ul definit in cerinta
	 * t = sumWeights / cmmdc
	 * 
	 * La mine checkPeriod == t
	 */
	private void calculateCheckPeriod() {
		
		int cmmdc = 0;
		for (int i = 0; i < this.getNrProcs(); i++) {
			int weight = this.getMyProc(i).getWeight();
			sumWeights += weight;
		
			cmmdc = this.commonDivisor(cmmdc,weight);
			
		}
		checkPeriod = sumWeights / cmmdc;

	
	}
	
	@Override
	/**
	 * Selectez un proces din vector. Ma asigur ca la momente
	 * de timp multiple de t sa respect cotele proceselor.
	 * 
	 * 
	 * multiple * weight / sumWeigths ma asigura ca o sa rulez
	 * procesele in ordine, pana ajung la cota lor
	 * 
	 * 
	 * 
	 */
	public Process getProcess() {
		
		// daca apelez prima data metoda
		if (checkPeriod == 0)
			calculateCheckPeriod();
		
		// iau numarul de selectii de pana acum
		int selections = this.getNrSelections();
			
		// calculez multiplul lui t (checkPeriod)
		int multiple = ((selections - 1) / checkPeriod + 1) * checkPeriod;
		
		
		for (int i = 0; i < this.getNrProcs(); i++) {
			int weight = this.getMyProc(i).getWeight();
			if (multiple * weight / sumWeights > this.getMyProc(i).getNrRuns())
				return this.getMyProc(i);
		}
		
		return null;
	
	}
	
	

}
