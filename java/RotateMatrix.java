package com.github.johnmidavis.exercises.java;

public class RotateMatrix {

	/**
	 * Per an exercise I came across:
	 * http://www.programcreek.com/2013/01/leetcode-rotate-image-java/
	 * I was thinking it might be worth writing up the first solution
	 * that popped into my head. Flips across the diagonal and across
	 * the vertical are both rather trivial pieces of code and their
	 * composition does the trick.   
	 * 
	 * You are taking a 2x hit in performance for huge gain in clarity.
	 * The worth of that always depends on the situation.
	 */
	public static void main(String[] args) {
		System.out.println("initial matrix ===============\n");
		int[][] fiveByFive = makeTestMatrix(5);
		printMatrix(fiveByFive);
		rotateMatrixClockwise(fiveByFive);
		System.out.println("after rotation ===============\n");
		printMatrix(fiveByFive);
	}
	
	public static void rotateMatrixClockwise(int[][] inputMatrix)
	{
		int size = inputMatrix.length;
		if(size < 2) {return;}
		int i,j;
		
		// flip on diagonal
		for(i=0;i<size;i++)
		{
			for (j=i+1; j<size; j++)
			{
				int temp = inputMatrix[i][j];
				inputMatrix[i][j] = inputMatrix[j][i];
				inputMatrix[j][i] = temp;
			}
		}
		
		// flip on vertical
		for(i=0; i<size; i++){
			for(j=0; j < (size + 1)/2 ; j++)
			{
				int temp = inputMatrix[i][j];
				inputMatrix[i][j] = inputMatrix[i][size - j - 1];
				inputMatrix[i][size - j - 1] = temp;
		    }
		}
	}
	
	// code probably belongs in utility class - for demonstration purposes
	public static void printMatrix(int[][] inputMatrix)
	{
		//DecimalFormat formatter = new java.text.DecimalFormat(" %d ");

		int size = inputMatrix.length;
		int i,j;
		for(i=0;i<size;i++)
		{
			for(j=0; j<size; j++)
			{
			   System.out.format(" %5d ", inputMatrix[i][j]);	
			}
			System.out.println();
			System.out.println();
		}
	}
	
	// matrix for testing
	private static int[][] makeTestMatrix(int size)
	{
		int[][] matrix = new int[size][size];
		int i,j,k;
		k = 0;
		for(i=0;i<size;i++)
		{
			for(j=0; j<size; j++)
			{
			   matrix[i][j] = k++;	
			}
		}
		return matrix;
	}

}
