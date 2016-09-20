package fr222cy_assign2.Exercise_5;

import java.lang.reflect.WildcardType;

public class Word implements Comparable<Word> {
	private String word;

	public Word(String str) {
		 word = str;
	}
	@Override
	public String toString() {
		return word; 
	}
	
	@Override
	public int hashCode() {
		char[] charArr = word.toCharArray();
		int hashCode = 0;
		for(Character c : charArr){
			hashCode += Character.getNumericValue(c);
		}
		return hashCode;
	}
	@Override
	public boolean equals(Object other) {
		if (other instanceof Word) {
			Word otherWord = (Word) other;
			return word.toLowerCase().equals(otherWord.word.toLowerCase()); 
			}
			return false ;
	}
	/* Implement Comparable */
	public int compareTo(Word w) {
		return word.compareToIgnoreCase(w.word);
	}
}
