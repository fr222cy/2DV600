/**
 * 
 */
package fr222cy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
	//TODO: REPLACE LIST WITH HASHLIST 
	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
		List<Node<E>> nodeList = new ArrayList<Node<E>>();

		root = graph.getNodeFor(root.item());

		return dfsRecursive(nodeList, root);
	}
	
	private List<Node<E>> dfsRecursive(List<Node<E>> nodeList, Node<E> node){
		Iterator<Node<E>> successors = node.succsOf();
	
		node.num = nodeList.size();
		nodeList.add(node);
		
		while(successors.hasNext()){
			Node<E> next = successors.next();
			if(!nodeList.contains(next)){
				dfsRecursive(nodeList,next);
			}
		}
		return nodeList;
	}
		
	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph) {
		List<Node<E>> nodeList = new ArrayList<Node<E>>();
		Iterator<Node<E>> heads = graph.heads();
		if(graph.headCount() != 0){
			while(heads.hasNext()){
				nodeList = dfsRecursive(nodeList, heads.next());
			}
		}
		else{
			nodeList = dfsRecursive(nodeList, graph.getNodeFor(graph.allItems().get(0)));
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
