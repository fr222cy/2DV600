package fr222cy_assign1;

import java.util.Scanner;

/**
 * @author filip rydberg
 *
 */
public class LargestK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		try{
			int inputNumber = scanner.nextInt();
			
			System.out.println(calculateLargestK(inputNumber));	
		}
		catch(Exception e){
			System.out.println("Something went wrong: " + e);
		}
		
		
	}
	
	static int calculateLargestK(int n){
		
		int sum = 0;	
		int largestK = 0;
		
		while(sum + (largestK+2) <= n){
			largestK += 2;
			
			sum += largestK;
		}
		
		return largestK;
	}

}
