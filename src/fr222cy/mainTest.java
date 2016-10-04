package fr222cy;


public class mainTest {

	public static void main(String[] args) {
		MyGraph<String> graph = new MyGraph<>();
		
		graph.addEdgeFor("a", "b");
		graph.addEdgeFor("a", "c");
		graph.addEdgeFor("b", "d");
		graph.addEdgeFor("c", "d");
		graph.addEdgeFor("d", "e");
		graph.addEdgeFor("d", "f");
		graph.addEdgeFor("e", "f");
		graph.addEdgeFor("e", "g");
		
		
		//System.out.println(graph);
		MyGML<String> gml = new MyGML<>(graph);
	
		MyDFS<String> dfs = new MyDFS<>();
		//MyBFS<String> bfs = new MyBFS<>();
		//System.out.println(dfs.dfs(graph, graph.getNodeFor("a")));
		System.out.println(dfs.dfs(graph));
		System.out.println(dfs.postOrder(graph));
		System.out.println(dfs.topSort(graph));
	}

}
