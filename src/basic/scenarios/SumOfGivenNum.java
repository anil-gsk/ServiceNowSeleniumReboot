package basic.scenarios;

import java.util.Scanner;

public class SumOfGivenNum {

	public static void main(String[] args) {
	
		System.out.println("Enter the number to find itd SUM:::");
		
		Scanner in =  new Scanner(System.in);
		
		int InputNo = in.nextInt();
		
		int Sum =0;
		int remaind, qoe;
		
		remaind = (InputNo)%10;
		
		qoe = (InputNo)/10;
		
		System.out.println(qoe);
		
		

	}

}
