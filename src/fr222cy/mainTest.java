package fr222cy;

import java.util.Iterator;

import fr222cy_assign3.graphs.test.GraphGenerator;

public class mainTest {

	public static void main(String[] args) {
		
		System.out.println("Testing");
		
		MyGraph<Integer> graph = new MyGraph<Integer>();
		
		graph.addNodeFor(1);
		graph.addNodeFor(2);
		graph.addNodeFor(3);
		graph.addNodeFor(4);
		graph.addNodeFor(5);
		
		
		graph.addEdgeFor(1, 2);
		graph.addEdgeFor(1, 3);
		
		graph.addEdgeFor(3, 4);
		graph.addEdgeFor(3, 5);
		graph.addEdgeFor(4, 5);
		
		graph.removeNodeFor(2);
		graph.removeNodeFor(1);
		graph.removeNodeFor(3);
		graph.removeNodeFor(4);
		graph.removeNodeFor(5);
		graph.addEdgeFor(4, 6);
		graph.addEdgeFor(4, 7);
		graph.addEdgeFor(4, 8);
		graph.removeEdgeFor(4, 6);
		
		System.out.println("HEADS:"+graph.headCount());
		System.out.println("TAILS:"+graph.tailCount());
		System.out.println(graph.edgeCount());
		
		
		
		System.out.println(graph.allItems());
		
		

	}

}
