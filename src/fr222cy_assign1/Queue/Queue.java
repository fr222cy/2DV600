package fr222cy_assign1.Queue;

import java.util.Iterator;

public class Queue implements QueueInterface {
	private Object tail;
	private Object head;
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
	public void enqueue(Object element) {
		
			if (head == null){
				head = new Node(element);
				tail = head;// Add first element
			}
		
			else {
			tail.next = new Node(element); // Attach new node
			tail = tail.next // Update tail
			}
			size++;
		
	}

	@Override
	public Object dequeue() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object first() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object last() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class ListIterator implements Iterator<Object> {
		private int count = 0;
		
		public Object next(){
			return values [count++];
		}
		
		public boolean hasNext(){
			return count<size;
		}	
	}
	
	private class Node{
		
		public Node next = null;
		
		public Node(Object e){
		
		}
	}
}


