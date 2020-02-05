package javacoreassignment;

public class FibonacciSeriesWithRecursion {
	
	public static int fibonacci(int number) {
		if(number == 0)
	        return 0;
	    else if(number == 1)
	      return 1;
	   else
	      return fibonacci(number - 1) + fibonacci(number - 2);
	}
    public static void main(String[] args) {
    	int fibNum = 0;
    	System.out.println("Fibonacci series numbers less than 500 are: ");
    	 for(int i =1; i<=500; i++) {
    		 fibNum = fibonacci(i);
    		 	if(fibNum<500) {
    		 		System.out.print(fibNum+" ");
    		 	}else {
    		 		break;
    		 	}
     }
    }
}

/*OutPut
 * Fibonacci series numbers less than 500 are: 
	1 1 2 3 5 8 13 21 34 55 89 144 233 377 
 * 
 */
