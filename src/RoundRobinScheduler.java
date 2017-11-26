//package Scheduler;
/**
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class RoundRobinScheduler extends Scheduler {

	@Override
	/**
	 * 
	 * Intorc procesul rulat de cele mai putine ori.	
	 */
	public Process getProcess() {
	
		int listSize = this.getNrProcs();
		
		int minimRuns = this.getMyProc(0).getNrRuns(), index = 0;
		for (int i = 1; i < listSize; i++) {
			if (this.getMyProc(i).getNrRuns() < minimRuns) {
				minimRuns = this.getMyProc(i).getNrRuns();
				index = i;
			}
			
		}
		return this.getMyProc(index);
	}
	
	

}
