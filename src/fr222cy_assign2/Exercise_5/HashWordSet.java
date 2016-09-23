package fr222cy_assign2.Exercise_5;

import java.util.Iterator;

public class HashWordSet implements WordSet{
	private int size; // Current size
	private Node[] buckets = new Node[8];
	
	@Override
	public Iterator<Word> iterator() {
		return new HashIterator();
	}

	@Override
	public void add(Word word) {
		
		int pos = getBucketNumber(word);
		Node node = buckets[pos]; // First node in list
		
		while (node != null) { // Search list
			if (node.value.equals(word) && node.value.hashCode() == word.hashCode()){
				return; // Element found ==> return
			}
			else{
				node = node.next; 
			}
		}
		node = new Node(word); // Not found, add new node as first entry
		node.next = buckets[pos];
		buckets[pos] = node;
		size++;
		
		if (size == buckets.length){
			rehash(); 
		}
	}
	
	private int getBucketNumber(Word word) {
		int hc = word.hashCode(); // Use hashCode() from String class
		
		if (hc < 0){
			hc = -hc; // Make sure non−negative
		}
		return hc % buckets.length; // Simple hash function
	}

	@Override
	public boolean contains(Word word) {
		
		int pos = getBucketNumber(word);
		Node node = buckets[pos];
		while (node != null) { // Search list for element
		if (node.value.equals(word) && node.value.hashCode() == word.hashCode())
			return true; // Found!
		else
			node = node.next;
		}
		return false;
	}

	@Override
	public String toString(){
		String content = "";
		Iterator<Word> iterator = iterator();
		while(iterator.hasNext()){
			content += iterator.next() +"\n";
		}
		return content;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	private void rehash() {
		Node[] temp = buckets; // Copy of old buckets
		buckets = new Node[2*temp.length]; // New empty buckets
		size = 0;
		for (Node n : temp) { // Insert old values into new buckets
			if (n == null){
				continue; // Empty bucket
			}
				while (n != null){
				add(n.value ); // Add elements again
				n = n.next;
			}	
		}
	}
	
	private class Node { // Private inner classes
		Word value;
		Node next = null;
		
		public Node(Word word){
			value = word; 
		}
		public String toString (){
			return value.toString();
		}
	}
	
	private class HashIterator implements Iterator<Word> {
		private Node node;
		private int index = 0;
        
        public HashIterator() {
        	for(int i = 0; i < buckets.length; i++){
        		if(buckets[i] != null){
        			node = buckets[i];
        			index = i;
        			break;
        		}
        	}
		}
        
        @Override
        public boolean hasNext() {
            return node != null;
        }
        
        @Override
        public Word next() {
        	Node toBeReturned = node;
        	
        	if(node.next != null){
        		node = node.next;
        	}
        	else {
        		index++;
        		while(buckets[index] == null && index < size)
        		{
        			index++;
        		}
        		node = buckets[index];
			}
        	return toBeReturned.value;
        }
    }

}
