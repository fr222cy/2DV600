package fr222cy_assign2.Exercise_1;

import javax.swing.text.TabStop;
import javax.xml.transform.Templates;

import org.omg.CORBA.PRIVATE_MEMBER;

public class ArrayIntStack extends AbstractIntCollection implements IntStack{
	
	
	
	@Override
	public void push(int n) {
		
		if(size() == values.length){
			resize();
		}
		values[size++] = n;
	}


	@Override
	public int pop() throws IndexOutOfBoundsException {
		if(size == 0){
			throw new IndexOutOfBoundsException();
		}
		return values[--size];
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		if(size == 0){
			throw new IndexOutOfBoundsException();
		}
		return values[size-1];
	}

}
