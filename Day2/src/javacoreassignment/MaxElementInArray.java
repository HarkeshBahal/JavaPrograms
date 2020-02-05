package javacoreassignment;

public class MaxElementInArray {
	public static void main(String[] args) {
		int[] array = {101,5000,4000,76,3,2301,45,100};
		int maxElement = 0;
		for(int i=0; i<array.length; i++) {
//			for(int j=1; j<array.length; j++) {
//				if(array[i] >= array[j] && array[i] >= maxElement ) {
//					maxElement = array[i];
//				}else if (array[i] <=array[j] && array[j] >= maxElement)  {
//					maxElement = array[j];
//				}
//			}
			if(array[i] >= maxElement) {
				maxElement = array[i];
			}
		}
		System.out.println("Elements of the Array: ");
		for(int arrayElement : array) {
			System.out.print(arrayElement+" ");
		}
		System.out.println("\nMaximum value of the element from the above array: "+maxElement);
	}

}
/*Output: 
 * 	Elements of the Array: 
	101 89 4000 76 3 2301 45 100 
	Maximum value of the element from the above array: 4000
 */
