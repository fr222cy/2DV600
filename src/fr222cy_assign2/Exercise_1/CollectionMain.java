package fr222cy_assign2.Exercise_1;

public class CollectionMain {

	public static void main(String[] args) {
		ArrayIntList list = new ArrayIntList();	
		ArrayIntStack stack = new ArrayIntStack();
		
		System.out.println("Adding 1,2,3,4,5 to list and stack...");
		System.out.println();
		for(int i = 1; i < 6 ; i++){
			list.add(i);
			stack.push(i);
		}
		
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
		
		System.out.println("INTSTACK: " + stack.toString());
		stack.push(8);
		System.out.println("push(8)" + stack.toString());
		System.out.println("pop() Return:" + stack.pop());
		System.out.println("pop() Return:" + stack.pop());
		System.out.println("Stack-values:" + stack.toString());
		stack.peek();
		System.out.println("stack.peek() Return:" + stack.peek());
	}
}
