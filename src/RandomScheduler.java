//package Scheduler;
import java.util.Random;
/**
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class RandomScheduler extends Scheduler {

	
	@Override
	/**
	 * 
	 * Selecteaza random un proces din vectorul de procese.
	 */
	public Process getProcess() {
	
		int listSize = this.getNrProcs();
		
		Random r = new Random();
		
		int index = r.nextInt(listSize);
		
		return this.getMyProc(index);
	}
	
}
