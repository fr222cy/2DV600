/**
 * 
 */
package fr222cy_assign1;

import java.util.Scanner;

/**
 * @author filip rydberg
 *
 */
public class Backwards {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(reverseString(scanner.nextLine()));
		scanner.close();
	}
	
	static String reverseString(String string){
		
		StringBuffer b = new StringBuffer(string);
		
		return b.reverse().toString();
	}

}
