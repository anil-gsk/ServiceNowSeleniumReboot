package basic.scenarios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EvenOrOdd {

	public static void main(String[] args) {

		int x = 0;
		
		System.out.println("Enter an integer to confirm given number is even or odd:");
		
		Scanner in = new Scanner(System.in);
		

			
			try {
				
				x = in.nextInt();
				
				if(x%2==0){
					
					System.out.println("Given numer is Even numvber");
				}
				
				else{
					
					System.out.println("Given number is odd Number");
					
				}
			
			} catch (InputMismatchException e) {
				
				System.out.println("Given input is not a number");
			}
			
			
				
			
	
			
			
			

		

	}

}
