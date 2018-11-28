package de.lab4inf.wrb.matrix;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.stream.LongStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MatrixMultTest {
	protected static final double EPS = 1.E-8;
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testSimpleSerialMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1,2,1,2}, {2,3,2,3}, {3,4,3,4}, {4,5,4,5}};
		
		double[][] res1 = new double[][] {{30,40,30,40}, {40,54,40,54}, {30,40,30,40}, {40,54,40,54}};
		double[][] res2 = new double[][] {{10,16,22,28}, {16,26,36,46}, {22,36,50,64}, {28,46,64,82}};
		
		Matrix A = Matrix.createMatrixFromArray(4,4,a);
		Matrix B =  Matrix.createMatrixFromArray(4,4,b);
		Matrix res =  Matrix.createMatrixFromArray(4,4,res1);
		
		// Test with matrix
		Matrix test = matSeriell.matSeriell(A, B);
		assertTrue(test.equals(res));
		
		res =  Matrix.createMatrixFromArray(4,4,res2);;
		
		// Test with matrix
		test = matSeriell.matSeriell(B, A);
		assertTrue(test.equals(res));
		
		a = new double[][] {{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}};
		b = new double[][] {{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}};
		
		A = Matrix.createMatrixFromArray(6,6,a);
		B = Matrix.createMatrixFromArray(6,6,b);
		
		res = Matrix.createMatrixFromArray(6,6,new double[][] {{21,42,63,84,105,126},{21,42,63,84,105,126},{21,42,63,84,105,126},{21,42,63,84,105,126},{21,42,63,84,105,126},{21,42,63,84,105,126}});
		
		test = matSeriell.matSeriell(A, B);
		
		assertTrue(test.equals(res));
	}
	
		/**
	 * Tests the split function for a quadratic Matrix
	 */
	@Test
	public void testSplitQuadraticMatrix() {
		
		Matrix[][] res = new Matrix[2][2];
		Matrix[][] test = new Matrix[2][2];
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		
		double [][] res1  = new double[][] {{1,2},{2,3}};
		double [][] res2  = new double[][] {{3,4},{4,5}};
		double [][] res3  = new double[][] {{1,2},{2,3}};
		double [][] res4  = new double[][] {{3,4},{4,5}};
		
		Matrix A = Matrix.createMatrixFromArray(4, 4, a);
		
		res[0][0] = Matrix.createMatrixFromArray(2, 2, res1);
		res[0][1] =  Matrix.createMatrixFromArray(2, 2, res2);
		res[1][0] =  Matrix.createMatrixFromArray(2, 2, res3);
		res[1][1] =  Matrix.createMatrixFromArray(2, 2, res4);
		
		
		test = matDivideConquer.split(A);
		
		assertTrue(test[0][0].equals(res[0][0]));
		assertTrue(test[0][1].equals(res[0][1]));
		assertTrue(test[1][0].equals(res[1][0]));
		assertTrue(test[1][1].equals(res[1][1]));
	}
	
	/**
	 * Tests the split function for a 5x4 Matrix
	 */
	@Test
	public void testSplitOddMatrix5x4() {
		
		Matrix[][] res = new Matrix[2][2];
		Matrix[][] test = new Matrix[2][2];
		
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}, {1,2,3,4}};
		
		double [][] res1  = new double[][] {{1,2,3},{2,3,4},{1,2,3}};
		double [][] res2  = new double[][] {{4,0},{5,0},{4,0}};
		double [][] res3  = new double[][] {{2,3,4},{1,2,3}};
		double [][] res4  = new double[][] {{5,0},{4,0}};
		
		Matrix A =  Matrix.createMatrixFromArray(5, 4, a);
		
		res[0][0] = Matrix.createMatrixFromArray(3, 3, res1);
		res[0][1] = Matrix.createMatrixFromArray(3, 2, res2);
		res[1][0] = Matrix.createMatrixFromArray(2, 3, res3);
		res[1][1] = Matrix.createMatrixFromArray(2, 2, res4);
		
		
		test = matDivideConquer.split(A);
		
		/*
		System.out.println("Erwartetes Ergebnis:\n" + res.toString());
		System.out.println("Ergebnis: \n" + test[0][0].toString());
		System.out.println("Ergebnis: \n" + test[0][1].toString());
		System.out.println("Ergebnis: \n" + test[1][0].toString());
		System.out.println("Ergebnis: \n" + test[1][1].toString());
		*/
		
		assertTrue(test[0][0].equals(res[0][0]));
		assertTrue(test[0][1].equals(res[0][1]));
		assertTrue(test[1][0].equals(res[1][0]));
		assertTrue(test[1][1].equals(res[1][1]));
		
	}
	
	
		/**
	 * Tests the merge function for a quadratic Matrix
	 */
	@Test
	public void testMergeQuadraticMatrix() {
		
		Matrix[][] a = new Matrix[2][2];
		Matrix test;
		double[][] resD = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		Matrix res = new Matrix(resD);
		double [][] res1  = new double[][] {{1,2},{2,3}};
		double [][] res2  = new double[][] {{3,4},{4,5}};
		double [][] res3  = new double[][] {{1,2},{2,3}};
		double [][] res4  = new double[][] {{3,4},{4,5}};
		
		a[0][0] = new Matrix(res1);
		a[0][1] = new Matrix(res2);
		a[1][0] = new Matrix(res3);
		a[1][1] = new Matrix(res4);
		
		test = matDivideConquer.merge(a);
		assertTrue(test.equals(res));

	}

	
	@Test
	public void testIdentitySerialMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1,0,0,0}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}};
		
		double[][] res1 = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		
		Matrix A = Matrix.createMatrixFromArray(4, 4, a);
		Matrix B = Matrix.createMatrixFromArray(4, 4, b);
		Matrix res = Matrix.createMatrixFromArray(4, 4, res1);
		
		// Test with matrix
		Matrix test = matSeriell.matSeriell(A, B);
		assertTrue(test.equals(res));
	}
	
	@Test
	public void testZeroSpace() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		
		double[][] res1 = new double[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		
		Matrix A = Matrix.createMatrixFromArray(4, 4, a);
		Matrix B = Matrix.createMatrixFromArray(4, 4, b);
		Matrix res = Matrix.createMatrixFromArray(4, 4, res1);
		
		// Test with matrix
		Matrix test = matSeriell.matSeriell(A, B);
		assertTrue(test.equals(res));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalMatrixSerialMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1}, {2}, {3}};
		
		Matrix A = Matrix.createMatrixFromArray(4, 4, a);
		Matrix B = Matrix.createMatrixFromArray(3, 1, b);
		
		Matrix res = matSeriell.matSeriell(A, B);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMatrixNullMultiplication() {
		double[][] a = new double[][] {{1},{2}};
		double[][] b = null;
		
		Matrix A = Matrix.createMatrixFromArray(2, 1, a);
		Matrix B = Matrix.createMatrixFromArray(0, 0, b);
		
		Matrix res = matSeriell.matSeriell(A, B);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSerialNullMultiplication() {
		double[][] a = new double[][] {{1},{2}};
		double[][] b = null;
		
		Matrix A = Matrix.createMatrixFromArray(2, 1, a);
		Matrix B = Matrix.createMatrixFromArray(0, 0, b);
		
		Matrix res = matSeriell.matSeriell(A, B);
	}
	
	@Test
	public void testSimpleParallelMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1,2,1,2}, {2,3,2,3}, {3,4,3,4}, {4,5,4,5}};
		
		double[][] res1 = new double[][] {{30,40,30,40}, {40,54,40,54}, {30,40,30,40}, {40,54,40,54}};
		double[][] res2 = new double[][] {{10,16,22,28}, {16,26,36,46}, {22,36,50,64}, {28,46,64,82}};
		
		Matrix A = Matrix.createMatrixFromArray(4, 4, a);
		Matrix B = Matrix.createMatrixFromArray(4, 4, b);
		Matrix res = Matrix.createMatrixFromArray(4, 4, res1);
		Matrix test = Matrix.createZeroMatrix(4, 4);
		
		new matParallel(A, B, test, 4);
		
		assertTrue(test.equals(res));
		
		test = Matrix.createZeroMatrix(4, 4);
		res = Matrix.createMatrixFromArray(4, 4, res2);
		
		new matParallel(B, A, test, 4);
		System.out.println(test.toString());
		System.out.println(res.toString());
		assertTrue(test.equals(res));
	}
	
	@Test
	public void testIdentityParallelMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1,0,0,0}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}};
		
		double[][] res1 = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		
		Matrix A = Matrix.createMatrixFromArray(4, 4, a);
		Matrix B = Matrix.createMatrixFromArray(4, 4, b);
		Matrix res = Matrix.createMatrixFromArray(4, 4, res1);
		Matrix test = Matrix.createZeroMatrix(4,4);
		
		new matParallel(A, B, test, 4);
		
		assertTrue(test.equals(res));
	}
	
	@Test
	public void testParallelZeroSpace() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		
		double[][] res1 = new double[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		
		Matrix A = Matrix.createMatrixFromArray(4, 4, a);
		Matrix B = Matrix.createMatrixFromArray(4, 4, b);
		Matrix res = Matrix.createMatrixFromArray(4, 4, res1);
		Matrix test = Matrix.createZeroMatrix(4,4);
		
		new matParallel(A, B, test, 4);
		
		assertTrue(test.equals(res));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalParallelMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1}, {2}, {3}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		
		Matrix res = matParallel.multiply(A, B);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullMultiplication() {
		double[][] a = new double[][] {{1},{2}};
		double[][] b = null;
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		
		Matrix res = matParallel.multiply(A, B);
	}
	
	@Test
	public void testParallelBigMatrix() {
		Random rnd = new Random();
		
		int n = rnd.nextInt(1000);
		
		Matrix a = Matrix.getRandomMatrix(n, n-1, rnd);
		Matrix b = Matrix.getRandomMatrix(n-1, n, rnd);
		
		Matrix res = matSeriell.multiply(a, b);
		Matrix test = matParallel.multiply(a, b);
		Matrix test2 = matDivideConquer.multiply(a, b);
		
		checkDoubleMatrixEqual(test, res);
		checkDoubleMatrixEqual(test2, res);
	}
	
	@Test
	public void testSimpleDnDMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1,2,1,2}, {2,3,2,3}, {3,4,3,4}, {4,5,4,5}};
		
		double[][] res1 = new double[][] {{30,40,30,40}, {40,54,40,54}, {30,40,30,40}, {40,54,40,54}};
		double[][] res2 = new double[][] {{10,16,22,28}, {16,26,36,46}, {22,36,50,64}, {28,46,64,82}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		Matrix res = new Matrix(res1);
		
		Matrix test = matDivideConquer.multiply(A, B);
		
		checkDoubleMatrixEqual(test, res);
		
		res = new Matrix(res2);
		
		test = matDivideConquer.multiply(B, A);
		checkDoubleMatrixEqual(test, res);
		
		a = new double[][] {{1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}};
		b = new double[][] {{1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}};
		res1 = new double[][] {{6,12,18,24,30}, {6,12,18,24,30}, {6,12,18,24,30}, {6,12,18,24,30},{6,12,18,24,30}};
		res2 = new double[][] {{15,30,45}, {15,30,45}, {15,30,45}};
		
		A = new Matrix(a);
		B = new Matrix(b);
		res = new Matrix(res1);
		
		test = matDivideConquer.multiply(A, B);
		checkDoubleMatrixEqual(test, res);
		
		res = new Matrix(res2);
		
		test = matDivideConquer.multiply(B, A);
		checkDoubleMatrixEqual(test, res);
	}
	
	@Test
	public void testMerge() {
		double[][] a = new double[][] {{1}};
		double[][] b = new double[][] {{2}};
		double[][] c = new double[][] {{3}};
		double[][] d = new double[][] {{4}};
		
		Matrix[][] m = new Matrix[][] {{new Matrix(a), new Matrix(b)}, {new Matrix(c), new Matrix(d)}};
		
		Matrix res = new Matrix(new double[][] {{1,2},{3,4}});
		
		Matrix test = matDivideConquer.merge(m);
		
		assertTrue(test.equals(res));
	}
	
	/**
	 * Tests the speedup of the parallel multiplication
	 */
	@Test
	public void testMatrixMultiplicationSpeedup() {
		System.err.println("TIME TEST");
		long serial, parallel, dnd;
		int runs = 100;
		final double SCALED = -1*runs;
		Random rnd = new Random();
		Matrix a, b, resSerial = null, resParallel = null, resDnd = null;
		
		int matrixDimension = 64;
		
		while(matrixDimension <= 2048) {
			long calcTimes[] = new long[runs];
			a = Matrix.getRandomMatrix(matrixDimension + 1, matrixDimension, rnd);
			b = Matrix.getRandomMatrix(matrixDimension, matrixDimension + 1, rnd);
			
			for(int i = 0; i < runs; i++) {
				calcTimes[i] = System.nanoTime();
				resSerial = matSeriell.multiply(a, b);
				calcTimes[i] -= System.nanoTime();
			}
			
			serial = LongStream.of(calcTimes).sum() / runs;
			serial /= SCALED;
			
			for(int i = 0; i < runs; i++) {
				calcTimes[i] = System.nanoTime();
				resParallel = matParallel.multiply(a, b);
				calcTimes[i] -= System.nanoTime();
			}
			
			//assertTrue(resParallel.equals(resSerial));
			checkDoubleMatrixEqual(resParallel, resSerial);
			
			parallel = LongStream.of(calcTimes).sum() / runs;
			parallel /= SCALED;
			
			for(int i = 0; i < runs; i++) {
				calcTimes[i] = System.nanoTime();
				resDnd = matDivideConquer.multiply(a, b);
				calcTimes[i] -= System.nanoTime();
			}
			
			checkDoubleMatrixEqual(resDnd, resSerial);
			
			dnd = LongStream.of(calcTimes).sum() / runs;
			dnd /= SCALED;
			
			double speedupParallel = (double)serial/(double)parallel;
			double speedupDnd = (double)serial/(double)dnd;
			System.err.println(matrixDimension + "x" + (matrixDimension+1) + " Runs: " + runs + "\n--- serial: " + serial + " \n--- parallel: " + parallel + " --- speedup: " + speedupParallel + "\n--- divide and conquer: " + dnd + " --- speedup: " + speedupDnd);
			
			matrixDimension *= 2;
			runs /= 4;
			
			if(runs == 0)
				runs = 1;
		}
	}
	
	/*
	 * Hilfsfunktion um Matrix mit double besser auswerten zu können,
	 * da Rundungsfehler in der double-Arithmetik auftreten können.
	 */
	
	public void checkDoubleMatrixEqual(Matrix A, Matrix B) {
		int n = Math.max(A.getRows(), B.getRows());
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				assertEquals(A.get(i, j), B.get(i, j), EPS);
			}
		}
		
		//assertEquals(4, script.parse(task), EPS);
	}
}

