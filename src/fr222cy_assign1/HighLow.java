/**
 * 
 */
package fr222cy_assign1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Filip Rydberg
 *
 */
public class HighLow {
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int randomNum = getRandomNumber();
		int guess = 1;
		System.out.println("Guessgame: Enter an odd number between 1-99: ");
		while(true){
			try{
				
				int guessedNumber = scanner.nextInt();
				System.out.println("Guesses:"+guess + "| Number:"+guessedNumber);
				if(guess == 11){
					System.out.println("You are out of guesses... The random number was "+ randomNum);
					break;
				}		
				else if(isGuessCorrect(guessedNumber,randomNum)){
					System.out.println("You Won! The number was " + randomNum);
					break;
				}
				
				guess++;
			}
			catch(Exception e){
				System.out.println("Something went wrong: " + e);
			}
		}
		
		scanner.close();
	}
	
	//Returns true if guess is correct, false if incorrect.
	static boolean isGuessCorrect(int guessedNumber, int randomNum){
		
		if(guessedNumber < randomNum){
			System.out.println("Hint: Higher!");
			return false;
		}
		else if(guessedNumber > randomNum){
			System.out.println("Hint: Lower!");
			return false;
		}
		else{
			return true;
		}
	}
	
	//Returns a randomized odd number between 1-100
	static int getRandomNumber(){
		int randomOddNr;
		while(true){
			Random rn = new Random();
			randomOddNr = rn.nextInt(101);
			
			if(randomOddNr % 2 == 1){
				break;
			}
		}
		return randomOddNr;
	}
}

