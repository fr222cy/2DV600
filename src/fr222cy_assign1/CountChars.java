/**
 * 
 */
package fr222cy_assign1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Filip Rydberg
 *
 */
public class CountChars {

	public static void main(String[] args) throws IOException {
		
		try{
			String content = getFileContent(args[0].toString());
			countContent(content);
		}
		catch(Exception e){
			System.out.println("Something went wrong!");
			e.printStackTrace();
		}
		
		
		
	}
	
	
	static void countContent(String content){
		char[] chars = content.toCharArray();
		
		int upperCase = 0;
		int lowerCase = 0;
		int whitespace = 0;
		int numbers = 0;
		int other = 0;
		
		for(char c : chars){
			
			if(Character.isUpperCase(c)){
				upperCase++;
			}
			else if(Character.isLowerCase(c)){
				lowerCase++;
			}
			else if(Character.isDigit(c)){
				numbers++;
			}
			else if(Character.isWhitespace(c)){
				whitespace++;
			}
			else{
				other++;
			}
			
		}
		System.out.println("Uppercases: "+ upperCase);
		System.out.println("Lowercases: "+ lowerCase);
		System.out.println("Numbers: "+ numbers);
		System.out.println("Whitespaces: "+ whitespace);
		System.out.println("Other: "+ other);
	}
	
	static String getFileContent(String path) throws IOException{
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(path)));
		} catch (FileNotFoundException e) {
			System.out.println("Provide a textfile!");
			e.printStackTrace();
		}
		return content;
	}

}
