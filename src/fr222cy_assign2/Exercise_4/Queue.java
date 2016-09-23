/**
 * @author Filip Rydberg
 */
package fr222cy_assign2.Exercise_4;

import java.util.Iterator;

public class Queue<E> implements IQueue<E> {
	private Node tail;
	private Node head;
	private int size = 0;
	
	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(E element) {
		if (head == null){
			head = new Node(element);
			tail = head;// 
		}
		else {
		tail.setNext(new Node(element)); 
		tail = tail.getNext();
		}
		size++;
	}

	@Override
	public E dequeue() {
		if(head != null){
			Node headTobeRemoved = head; // 
			
			head = headTobeRemoved.getNext();
			size--;
			
			return headTobeRemoved.getElement();
		}
		else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public E first() {
		if(head != null){
			return head.getElement();
		}
		else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public E last() {
		if(head != null){
			return tail.getElement();
		}
		else{
			throw new IndexOutOfBoundsException();
		}
	}
	
	private class Node{
		
		private Node next = null;
		private E _element;
		
		public Node(E element){
			_element = element;
		}
		
		public E getElement(){
			return _element;
		}
								
		public void setNext(Node element){
			next = element;
		}
		
		public Node getNext(){
			return next;
		}
	
	}
	
	private class ListIterator implements Iterator<E> {
        private Node node = head;
        private int count = 0;
        
        @Override
        public boolean hasNext() {
            return node != null;
        }
        
        @Override
        public E next() {
        	
        	if(node != null){
        		 E val = node.getElement();
                 node = node.getNext();
                 return val;
        	}
        	else{
        		throw new IndexOutOfBoundsException();
        	}
        }
    }

}
