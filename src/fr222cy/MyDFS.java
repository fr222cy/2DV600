/**
 * 
 */
package fr222cy;


import java.util.ArrayList;
import java.util.Arrays;
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

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
		List<Node<E>> nodeList = new ArrayList<Node<E>>();
		 root = graph.getNodeFor(root.item());

		return dfs(nodeList, root);
	}
	
	private List<Node<E>> dfs(List<Node<E>> nodeList, Node<E> node){
		Iterator<Node<E>> successors = node.succsOf();
		node.num = nodeList.size();
		nodeList.add(node);
		
		while(successors.hasNext()){
			Node<E> next = successors.next();
			if(!nodeList.contains(next)){
				dfs(nodeList,next);
			}
		}
		return nodeList;
	}
		
	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph) {
		List<Node<E>> nodeList = new ArrayList<Node<E>>();
		
		Iterator<Node<E>> heads = graph.heads();
		
		while(heads.hasNext()){
			nodeList = dfs(nodeList,heads.next());
		}
		return nodeList;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
		ArrayList<Node<E>> poList = new ArrayList<>();
		ArrayList<Node<E>> visitedNodes = new ArrayList<>();
		root = g.getNodeFor(root.item());
		return postOrder(poList,visitedNodes, root);
	}
	
	private List<Node<E>> postOrder(List<Node<E>> poList, List<Node<E>> vistedNodes, Node<E> node){
		
		if(!vistedNodes.contains(node)){
			Iterator<Node<E>> successors = node.succsOf();
			vistedNodes.add(node);
			while(successors.hasNext()){
				Node<E> next = successors.next();
				if(!poList.contains(next)){
					postOrder(poList,vistedNodes,next);
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
		ArrayList<Node<E>> visitedNodes = new ArrayList<>();
		Iterator<Node<E>> heads = g.heads();
		
		while(heads.hasNext()){
			poList = postOrder(poList, visitedNodes, heads.next());
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
