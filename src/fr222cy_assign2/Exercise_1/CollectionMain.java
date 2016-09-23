package fr222cy_assign2.Exercise_1;
/*
 * @author Filip Rydberg
 */
public class CollectionMain {

	public static void main(String[] args) {
		ArrayIntList list = new ArrayIntList();	
		ArrayIntStack stack = new ArrayIntStack();
		/*
		 * Adding 5 values to both List and Stack.
		 */
		System.out.println("Adding 1,2,3,4,5 to list and stack...");
		System.out.println();
		for(int i = 1; i < 6 ; i++){
			list.add(i);
			stack.push(i);
		}
		/*
		 * Demonstrating the functionality of the ArrayIntList.
		 */
		System.out.println("INTLIST: " + list.toString());
		list.addAt(99, 2);
		System.out.println("addAt(99,2): " + list.toString());
		list.remove(3);
		System.out.println("remove(3): " + list.toString());
		System.out.println("get(2): " + list.get(2));
		System.out.println("indexOf(99): " + list.indexOf(99));
		System.out.println("indexOf(6): " + list.indexOf(6));
		System.out.println();
		System.out.println("----");
		System.out.println();
		
		
		/*
		 * Demonstrating the functionality of the ArrayIntStack.
		 */
		System.out.println("INTSTACK: " + stack.toString());
		stack.push(8);
		System.out.println("push(8)" + stack.toString());
		System.out.println("pop() Return:" + stack.pop());
		System.out.println("pop() Return:" + stack.pop());
		System.out.println("Stack-values:" + stack.toString());
		stack.peek();
		System.out.println("stack.peek() Return:" + stack.peek());
		System.out.println();
		
		
		/*
		 * Demonstrating two cases where exceptions are thrown.
		 */
		System.out.println("Initialize empty stack");
		ArrayIntStack emptyStack = new ArrayIntStack();
		System.out.println("Pop empty stack");		
		try {
			emptyStack.pop();
		} catch (Exception e) {
			System.err.println("Exception was thrown at emptyStack.pop");
		}
		System.out.println();
		System.out.println("Initialize empty list");
		ArrayIntList emptyList = new ArrayIntList();
		System.out.println("Try to remove a number that doesn't exist.");
		try {
			emptyList.remove(0);
		} catch (Exception e) {
			System.err.println("Exception was thrown att emptyList.remove(0)");
		}		
	}
}
