/**
 * 
 */
package fr222cy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import fr222cy_assign3.graphs.DFS;
import fr222cy_assign3.graphs.DirectedGraph;
import fr222cy_assign3.graphs.Node;
import fr222cy_assign3.graphs.test.GraphGenerator;

/**
 * @author Filip Rydberg
 *
 */
public class MyDFS<E> implements DFS<E>{

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
		List<Node<E>> nodeList = new ArrayList<Node<E>>();
		HashSet<Node<E>> visited = new HashSet<>();
		root = graph.getNodeFor(root.item());

		return dfsRecursive(nodeList, root, visited);
	}
	
	/*
	 *  Method : dfsRecursive
	 *  Returns: List<Node<E>>
	 *  Retrieves the successors from the node sent in.
	 *  Mark the node as visited.
	 *  Loop through the successors and call the method again till there are no more successors left and returns the list.
	 *  
	 */
	
	private List<Node<E>> dfsRecursive(List<Node<E>> nodeList, Node<E> node, HashSet<Node<E>> visited){
		Iterator<Node<E>> successors = node.succsOf();
	
		node.num = nodeList.size();
		visited.add(node);
		nodeList.add(node);
		
		while(successors.hasNext()){
			Node<E> next = successors.next();
			if(!visited.contains(next)){
				dfsRecursive(nodeList,next, visited);
			}
		}
		return nodeList;
	}
		
	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph) {
		List<Node<E>> nodeList = new ArrayList<Node<E>>(); 
		HashSet<Node<E>> visited = new HashSet<>();
		Iterator<Node<E>> heads = graph.heads();
		if(graph.headCount() != 0){
			while(heads.hasNext()){
				nodeList = dfsRecursive(nodeList, heads.next(), visited);
			}
		}
		else{
			nodeList = dfsRecursive(nodeList, graph.getNodeFor(graph.allItems().get(0)), visited);
		}
		return nodeList;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
		ArrayList<Node<E>> poList = new ArrayList<>();
		HashSet<Node<E>> visited = new HashSet<Node<E>> ();
		root = g.getNodeFor(root.item());
		return postOrderRecursive(poList,visited, root);
	}
	
	
	private List<Node<E>> postOrderRecursive(List<Node<E>> poList, HashSet<Node<E>> visited, Node<E> node){
		
		if(!visited.contains(node)){
			Iterator<Node<E>> successors = node.succsOf();
			visited.add(node);
			while(successors.hasNext()){
				Node<E> next = successors.next();
				if(!poList.contains(next)){
					postOrderRecursive(poList,visited,next);
				}	
			}
			node.num = poList.size() + 1; 
			poList.add(node);
		}
		return poList;
	}
		
	
	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g) {
		List<Node<E>> poList = new ArrayList<>();
		HashSet<Node<E>> visited = new HashSet<Node<E>> ();
		Iterator<Node<E>> heads = g.heads();
		
		if(g.headCount() != 0){
			while(heads.hasNext()){
				poList = postOrderRecursive(poList, visited, heads.next());
			}
		}
		else{
			poList = postOrderRecursive(poList, visited, g.getNodeFor(g.allItems().get(0)));
		}
		return poList;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 *  Method : isCyclic
	 *  Returns: Boolean
	 *  If a node in the graph has a cycle with another node or itself this method return -> true, otherwise -> false
	 */
	@Override
	public boolean isCyclic(DirectedGraph<E> graph) {
		
		Iterator<Node<E>> it = graph.iterator();
		
		while(it.hasNext()){
			Node<E> node = it.next();
			Iterator<Node<E>> it2 = node.succsOf();
			while(it2.hasNext()){
				if(it2.next().hasSucc(node)){
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 *  Method : topSort
	 *  Returns: List<Node<E>>
	 *  Creates an array with the size equal to containing nodes in the graph.
	 *  Cycle through each node in the list from postOrder(with the specified graph as param) and fill it from the end.
	 *  Convert the array to an arraylist and returns it.
	*/
	
	@Override
	public List<Node<E>> topSort(DirectedGraph<E> graph) {
		if(isCyclic(graph)){
			throw new RuntimeException("Graph needs to be acyclic!");
		}
		Node<E>[] topSortArr = new Node[graph.nodeCount()];
		
		for(Node<E> node : postOrder(graph)){
			topSortArr[graph.nodeCount() - (node.num) ] = node;
		}

		return Arrays.asList(topSortArr);
	}

	

}
