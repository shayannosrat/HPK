package de.lab4inf.wrb.matrix;

import java.awt.Dimension;
import java.util.Random;

/**
 * This class represents a matrix via a 2-dimensional array
 * 
 * @author Till Kobbe
 *
 */
public class Matrix {
	/**
	 * The array with the matrix-values
	 */
	private double[][] m;
	
	/**
	 * Takes an array and creates a matrix with it
	 * 
	 * @param m Array of the matrix
	 * @throws IllegalArgumentException
	 */
	public Matrix(double[][] m) throws IllegalArgumentException{
		if(m == null)
			throw new IllegalArgumentException("Matrix kann nicht null sein");
		this.m = m;
	}
	
	/**
	 * Takes a Dimension and creates a matrix with it
	 * 
	 * @param dim Dimension of the matrix
	 * @throws IllegalArgumentException
	 */
	public Matrix(Dimension dim) throws IllegalArgumentException{
		this.m = new double[dim.width][dim.height];
	}
	
	/**
	 * Takes values for the dimension of matrix and creates a matrix with them
	 * 
	 * @param x 
	 * @param y
	 * @throws IllegalArgumentException
	 */
	public Matrix(int rows, int cols) throws IllegalArgumentException{
		this.m = new double[rows][cols];
	}
	
	/**
	 * Returns the array of the matrix
	 * @return
	 */
	public double[][] getM() {
		return m;
	}
	
	public int getRows() {
		return m.length;
	}
	
	public int getCols() {
		return m[0].length;
	}
	
	/**
	 * Sets the array of the matrix
	 * @param m
	 */
	public void setM(double[][] m) {
		this.m = m;
	}
	
	/**
	 * Returns the Dimension of the matrix
	 * @return
	 */
	public Dimension getDim() {
		return new Dimension(m.length, m[0].length);
	}
	
	/**
	 * Returns the value M(x,y)
	 * 
	 * @param rows
	 * @param cols
	 * @return
	 */
	public double get(int rows, int cols) {
		try {
			return this.m[rows][cols];
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
		
	}
	
	/**
	 * Sets the value M(x,y) = v
	 * 
	 * @param row
	 * @param col
	 * @param v
	 */
	public void set(int row, int col, double v) {
		this.m[row][col] = v;
	}
	
	/**
	 * Transposes the matrix
	 */
	public Matrix transpose() {
        double[][] temp = new double[this.m[0].length][this.m.length];
        for (int row = 0; row < this.m.length; row++)
            for (int col = 0; col < this.m[0].length; col++)
                temp[col][row] = this.m[row][col];
        return new Matrix(temp);
    }
	
	/**
	 * Checks if this matrix is equal to another matrix
	 * @param B
	 * @return
	 */
	public boolean equals(Matrix B) {
		for(int row = 0; row < m.length; row++) {
			for(int col = 0; col < m[0].length; col++) {
				if(this.get(row, col) != B.get(row, col))
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns a matrix with random values in the given size
	 * 
	 * @param rows
	 * @param cols
	 * @param random
	 * @return
	 */
	public static Matrix getRandomMatrix(int rows, int cols, Random random) {
		Matrix m = new Matrix(rows, cols);
		
		for (int x = 0; x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				m.set(x, y, random.nextDouble());
			}
		}
		
		return m;
	}
	
	/**
	 * Converts the matrix to a String
	 */
	@Override
	public String toString() {
		String ret = "";
		for(int i = 0; i < m.length; i++) {
			ret += "| ";
			for(int j = 0; j < m[0].length; j++) {
				ret += m[i][j] + " ";
			}
			ret += " |\n";
		}
		return ret;
	}
}
