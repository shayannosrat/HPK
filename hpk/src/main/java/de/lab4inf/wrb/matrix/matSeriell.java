package de.lab4inf.wrb.matrix;

/**
 * Sequentieller Matrix Multiplier 
 * 
 * @author Pascal Krabbe & Rene Behring
 */
public class matSeriell{
	/**
	 * 
	 * Multipliziert zwei Matrizen und schreibt das Ergebnis in result
	 *  
	 * @param A			Matrix 1
	 * @param B			Matrix 2
	 * 
	 */
	public static Matrix matSeriell(Matrix A, Matrix B) throws IllegalArgumentException
	{
		
		if(A == null || B == null)
			throw new IllegalArgumentException("Matrizen können nicht null sein");
		
		if(A.cols() != B.rows())
			throw new IllegalArgumentException("Matrizen sind nicht kompatibel für Matrix-Multiplication");
		
		
		
		Matrix result = Matrix.createZeroMatrix(A.rows(), B.cols());
		
		/*if(A.rows()!=B.cols() || result.rows()!=A.rows() || result.cols()!=B.cols())
		{
			return;
		}*/

		for(int i=0; i<A.rows(); i++)
		{
			for(int j=0; j< B.cols(); j++)
			{
				for(int k=0; k<A.cols(); k++)
				{
					result.add(i, j, A.get(i,k)*B.get(k,j));
				}
			}
		}
		return result;
	}
}
