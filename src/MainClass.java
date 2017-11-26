//package Scheduler;
//import InputOutput.*;
/**
 * Clasa Main a programului.
 * 
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class MainClass {

	
	public static void main(String[] args) {
		
		//citesc datele si inchid fisierul
		HomeworkReader r = new HomeworkReader(args[0]);
		ProblemData data = r.readData();
		r.close();
		
		
		Scheduler s = null;
		Cache cache = null;
		
		// instantiez scheduler-ul
		switch(data.getSchedulerType()) {
		case "RandomScheduler":
			s = new RandomScheduler();
			break;
		case "RoundRobinScheduler":
			s = new RoundRobinScheduler();
			break;
		case "WeightedScheduler":
			s = new WeightedScheduler();
			
		}
		
		// vad daca am sau nu cache si instantiez
		if (!data.getCacheType().equals("NoCache"))
			cache = new Cache(data.getCacheType(),data.getCacheCapacity());
	
		// instantiez procesele si le adaug in vectorul din scheduler
		for (int i = 0; i < data.getProcesses().length; i++) {
			Process p = null;
			int weight = data.getProcesses()[i].getWeight();
			
			switch(data.getProcesses()[i].getType()) {
			case "CheckPrime":
				p = new CheckPrime("CheckPrime", weight);
				break;
			case "Cube":
				p = new Cube("Cube", weight);
				break;
			case "Factorial":
				p = new Factorial("Factorial", weight);
				break;
			case "Fibonacci":
				p = new Fibonacci("Fibonacci", weight);
				break;
			case "Square":
				p = new Square("Square", weight);
				break;
			case "Sqrt":
				p = new Sqrt("Sqrt", weight);
				break;
			case "NextPrime":
				p = new NextPrime("NextPrime", weight);
			
				
				
			}
			
			s.addProcess(p);
			
			
		}
		
		//deschid fisier iesire
		HomeworkWriter hw = new HomeworkWriter(args[1]);
		for (int i = 0; i < data.getNumbersToBeProcessed().length; i++) {
			
			// iau numarul ce trebuie procesat
			int n = data.getNumbersToBeProcessed()[i];
			
			// selectez procesul
			Process t = s.selectProcess();
			
			t.addNrRuns();	//cresc nr de rulari
			
			Integer result = null; 
			
			if (cache != null) {
		
				cache.incTime(); //cresc timpul relativ din cache
				result = cache.search(t,n); //caut evenimentul in cache
			
				if (result != null) { //daca l-am gasit
					hw.println(n + " " + t.toString() + " " + result + " FromCache");
					continue;
				}

			
			}	
		
			// nu a fost in cache, deci il rulez
			result = t.run(n);
			
			if (cache != null)
				cache.addCache(t, n, result); //adaug la cache
			
			hw.println(n + " " + t.toString() + " " + result + " Computed");
				
		}
		hw.close();
		
	}
	
}

