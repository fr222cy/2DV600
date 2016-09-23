package fr222cy_assign2.Exercise_5;

import java.util.Iterator;

public class TreeWordSet implements WordSet {
	Node root = null;
	int size = 0;
	
	@Override
	public Iterator<Word> iterator() {
		return new TreeIterator();
	}

	@Override
	public void add(Word word) { //slides
		if(root == null){
			root = new Node(word);
		}
		else if(!root.contains(word)){
			root.add(word);
		}
		else {
			return;
		}
		size++;
	}

	@Override
	public boolean contains(Word word) {
		return root.contains(word);
	}

	@Override
	public int size() {
		return size;
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

	private class Node{
		Word word;
		Node left, right, parent ;
		boolean visited = false;
		
		public Node(Word w){
			word = w;
		}
		
		public void add(Word w){ //slides
			if(w.compareTo(word) < 0){
				if(left == null){
					left = new Node(w);
				}
				else{
					left.add(w);
				}
			}
			else if(w.compareTo(word) > 0){
				if(right == null){
					right = new Node(w);
				}
				else{
					right.add(w);
				}
			}
		}
				
		public boolean contains(Word w){ //slides
			
			if (w.compareTo(word) < 0) { 
				if (left == null){
					return false;
				}
				else{
					return left.contains(w);
				}
			}
			else if (w.compareTo(word) > 0) { 
				if (right == null){
					return false ;
				}
				else{
					return right.contains(w);
				}
			}
			return true; 
		}
	}
	//Collaborated with Kim Nilsson (kn222gp) to this iterator solution.
	private class TreeIterator implements Iterator<Word> {
		Node node;
		
        public TreeIterator() {
        	node = root;
        	
        	while(node.left != null){
        		Node temp = node;
        		node = node.left;
        		node.parent = temp;
        	}        
		}
        
        public boolean hasNext(){
        	return node != null;
        }
        
        public Word next(){
        	node.visited = true;
        	Node toBeReturned = node;
        	
        	 if (node.right != null) {
        		  node = node.right;
        		  
        		  if(node.parent == null ){
             		 node.parent = toBeReturned;
        		  }
                  while (node.left != null) {
                	  Node temp = node;
                	  node = node.left;
                	  node.parent = temp;
                  }
             }
        	 /*
        	  * Using temp node just set visited to false again on
        	  * all nodes. which enables the iterator to work more than once.
        	  */
        	 else {
                 while (node.visited ) {
                	Node temp = node;
 					node.visited = false;
 					if(node.parent == null) {
 						node = null;
 						break;
 					}
 					node = temp.parent;
                 }
             }
         
        	return toBeReturned.word;
        }
	}
}
