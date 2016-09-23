package fr222cy_assign2.Exercise_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {
	//NOTE: The words.txt path is sent in as arg.			
	public static void main(String[] args) throws FileNotFoundException {
		HashSet<Word> hashSet = new HashSet<>();
		TreeSet<Word> treeSet = new TreeSet<>();
	
		try{
			Scanner scanner = new Scanner(new File(args[0]));
			
			while(scanner.hasNext()){
				Word word = new Word(scanner.next());
				hashSet.add(word);
				treeSet.add(word);				
			}
			scanner.close();
		}
		catch(Exception e){
			System.err.println("Something went wrong");
			e.printStackTrace();
		}
		System.out.println("TreeWordset Content");
		System.out.println("---------------");
		Iterator<Word> treeIterator = treeSet.iterator();
		while(treeIterator.hasNext()){
			System.out.println(treeIterator.next());
		}
		
		System.out.println("Hashset Size:" +hashSet.size());
		System.out.println("Treeset Size:" +treeSet.size());	
		
	}

}
