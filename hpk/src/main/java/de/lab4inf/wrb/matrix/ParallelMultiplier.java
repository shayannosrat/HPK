package de.lab4inf.wrb.matrix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelMultiplier {
	
	/**
	 * Parallele Matrizenmultiplikation für die Matrizen A, B
	 * 
	 * @param A
	 * @param B
	 * @return
	 * @throws IllegalArgumentException
	 * @throws RuntimeException
	 */
	public static Matrix multiply(Matrix A, Matrix B) throws IllegalArgumentException, RuntimeException {	
		/*
		 * Fehlerbehandlung
		 */
		
		if(A.getM() == null || B.getM() == null)
			throw new IllegalArgumentException("Matrizen können nicht null sein");
		
		if(A.getCols() != B.getRows())
			throw new IllegalArgumentException("Matrizen sind nicht kompatibel für Matrix-Multiplication");
		
		/*
		 * Setup
		 */
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Matrix res = new Matrix(A.getRows(), B.getCols());
		
		Matrix D = B.transpose();
		
		
		/**
		 * Paralleler Teil
		 */
		
		for(int i = 0; i < A.getRows(); i++) {
			MultiplyThread thread = new MultiplyThread(i, B.getCols(), A, D, res);
			executor.execute(thread);
		}

		/**
		 * Zusammenführen
		 */
		
		executor.shutdown();
		try {
			if(!executor.awaitTermination(180, TimeUnit.SECONDS))
				executor.shutdownNow();
				if (!executor.awaitTermination(60, TimeUnit.SECONDS))
		           System.err.println("Pool did not terminate");
		} catch (InterruptedException ie) {
			executor.shutdownNow();
			Thread.currentThread().interrupt();
	    }
		
		return res;
	}	
	
	private static class MultiplyThread implements Runnable {
		private final int i;
		private final int b_col;
		private final Matrix A;
		private final Matrix D;
		private final Matrix res;
		
		public MultiplyThread(int i, int b_col, Matrix A, Matrix D, Matrix res)  {
			this.i = i;
			this.b_col = b_col;
			this.A = A;
			this.D = D;
			this.res = res;
		}
		
		@Override
		public void run() {
			for(int j = 0; j < b_col; j++) {
				double sum = .0;
				for(int k = 0; k < A.getCols(); k++) {
					sum += A.get(i, k) * D.get(j, k);
				}
				res.set(i, j, sum);
			}
		}
	}
}
