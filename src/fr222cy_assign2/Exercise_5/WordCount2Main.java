package fr222cy_assign2.Exercise_5;

import java.util.Iterator;

public class WordCount2Main {

	public static void main(String[] args) {
		HashWordSet set = new HashWordSet();
		Word word1 = new Word("eee");
		set.add(new Word("hello"));
		set.add(new Word("hello"));
		set.add(new Word("hello"));
		set.add(word1);
		set.add(word1);
		System.out.println(set.size());
		
		Iterator<Word> iterator = set.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	
	}

}
