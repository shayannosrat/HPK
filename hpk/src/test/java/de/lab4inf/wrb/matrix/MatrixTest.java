package de.lab4inf.wrb.matrix;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.stream.LongStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MatrixTest {
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
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		Matrix res = new Matrix(res1);
		
		// Test with matrix
		Matrix test = SerialMultiplier.multiply(A, B);
		assertTrue(test.equals(res));
		
		res = new Matrix(res2);
		
		// Test with matrix
		test = SerialMultiplier.multiply(B, A);
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
		
		Matrix A = new Matrix(a);
		
		res[0][0] = new Matrix(res1);
		res[0][1] = new Matrix(res2);
		res[1][0] = new Matrix(res3);
		res[1][1] = new Matrix(res4);
		
		
		test = DivideNConquerMultiplier.split(A);
		
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
		
		Matrix A = new Matrix(a);
		
		res[0][0] = new Matrix(res1);
		res[0][1] = new Matrix(res2);
		res[1][0] = new Matrix(res3);
		res[1][1] = new Matrix(res4);
		
		
		test = DivideNConquerMultiplier.split(A);
		
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
	 * Tests the split function for a 4x5 Matrix
	 */
	@Test
	public void testSplitOddMatrix4x5() {
		
		Matrix[][] res = new Matrix[2][2];
		Matrix[][] test = new Matrix[2][2];
		
		double[][] a = new double[][] {{1,2,3,4,5}, {2,3,4,5,6}, {1,2,3,4,5}, {2,3,4,5,6}};
		
		double [][] res1  = new double[][] {{1,2,3},{2,3,4},{1,2,3}};
		double [][] res2  = new double[][] {{4,5},{5,6},{4,5}};
		double [][] res3  = new double[][] {{2,3,4},{0,0,0}};
		double [][] res4  = new double[][] {{5,6},{0,0}};
		
		Matrix A = new Matrix(a);
		
		res[0][0] = new Matrix(res1);
		res[0][1] = new Matrix(res2);
		res[1][0] = new Matrix(res3);
		res[1][1] = new Matrix(res4);
		
		
		test = DivideNConquerMultiplier.split(A);
		
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
		
		test = DivideNConquerMultiplier.merge(a);
		
		System.out.println("Erwartetes Ergebnis:\n" + res.toString());
		System.out.println("Ergebnis:\n" + test.toString());

		assertTrue(test.equals(res));

	}

	
	@Test
	public void testIdentitySerialMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1,0,0,0}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}};
		
		double[][] res1 = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		Matrix res = new Matrix(res1);
		
		// Test with matrix
		Matrix test = SerialMultiplier.multiply(A, B);
		assertTrue(test.equals(res));
	}
	
	@Test
	public void testZeroSpace() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		
		double[][] res1 = new double[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		Matrix res = new Matrix(res1);
		
		// Test with matrix
		Matrix test = SerialMultiplier.multiply(A, B);
		assertTrue(test.equals(res));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalMatrixSerialMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1}, {2}, {3}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		
		Matrix res = SerialMultiplier.multiply(A, B);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMatrixNullMultiplication() {
		double[][] a = new double[][] {{1},{2}};
		double[][] b = null;
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		
		Matrix res = SerialMultiplier.multiply(A, B);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSerialNullMultiplication() {
		double[][] a = new double[][] {{1},{2}};
		double[][] b = null;
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		
		Matrix res = SerialMultiplier.multiply(A, B);
	}
	
	@Test
	public void testSimpleParallelMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1,2,1,2}, {2,3,2,3}, {3,4,3,4}, {4,5,4,5}};
		
		double[][] res1 = new double[][] {{30,40,30,40}, {40,54,40,54}, {30,40,30,40}, {40,54,40,54}};
		double[][] res2 = new double[][] {{10,16,22,28}, {16,26,36,46}, {22,36,50,64}, {28,46,64,82}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		Matrix res = new Matrix(res1);
		
		Matrix test = ParallelMultiplier.multiply(A, B);
		
		assertTrue(test.equals(res));
		
		res = new Matrix(res2);
		
		test = ParallelMultiplier.multiply(B, A);
		
		assertTrue(test.equals(res));
	}
	
	@Test
	public void testIdentityParallelMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1,0,0,0}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}};
		
		double[][] res1 = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		Matrix res = new Matrix(res1);
		
		Matrix test = ParallelMultiplier.multiply(A, B);
		
		assertTrue(test.equals(res));
	}
	
	@Test
	public void testParallelZeroSpace() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		
		double[][] res1 = new double[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		Matrix res = new Matrix(res1);
		
		Matrix test = ParallelMultiplier.multiply(A, B);
		
		assertTrue(test.equals(res));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalParallelMultiplication() {
		double[][] a = new double[][] {{1,2,3,4}, {2,3,4,5}, {1,2,3,4}, {2,3,4,5}};
		double[][] b = new double[][] {{1}, {2}, {3}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		
		Matrix res = ParallelMultiplier.multiply(A, B);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullMultiplication() {
		double[][] a = new double[][] {{1},{2}};
		double[][] b = null;
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		
		Matrix res = ParallelMultiplier.multiply(A, B);
	}
	
	@Test
	public void testParallelBigMatrix() {
		Random rnd = new Random();
		
		int n = rnd.nextInt(1000);
		
		Matrix a = Matrix.getRandomMatrix(n, n-1, rnd);
		Matrix b = Matrix.getRandomMatrix(n-1, n, rnd);
		
		Matrix res = SerialMultiplier.multiply(a, b);
		Matrix test = ParallelMultiplier.multiply(a, b);
		Matrix test2 = DivideNConquerMultiplier.multiply(a, b);
		
		assertTrue(test.equals(res));
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
		
		Matrix test = DivideNConquerMultiplier.multiply(A, B);
		
		System.out.println("Erwartetes Ergebnis:\n" + res.toString());
		System.out.println("Ergebnis: \n" + test.toString());
		assertTrue(test.equals(res));
		
		res = new Matrix(res2);
		
		test = DivideNConquerMultiplier.multiply(B, A);
		System.out.println("Erwartetes Ergebnis:\n" + res.toString());
		System.out.println("Ergebnis: \n" + test.toString());
		assertTrue(test.equals(res));
	}
	
	/**
	 * Tests the speedup of the parallel multiplication
	 */
	@Test
	@Ignore
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
				resSerial = SerialMultiplier.multiply(a, b);
				calcTimes[i] -= System.nanoTime();
			}
			
			serial = LongStream.of(calcTimes).sum() / runs;
			serial /= SCALED;
			
			for(int i = 0; i < runs; i++) {
				calcTimes[i] = System.nanoTime();
				resParallel = ParallelMultiplier.multiply(a, b);
				calcTimes[i] -= System.nanoTime();
			}
			
			assertTrue(resParallel.equals(resSerial));
			
			parallel = LongStream.of(calcTimes).sum() / runs;
			parallel /= SCALED;
			
			for(int i = 0; i < runs; i++) {
				calcTimes[i] = System.nanoTime();
				resDnd = DivideNConquerMultiplier.multiply(a, b);
				calcTimes[i] -= System.nanoTime();
			}
			
			assertTrue(resDnd.equals(resSerial));
			
			dnd = LongStream.of(calcTimes).sum() / runs;
			dnd /= SCALED;
			
			double speedupParallel = (double)serial/parallel;
			double speedupDnd = (double)serial/dnd;
			System.err.println(matrixDimension + "x" + (matrixDimension+1) + " Runs: " + runs + "\n--- serial: " + serial + " \n--- parallel: " + parallel + " --- speedup: " + speedupParallel + "\n--- divide and conquer: " + dnd + " --- speedup: " + speedupDnd);
			
			matrixDimension *= 2;
			runs /= 4;
			
			if(runs == 0)
				runs = 1;
		}
	}
}

