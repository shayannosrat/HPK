package de.lab4inf.wrb.matrix;

/**
 * Sequentieller Matrix Multiplier 
 * 
 * @author Pascal Krabbe & Rene Behring
 */
public class MatMultiplierSeq{
	/**
	 * Konstruktor
	 * Multipliziert zwei Matrizen und schreibt das Ergebnis in result
	 *  
	 * @param A			Matrix 1
	 * @param B			Matrix 2
	 * @param result	Ergebnis der Multiplikation
	 */
	public MatMultiplierSeq(Matrix A, Matrix B, Matrix result)
	{
		if(A.rows()!=B.cols() || result.rows()!=A.rows() || result.cols()!=B.cols())
		{
			return;
		}

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
	}
}
