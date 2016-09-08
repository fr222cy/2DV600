package fr222cy_assign1.Queue;
/**
 * @author Filip Rydberg
 *
 */
import java.util.Iterator;

import javax.xml.transform.Templates;

public class Queue implements QueueInterface {
	private Node tail;
	private Node head;
	private int size = 0;
	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(Object obj) {
		
		if (head == null){
			head = new Node(obj);
			tail = head;// Add first element
		}
	
		else {
		tail.setNext(new Node(obj)); // Attach new node
		tail = tail.getNext(); // Update tail
		}
		size++;
	}

	@Override
	public Object dequeue() throws IndexOutOfBoundsException {
		if(head != null){
			Node headTobeRemoved = head; // Find node before index 
			
			head = headTobeRemoved.getNext();
			size--;
			
			return headTobeRemoved.getObject();
		}
		else{
			throw new IndexOutOfBoundsException();
		}
	
	}

	@Override
	public Object first() throws IndexOutOfBoundsException {
		if(head != null){
			return head.getObject();
		}
		else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public Object last() throws IndexOutOfBoundsException {
		if(head != null){
			return tail.getObject();
		}
		else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public boolean contains(Object obj) {
		
		Iterator<Object> iterator = iterator();
		
		while(iterator.hasNext()){
			if(obj == iterator.next()){
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Object> {
        private Node node = head;
        
        
        // true if the iteration has more elements
        @Override
        public boolean hasNext() {
            return node != null;
        }
        
        // Returns the next Object in the iteration
        @Override
        public Object next() {
        	
        	if(node != null){
        		 Object val = node.getObject();
                 node = node.getNext();
                 return val;
        	}
        	else{
        		throw new IndexOutOfBoundsException();
        	}
        }
    }
	
	private class Node{
		
		private Node next = null;
		private Object _obj;
		
		public Node(Object obj){
			_obj = obj;
		}
		
		public Object getObject(){
			return _obj;
		}
								
		public void setNext(Node obj){
			next = obj;
		}
		
		public Node getNext(){
			return next;
		}
	
	}
}


