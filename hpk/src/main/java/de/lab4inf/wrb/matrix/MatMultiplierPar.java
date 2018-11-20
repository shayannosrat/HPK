package de.lab4inf.wrb.matrix;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Paralleler Matrix Multiplier 
 * 
 * @author Pascal Krabbe & Rene Behring
 */
public class MatMultiplierPar{
	/**
	 * Multiplizierer Runnable, um parallel Zellen der Matrix zu berechnen 
	 */
	private class MatMultiplierParCol implements Runnable{
		private Matrix A, B, C;
		private int i, j;
		
		/**
		 * Konstruktor
		 * 
		 * @param _A			Matrix 1
		 * @param _B			Matrix 2
		 * @param _C			Ergebnis
		 * @param _i			Reihe
		 * @param _j			Spalte
		 * @param _iMaxThreads 	Anzahl der Maximal gleichzeitig laufenden MultipierCol Threads
		 */
		public MatMultiplierParCol(Matrix _A, Matrix _B, Matrix _C, int _i, int _j)
		{
			A = _A;
			B = _B;
			C = _C;
			i = _i;
			j = _j;
		}
		
		/**
		 * Ausfuehren der Multiplikation
		 */
		public void run()
		{
			int  cols = A.cols();
			for(int k = 0; k<cols;k++)
			{
				C.add(i, j, A.get(i, k) * B.get(k, j));
			}
		}
	}
	
	/**
	 * Multiplizierer Runnable, welche parallel Spalten Rechner erstellt 
	 */
	private class MatMultiplierParRow implements Runnable{
		private Matrix A, B, C;
		private int i, iMaxThreads;
		
		/**
		 * Konstruktor
		 * 
		 * @param _A			Matrix 1
		 * @param _B			Matrix 2
		 * @param _C			Ergebnis
		 * @param _i			Reihe
		 * @param _iMaxThreads 	Anzahl der Maximal gleichzeitig laufenden MultipierCol Threads
		 */
		public MatMultiplierParRow(Matrix _A, Matrix _B, Matrix _C, int _i, int _iMaxThreads)
		{
			A = _A;
			B = _B;
			C = _C;
			i = _i;
			iMaxThreads = _iMaxThreads;
		}
		
		/**
		 * Ausfuehren der Multiplikation
		 */
		public void run()
		{
			ExecutorService threadPool = Executors.newFixedThreadPool(iMaxThreads);
			Collection<Future<?>> futures = new LinkedList<Future<?>>();
			
			int  cols = B.cols();
	
			for(int j = 0; j<cols;j++)
			{
				MatMultiplierParCol newMulti = new MatMultiplierParCol(A,B,C,i,j);
				futures.add(threadPool.submit(newMulti));
			}
			
			for (Future<?> future:futures) {
			    try {
					future.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	
	/**
	 * Konstruktor zur parallelen Matrix-multiplikation AxB
	 * 
	 * @param A				Matrix 1
	 * @param B				Matrix 2
	 * @param result		Ergebnis der Multiplikation
	 * @param _iMaxThreads	Wie viele Threads die Pools haben sollen
	 * @return				False wenn ein Fehler aufgetreten ist, sonst True
	 */
	public MatMultiplierPar(Matrix A, Matrix B, Matrix result, int _iMaxThreads)
	{
		if(A.rows()!=B.cols() || result.rows()!=A.rows() || result.cols()!=B.cols())
		{
			return;
		}
		
		ExecutorService threadPool = Executors.newFixedThreadPool(_iMaxThreads);
		Collection<Future<?>> futures = new LinkedList<Future<?>>();

		int rows = A.rows();
		
		for(int i = 0; i<rows;i++)
		{
			MatMultiplierParRow newMulti = new MatMultiplierParRow(A,B,result,i,_iMaxThreads);
			futures.add(threadPool.submit(newMulti));
		}
	
		for (Future<?> future:futures) {
		    try {
				future.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}