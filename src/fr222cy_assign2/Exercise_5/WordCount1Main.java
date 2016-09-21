package fr222cy_assign2.Exercise_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {
				
	public static void main(String[] args) throws FileNotFoundException {
		HashSet<Word> hashSet = new HashSet<>();
		TreeSet<Word> treeSet = new TreeSet<>();
		HashWordSet set = new HashWordSet();
		
		try{
			Scanner scanner = new Scanner(new File(args[0]));
			
			while(scanner.hasNext()){
				Word word = new Word(scanner.next());
				hashSet.add(word);
				treeSet.add(word);
				set.add(word);
				
			}
			scanner.close();
		}
		catch(Exception e){
			System.err.println("Something went wrong");
			e.printStackTrace();
		}
		
		Iterator<Word> treeIterator = treeSet.iterator();
		while(treeIterator.hasNext()){
			System.out.println(treeIterator.next());
		}
		
		
			
		System.out.println();
		System.out.println("Treeset:"+treeSet.size());
		System.out.print("HashSet:"+hashSet.size());
		
		Iterator<Word> iterator = set.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}

}
