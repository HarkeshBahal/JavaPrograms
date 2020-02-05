
public class MultiplyTwoMatrices {
	public static void main(String[] args) {
		int[][] matrice1 = {{5,7,8,5},{6,7,8,8},{8,9,7,9}};
		int[][] matrice2 = {{4,5,6,2},{4,5,2,8},{9,5,4,7}};
		int[][] resultOfMultiplication = new int[matrice1.length][matrice2.length+1];
		
		System.out.print("\nElements in the matrice1:");
		//Print element of matrice 1
		printMatices(matrice1);
		
		System.out.print("\nElements in the matrice2:");
		//Print element of matrice 1
		printMatices(matrice2);
		
		// Multiplication of two matrices
		for(int i=0; i<matrice1.length; i++) {
			for(int j=0; j<matrice1[i].length; j++) {
				resultOfMultiplication[i][j] = matrice1[i][j]*matrice2[i][j];
			}
		}
		
		System.out.print("\nResult of the multiplication of two matrices:");
		
		//Printing the result of multiplication of two matrices
		printMatices(resultOfMultiplication);
	}

	static void printMatices(int[][] matrice ) {
		for(int i=0; i<matrice.length; i++) {
			System.out.print("\n");
		for(int j=0; j<matrice[i].length; j++) {
			System.out.print(matrice[i][j]+" ");
		}
	}
	}

}

/*Output:
 * 	Elements in the matrice1:
	5 7 8 5 
	6 7 8 8 
	8 9 7 9 
	Elements in the matrice2:
	4 5 6 2 
	4 5 2 8 
	9 5 4 7 
	Result of the multiplication of two matrices:
	20 35 48 10 
	24 35 16 64 
	72 45 28 63 
 */
