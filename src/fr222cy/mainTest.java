package fr222cy;



public class mainTest {

	public static void main(String[] args) {
		
		System.out.println("Testing");
		
		MyGraph<Integer> graph = new MyGraph<Integer>();
		
		graph.addNodeFor(1);
		graph.addNodeFor(2);
		
		graph.addEdgeFor(1, 3);
		graph.addEdgeFor(3, 2);
		graph.addEdgeFor(1, 1);
		
		
		System.out.println(graph.edgeCount());
		
		
		System.out.println(graph.allItems());
		
		

	}

}
