package de.lab4inf.wrb.matrix;

public class testclass {
	

	public static void main(String [] args)
	{
		
		int runs = 256;
		int SCALED = -1*runs;
		for(int k = 0; k<10; k++) {
			runs/=2;
			System.out.println(SCALED);
		}
		//long test = 200000000;
		//double testd =  test / 1E9;
		
		/*double[][] ad = new double[][] { {1,2,3}, {2,3,4}, {1,2,3}, {2,3,4}, {1,2,3}};
		Matrix a = new Matrix(ad);
		double[][] bd = new double[][] { {1,2,3,4,5}, {2,3,4,5,6}, {1,2,3,4,5}};
		Matrix b = new Matrix(bd);
		
		Matrix c = matSeriell.multiply(a, b);
		System.out.println(c.toString());*/
		
		//System.out.println(testd);
		
		

	}
		
}
