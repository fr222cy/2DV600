package fr222cy;

import javax.naming.ldap.StartTlsRequest;

import fr222cy_assign3.graphs.Node;

public class mainTest {

	public static void main(String[] args) {
		MyGraph<String> graph = new MyGraph<>();
		
		graph.addEdgeFor("a", "b");
		graph.addEdgeFor("a", "c");
		graph.addEdgeFor("b", "d");
		graph.addEdgeFor("c", "d");
		//graph.addEdgeFor("d", "b");
		graph.addEdgeFor("d", "e");
		graph.addEdgeFor("e", "g");
		graph.addEdgeFor("e", "f");
		//graph.addEdgeFor("f", "d");
	
		//System.out.println(graph);
		//MyGML<String> gml = new MyGML<>(graph);
	
		
		MyDFS<String> dfs = new MyDFS<>();
		//System.out.println(dfs.dfs(graph, graph.getNodeFor("a")));
		System.out.println(dfs.dfs(graph));
		System.out.println(dfs.postOrder(graph));
		System.out.println(dfs.topSort(graph));
	}

}
