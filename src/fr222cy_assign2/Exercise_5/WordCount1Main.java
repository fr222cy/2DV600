package fr222cy_assign2.Exercise_5;

public class WordCount1Main {

	public static void main(String[] args) {
		Word word = new Word("Hello");
		Word word2 = new Word("HELLO");
		Word word3 = new Word("hello");
		Word word4 = new Word("hello");
		
		System.out.println(word.compareTo(word4));

	}

}
