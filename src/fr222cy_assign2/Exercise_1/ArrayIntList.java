package fr222cy_assign2.Exercise_1;
/*
 * @author Filip Rydberg
 */
public class ArrayIntList extends AbstractIntCollection implements IntList{

	@Override
	public void add(int n) {
		
		if(size() == values.length){
			resize();
		}
		values[size()] = n;
		size++;						
	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size())){ //Don't really see the point using this. But it was a part of the abstract class.
			throw new IndexOutOfBoundsException();
		}
		
		int tempVal;
		int numberToBeShifted = values[index]; 
		values[index] = n;
		
		for(int i = index; i < size(); i++){
			
			if(size() > index){
				resize();
			}
			
			tempVal = values[i+1];
			values[i+1]=numberToBeShifted;
			numberToBeShifted = tempVal;	
		}
		size++;	
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size())){
			throw new IndexOutOfBoundsException();
		}
		
		for (int i = index; i < size(); i++){
			values[i] = values[i+1];			
		}
		size--;
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size())){
			throw new IndexOutOfBoundsException();
		}
		return values[index];
	}

	@Override
	public int indexOf(int n) {
		
		for(int i = 0; i < size(); i++){
			if(values[i] == n){
				return i;
			}
		}
		return -1;
	}

}
