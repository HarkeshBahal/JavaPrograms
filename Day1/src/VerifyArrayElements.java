
public class VerifyArrayElements {
	public static void main(String[] args) {
		int[] array = {23,5,67,8,9,39,15,13,79,60,50};
		int arraySum = 0;
		System.out.println("Elements in the array: ");
		for(int i=0; i<array.length;i++) {
			System.out.print(array[i]+" ");
			 arraySum = arraySum + array[i]; 
		}
		
		float arrayAverage = arraySum/(array.length);
		
		System.out.println("\nElements of array which are greater than its average(" +arrayAverage +") are ");
		for(int i=0; i<array.length; i++) {
			if(array[i]>13) {
				System.out.print(array[i]+" ");
			}
		}
	}

}

/* Output:
 * 	Elements in the array: 
	23 5 67 8 9 39 15 13 79 60 50 
	Elements of array which are greater than its average(33.0) are 
	23 67 39 15 79 60 50  	
 */
