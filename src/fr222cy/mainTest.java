package fr222cy;

public class mainTest {

	public static void main(String[] args) {
		MyGraph<String> graph = new MyGraph<>();
		
		graph.addEdgeFor("a", "b");
		graph.addEdgeFor("b", "c");
		graph.addEdgeFor("c", "d");
		graph.addEdgeFor("c", "e");
		//System.out.println(graph);
		MyGML<String> gml = new MyGML<>(graph);
		
		gml.dumpGML();
		
	}

}
