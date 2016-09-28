/**
 * 
 */
package fr222cy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


import fr222cy_assign3.graphs.DirectedGraph;
import fr222cy_assign3.graphs.Node;

/**
 * @author Filip Rydberg
 *
 */
public class MyGraph<E> implements DirectedGraph<E> {
	private Map<E,MyNode<E>> graph;
	private Set<Node<E>> heads;
	private Set<Node<E>> tails;
	

	public MyGraph() {
		graph  = new HashMap<E, MyNode<E>>();
		heads = new HashSet<Node<E>>();
		tails = new HashSet<Node<E>>();
	
	}
	
	@Override
	public Node<E> addNodeFor(E item) {
		if(item != null){
			if(!graph.containsKey(item)){
				MyNode<E> newNode = new MyNode<E>(item);
				
				tails.add(newNode);
				heads.add(newNode);
				
				graph.put(item, newNode);
			}
			return graph.get(item);
		}
		else{
			throw new NullPointerException();
		}
	}

	@Override
	public Node<E> getNodeFor(E item) {
		if(item != null){
			if(graph.containsKey(item)){
				return graph.get(item);
			}
			throw new RuntimeException("No node was found");
		}
		else{
			throw new RuntimeException("Recieved null as input");
		}
	}

	@Override
	public boolean addEdgeFor(E from, E to) {
		if(from == null || to == null){
			throw new RuntimeException("Recieved null as input");
		}
		
		MyNode<E> src = (MyNode<E>) addNodeFor(from);
		MyNode<E> tgt = (MyNode<E>) addNodeFor(to);
		
		if(src.hasSucc(tgt)){
			return false;
		}
		else{
			src.addSucc(tgt);
			tgt.addPred(src);
			
			tails.remove(src);
			heads.remove(tgt);
		}
		return true;
	}

	@Override
	public boolean containsNodeFor(E item) {
		if(item == null){
			throw new RuntimeException("Recieved null as input");
		}
		return graph.get(item) != null;
	}

	@Override
	public int nodeCount() {
		return graph.size();
	}

	@Override
	public Iterator<Node<E>> iterator() {
		//Creates a new temporary hashmap with the node values.
		HashMap<E, Node<E>>temp  = new HashMap<E, Node<E>>();
		for(MyNode<E> node : graph.values()){
			 temp.put(node.item(), (Node<E>)node);
		}
		return temp.values().iterator();
	}
	
	@Override
	public Iterator<Node<E>> heads() {
		return heads.iterator();
	}

	@Override
	public int headCount() {
		return heads.size();
	}

	@Override
	public Iterator<Node<E>> tails() {
		return tails.iterator();
	}

	@Override
	public int tailCount() {
		return tails.size();
	}

	
	@Override
	public List<E> allItems() {
		List<E> list = new ArrayList<>();
		
		for(MyNode<E> node : graph.values()){
			list.add(node.item());
		}
		return list;
	}

	@Override
	public int edgeCount() {
		int edges = 0;
		
		for(MyNode<E> node : graph.values()){
			
				edges+=node.outDegree();
			
		}
		return edges;
	}

	@Override
	public void removeNodeFor(E item) {
		if(item == null || graph.get(item) == null){
			throw new RuntimeException("Recieved null as input");
		}
		//TODO: Something with head or tail.
		MyNode<E> nodeToBeRemoved = graph.get(item);
		if(nodeToBeRemoved.isHead()){
			heads.remove(nodeToBeRemoved);
		}
		if(nodeToBeRemoved.isTail()){
			tails.remove(nodeToBeRemoved);
		}
		for(MyNode<E> node : graph.values()){
			if(node.hasPred(nodeToBeRemoved)){
				node.removePred(nodeToBeRemoved);
			}
			if(node.hasSucc(nodeToBeRemoved)){
				node.removeSucc(nodeToBeRemoved);
			}
		}
		nodeToBeRemoved.disconnect();
		graph.remove(item);			
	}

	@Override
	public boolean containsEdgeFor(E from, E to) {
		if(from == null || to == null){
			throw new RuntimeException("Recieved null as input");
		}
		if(containsNodeFor(from) && containsNodeFor(to)){
			return graph.get(from).hasSucc(graph.get(to));
		}
		return false;
	}

	@Override
	public boolean removeEdgeFor(E from, E to) {
		if(from == null || to == null){
			throw new RuntimeException("Recieved null as input");
		}
		
		if(containsEdgeFor(from, to)){
			graph.get(from).removeSucc(graph.get(to));
			graph.get(to).removePred(graph.get(from));
			
			return true;
		}
		return false;
	}
	@Override
	public String toString(){
		return graph.toString();
	}

}
