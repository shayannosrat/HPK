package de.lab4inf.wrb.matrix;

/**
 * Matrix-klasse
 * 
 * Enthaelt alle wichtigen Befehle fuer die Aufgabe
 * 
 * @author Pascal Krabbe & Rene Behring
 */
public class Matrix {
	private int rows, cols;
	private double mat[][];
	
	/**
	 * Private Konstruktor, damit eine Matrix nur ueber die statischen public Funktionen
	 * erstellt werden kann 
	 * 
	 * @param rows	Reihen
	 * @param cols	Spalten
	 */
	private Matrix(int rows, int cols)
	{
		this.mat = new double[rows][cols];
		this.rows = rows;
		this.cols = cols;
	}
	

	/**
	 * Erzeugen einer neuen Matrix mit Zufallswerten 
	 * 
	 * @param rows	Reihen
	 * @param cols	Spalten
	 * @return		Ein Matrix objekt mit zufaelligen Werten
	 */
	public static Matrix createRandomMatrix(int rows, int cols)
	{
		Matrix M = new Matrix(rows, cols);
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				M.mat[i][j] = Math.random()*100;
			}
		}
		
		return M;
	}

	/**
	 * Erzeugen einer neuen quadratischen Matrix mit Zufallswerten 
	 * 
	 * @param n		Dimension der Matrix
	 * @return		Ein Matrix objekt mit zufaelligen Werten
	 */
	public static Matrix createRandomMatrix(int n)
	{
		return createRandomMatrix(n,n);
	}

	/**
	 * Erzeugen einer neuen Matrix in der alle Werte 0 sind 
	 * 
	 * @param rows	Reihen
	 * @param cols	Spalten
	 * @return		Eine "leere" Matrix
	 */
	public static Matrix createZeroMatrix(int rows, int cols)
	{
		Matrix M = new Matrix(rows, cols);
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				M.mat[i][j] = 0;
			}
		}
		
		return M;
	}
	
	/**
	 * Erzeugen einer neuen quadratischen Matrix in der alle Werte 0 sind 
	 * 
	 * @param n		Dimension der Matrix
	 * @return		Eine "leere" Matrix
	 */
	public static Matrix createZeroMatrix(int n)
	{
		return createZeroMatrix(n,n);
	}

	/**
	 * Erzeugen einer neuen Matrix durch Werte aus einem zweidimensionalen Array 
	 * 
	 * @param rows	Reihen
	 * @param cols	Spalten
	 * @param mat	Werte der Matrix
	 * @return		Eine Matrix gefuellt mit den Werten aus dem Array
	 */
	public static Matrix createMatrixFromArray(int rows, int cols, double mat[][])
	{
		Matrix M = new Matrix(rows, cols);
		
		try //Fuer den Fall, dass die angegebenen Array angaben falsch sind und eine OutOfBounds Exception geworfen wird  
		{
			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					M.mat[i][j] = mat[i][j];
				}
			}
			
		}
		catch(Exception e)
		{
			M = null;
		}
		
		return M;
	}

	/**
	 * Erzeugen einer neuen quadratischen Matrix durch Werte aus einem zweidimensionalen Array 
	 * 
	 * @param n		Dimension der Matrix
	 * @param mat	Werte der Matrix
	 * @return		Eine Matrix gefuellt mit den Werten aus dem Array
	 */
	public static Matrix createMatrixFromArray(int n, double mat[][])
	{
		return createMatrixFromArray(n,n,mat);
	}

	
	/**
	 * Die Anzahl der Zeilen wird zurŸck gegeben
	 * @return	Anzahl der Zeilen
	 */
	public int rows()
	{
		return rows;
	}

	/**
	 * Die Anzahl der Spalten wird zurŸck gegeben
	 * @return	Anzahl der Spalten
	 */
	public int cols()
	{
		return cols;
	}


	/**
	 * Funktion fuer die Rueckgabe des Zelleninhalts
	 * 
	 * @param row	zu pruefende Zeile
	 * @param col	zu pruefende Spalte
	 * @return		der Inhalt der Zelle, bei Fehlern 0
	 */
	public double get(int row, int col)
	{
		if(row>=0 && row<rows && col>=0 && col<cols)
		{
			return mat[row][col];
		}
		
		return 0;
	}

	/**
	 * Der Zelleninhalt wird auf die entsprechende Variable gesetzt
	 * 
	 * @param row	zu setzende Zeile
	 * @param col	zu setzende Spalte
	 * @param val	Wert der in die Zelle geschrieben wird
	 */
	public void set(int row, int col, double val)
	{
		if(row>=0 && row<rows && col>=0 && col<cols)
		{
			mat[row][col] = val;
		}
	}

	public void add(int row, int col, double val)
	{
		if(row>=0 && row<rows && col>=0 && col<cols)
		{
			mat[row][col] += val;
		}
	}
	
	/**
	 * Vergleichen ob die Matrix die gleichen Werte wie eine andere hat
	 * 
	 * @param obj 	Objekt(Matrix) die mit der aufrufenden Matrix zu vergleichen ist
	 * @return		True wenn alles gleich ist, sonst false
	 */
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Matrix))
		{
			return false;
		}
		
		Matrix other = (Matrix)obj;

		if(rows!=other.rows() || cols!=other.cols())
		{
			return false;
		}
		
		for(int i=0;i<rows();i++)
		{
			for(int j=0;j<cols();j++)
			{
				if(get(i,j)!=other.get(i, j))
				{
					return false;
				}
			}			
		}
		
		return true;
	}
	
	/**
	 * Ueberladen der toString Methode fuer einfachen Output
	 * 
	 * @return	String reprasentation der Matrix
	 */
	public String toString() {
		String temp = String.format("Matrix %dx%d", rows, cols);
		
		temp +="\n";
		
		for(int i=0;i<rows();i++)
		{
			for(int j=0;j<cols();j++)
			{
				temp +=" "+get(i,j);
			}			
			temp +="\n";
		}
		
		return temp;
	}
}
