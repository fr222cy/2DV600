package fr222cy_assign1;

import java.io.IOException;
import java.util.Scanner;

public class Diamond {

	public static void main(String[] args) {
		System.out.print("Enter an odd number:");
		Scanner scanner = new Scanner(System.in);
		try{
			int inputNumber = scanner.nextInt();
			
			if(isNumberValid(inputNumber)){
				drawDiamond(inputNumber);
			}
			else{
				System.out.println("You need to enter an odd and positive number!");
			}
		}
		catch(Exception e){
			System.out.println("Something went wrong: " + e);
		}
		
		
	}
	
	static void drawDiamond(int thickness){
		int signs = 1;
		int whitespaces = (thickness-1)/2;
		boolean decreaseSigns = false;
		boolean addWhitespaces = true;
		
		for(int y = 0; y < thickness; y++){
				
			for(int x = 0; x < whitespaces; x++){
							
					System.out.print(" ");
			}
			for(int x2 = 0; x2 < signs; x2++){
				
				System.out.print("*");
		}
			System.out.println();
			
			if(signs < thickness && decreaseSigns == false){
				signs+=2;
			}
			else{
				signs-=2;
				decreaseSigns = true;
			}
			
			if(whitespaces > 0 && addWhitespaces == true){
				whitespaces-=1;
			}
			else{
				whitespaces+=1;
				addWhitespaces = false;
			}
		}
		
		
	}
	
	static boolean isNumberValid(int number){
		if(number %2 == 1 && number > 0){
			return true;
		}
		return false;
	}

}
//
//
//   
//  *
// ***
//*****
// ***
//  *
//   
// W:6
// S:13
//
//
//
//
//   *
//  ***
// *****
//*******
// *****
//  ***
//   *
// W=12
// S=25
// T = T * 2 *

