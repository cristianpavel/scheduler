//package Scheduler;

/**
 * Clasa pentru cache. Contine o clasa interna,
 * pentru a retine mai usor elementele introduse in cache.
 * 
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class Cache {
	/**
	 * Clasa privata interna pentru un element din vectorul din cache
	 * Implementeaza Comparable pentru a elimina elemente
	 * in functie de tipul de cache (LruCache, LfuCache). 
	 * Avem nevoie de o ordine intre ele.
	 * 
	 * @author Cristian Pavel - 324 CB
	 * 
	 * 
	 */
	abstract private class CacheElement implements Comparable<CacheElement>{
		/**
		 * procesul retinut in cache
		 */
		private Process proc;
		/**
		 * numarul pe care a fost rulat procesul
		 */
		private int n;
		/**
		 * rezultatul procesului pe acel numar
		 */
		private int result;
		/**
		 * momentul la care a fost adaugat / utilizat elementul din cache
		 */
		private int indexTime;
		/**
		 * de cate ori a fost rulat de la adaugare in cache
		 */
		private int nrUses;
		
		
		/**
		 * Constructorul unui element.
		 * @param proc - procesul adaugat
		 * @param n - nr pe care e rulat procesul
		 * @param result - rezultatul
		 * @param indexTime - momentul relativ in care e adaugat / utilizat
		 */
		public CacheElement(Process proc, int n, int result, int indexTime) {
			
			this.proc = proc;
			this.n = n;
			this.result = result;
			this.indexTime = indexTime;
		}		
		
		/**
		 * 
		 * @return timpul la care a fost adaugat
		 */
		public int getIndexTime() {
			
			return indexTime;
		}
		/**
		 * 
		 * @return nr de utilizari de la adaugare
		 */
		public int getNrUses() {
			
			return nrUses;
		}
		
		@Override
		/**
		 * Trebuie implementata in functie de tipul de Cache
		 */
		abstract public int compareTo(CacheElement a);
	
	}
	
	/**
	 * vectorul cu elemente cache
	 */
	private CacheElement[] cached;
	
	/**
	 * numarul de elemente adaugata in cache
	 */
	private int size;
	
	/**
	 * timpul relativ de la initializarea cache-ului
	 */
	private int time;
	
	/**
	 * tipul de cache - poate fi LruCache sau LfuCache
	 */
	private String typeCache;
	
	/**
	 * 
	 * @param typeCache - tipul de cache
	 * @param cacheCapacity - nr liniilor de cache
	 */
	public Cache(String typeCache, int cacheCapacity) {
		cached = new CacheElement[cacheCapacity];
		this.typeCache = typeCache;
	}

	/**
	 * crestem timpul relativ de la crearea instantei
	 */
	public void incTime() {
		time++;
	}
	
	/**
	 * Metoda de cautare a unui proces in Cache. 
	 * Daca e gasit, se creste numarul utilizarilor,
	 * se modifica timpul la care a fost ultima data accesat, 
	 * si se intoarce rezultatul ca Integer.
	 * 
	 * @param p - procesul
	 * @param n - numarul pe care e rulat procesul
	 * @return rezultatul ca si Integer ( pentru a ne folosi de null ) / null daca nu gaseste
	 */
	public Integer search(Process p, int n) {
		
		for (int i = 0; i < size; i++) {
			
			if (cached[i].proc.toString().equals(p.toString()))
				if (cached[i].n == n) {
					cached[i].nrUses++;
					cached[i].indexTime = time;
					return cached[i].result;
				}
				
		}
		
		return null;
	}
	/**
	 * Metoda de adaugare in cache a unui element. 
	 * In functie de tipul de cache, cream un obiect CacheElement.
	 * In caz ca limita cache-ului a fost atinsa, 
	 * apelam functia de replaceCache, pentru a inlocui un element din cache.
	 * 
	 * @param proc - procesul adaugat
	 * @param n - nr pe care e rulat procesul
	 * @param result - rezultatul procesului
	 */
	public void addCache(Process proc, int n, int result) {
		
		CacheElement toBeCached = null;
		if (typeCache.equals("LruCache")) {
			toBeCached = new CacheElement(proc,n,result,time) {
				
					public int compareTo(CacheElement a) {
						return this.getIndexTime() - a.getIndexTime();
					}
			};
		} else {
			toBeCached = new CacheElement(proc,n,result,time) {
				
				public int compareTo(CacheElement a) {
					return this.getNrUses() - a.getNrUses();
				}
			};
			
			
		}
		
		if (size < cached.length) {
			cached[size] = toBeCached;
			size++;
			return;
		}
		
		replaceCache(toBeCached);
	
	}
	
	/**
	 * Metoda se foloseste de compareTo din CacheElement pentru a gasi elementul
	 * ce trebuie inlocuit.
	 * 
	 * @param toBeCached - elementul cache care trebuie sa fie introdus
	 */
	
	private void replaceCache(CacheElement toBeCached) {
		int position = 0;
		CacheElement minim = cached[0];
		for (int i = 1; i < cached.length; i++) {
			if (minim.compareTo(cached[i]) > 0) {
				minim = cached[i];
				position = i;
			}
		}
		cached[position] = toBeCached;
	}

}
