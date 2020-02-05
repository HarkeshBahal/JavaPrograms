package javacoreassignment;

import java.util.Scanner;

public class SumOfEnteredDigit {
	public static void main(String[] args) {
		System.out.println("Enter number to print its digits sum:");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		int sumOfDigitInNumber = sumOfDigit(number);
		System.out.println("Sum of the digit of the entered number "+number +" is "+ sumOfDigitInNumber);
	}
	static int sumOfDigit(int number) {
		int sum = 0;
		while(number > 0) {
			sum = sum+(number%10);
			number = number/10;
		}
		return sum;
	}
}

/*Output
 * Enter number to print its digits sum:
	123456
	Sum of the digit of the entered number 123456 is 21
 */
