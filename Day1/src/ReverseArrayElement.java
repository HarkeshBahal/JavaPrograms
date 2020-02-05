
public class ReverseArrayElement {
	
	public static void main(String[] args) {
		int[] array = {23,45,65,87,89,99};
		int arrayLength = array.length;
		System.out.println("Elements in the Array:");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("\nElements in the Array in reverse order:");
		for(int i = arrayLength-1; i >=0; i--) {
			System.out.print(array[i]+" ");
		}
	}



}
/* OutPut:
 * 	Elements in the Array:
	23 45 65 87 89 99 
	Elements in the Array in reverse order:
	99 89 87 65 45 23 
 */
