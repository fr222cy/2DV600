package fr222cy_assign2.Exercise_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount2Main {
	//NOTE: The words.txt path is sent in as arg.
	public static void main(String[] args) throws FileNotFoundException {
		HashWordSet hashWordSet = new HashWordSet();
		TreeWordSet treeWordSet = new TreeWordSet();
				
		try{
			Scanner scanner = new Scanner(new File(args[0]));
			
			while(scanner.hasNext()){
				Word word = new Word(scanner.next());
				hashWordSet.add(word);
				treeWordSet.add(word);
			}
			scanner.close();
		}
		catch(Exception e){
			System.err.println("Something went wrong!");
			e.printStackTrace();
		}
		
		/*
		 * Calls the toString() method in hashWordSet to iterate over all elements and
		 * print it out as a string.
		 */		
		System.out.println("HashWordset Content");
		System.out.println("---------------");
		System.out.println(hashWordSet.toString());
		System.out.println();		
		/*
		 * Calls the toString() method in treeWordSet to iterate over all elements and
		 * print it out as a string.
		 */
		System.out.println("TreeWordset Content");
		System.out.println("---------------");
		System.out.println(treeWordSet.toString());
		
		
		System.out.println("Hashset Size:" +hashWordSet.size());
		System.out.println("Treeset Size:" +treeWordSet.size());	
	}

}
