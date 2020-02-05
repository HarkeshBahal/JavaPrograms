import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VerifyNumberIsEvenOrOdd {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number;
		
		System.out.println("Enter the number to verify if its Even or Odd:");
		number = Integer.parseInt(br.readLine());
		
		//Used ternary operator for Even/Odd verification
		String value =((number%2) == 0) ? "Entered Number "+number+" is Even" : "Entered Number "+number+" is Odd";
		
		System.out.println(value);
	}

}

/* Output:
 * 	Enter the number to verify if its Even or Odd:
	46578
	Entered Number 46578 is Even
 */
