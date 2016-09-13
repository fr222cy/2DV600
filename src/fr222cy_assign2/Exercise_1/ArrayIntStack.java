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
			
		int temp;
		int numberToBeShifted = n;
		for(int i = -1; i < size(); i++){		
			temp = values[i+1];
			values[i+1]=numberToBeShifted;
			numberToBeShifted = temp;	
		}
		size++;
	}


	@Override
	public int pop() throws IndexOutOfBoundsException {
		if(size == 0){
			throw new IndexOutOfBoundsException();
		}
		int temp = values[0];
		for (int i = 0; i < size(); i++){
			values[i] = values[i+1];			
		}
		size--;
		return temp;
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		if(size == 0){
			throw new IndexOutOfBoundsException();
		}
		return values[0];
	}

}
