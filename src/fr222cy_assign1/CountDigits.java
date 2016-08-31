/**
 * 
 */
package fr222cy_assign1;

import java.util.Scanner;

/**
 * @author Filip Rydberg
 *
 */
public class CountDigits {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		try{
			System.out.println("Enter a bunch of numbers:");
			String inputNumbers = scanner.nextLine();
			countDigits(inputNumbers);	
			scanner.close();
		}
		catch(Exception e){
			System.out.println("Something went wrong: " + e);
		}		
	}
	
	/*
	 * Splits the string of numbers into a charArray.
	 * Counts the chars in the array.
	 */
	static void countDigits(String numbers){
		int zeros = 0;
		int even = 0;
		int odd = 0;
		int sum = 0;
		
		char[] digArr = numbers.toCharArray();
		
		for (char charNum : digArr){
			int num = Character.getNumericValue(charNum);
			if(num == 0){
				zeros++;
			}
			else if(num % 2 == 0){
				even++;
			}
			else{
				odd++;
			}
			
			sum += num;	
		}
		
		System.out.println("Zeros:"+zeros);
		System.out.println("Even:"+even);
		System.out.println("Odd:"+odd);
		System.out.println("Sum:"+sum);	
	}

}
