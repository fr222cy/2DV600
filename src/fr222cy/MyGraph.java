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
import fr222cy_assign3.graphs.test.GraphGenerator;

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
	/*
	 * Method: addNodeFor
	 * Returns Node<E>
	 * If the map does not contain the item->
	 * Creates a new MyNode-object.
	 * Set the object as tail and head.
	 * Add the object to the map(item as key, node as value).
	 * Returns the node.
	 */
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
		return new ArrayList<Node<E>>(graph.values()).iterator();
	}
	
	@Override
	public Iterator<Node<E>> heads() {
		return heads.iterator();
	}

	@Override
	public int headCount() {
		return  heads.size();
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
	
	/*
	 * Method: removeNodeFor
	 * Void
	 * Retrieves the node from the item sent in.
	 * Removes the node from heads or tails if that is the case.
	 * Cycle through each node and see if that node has the nodeToBeRemoved as pred or succs.
	 * If that is the case remove it and mark the node as head or tail depending on the situation.
	 * Then disconnect the node from all other nodes.
	 * Returns true if there was a match -> otherwise false.
	 */
	@Override
	public void removeNodeFor(E item) {
		if(item == null || graph.get(item) == null){
			throw new RuntimeException("Recieved null as input");
		}
		
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
				
				if(node.isHead()){
					heads.add(node);
				}	
			}
			if(node.hasSucc(nodeToBeRemoved)){
				node.removeSucc(nodeToBeRemoved);
				
				if(node.isTail()){
					tails.add(node);	
				}
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
	/*
	 * Method: removeEdgeFor
	 * Return: Boolean
	 * Retrieves the node from the item sent in.
	 * If there is an edge between from and to -> retrieves the nodes.
	 * Remove the Successor from the "FROM" node.
	 * Remove the Predecessor from the "TO" node.
	 * If the nodes now are head or tail in the graph -> add it to the lists.
	 */
	@Override
	public boolean removeEdgeFor(E from, E to) {
		if(from == null || to == null){
			throw new RuntimeException("Recieved null as input");
		}
		
		if(containsEdgeFor(from, to)){
			MyNode<E> nodeFrom = graph.get(from);
			MyNode<E> nodeTo = graph.get(to);
			nodeFrom.removeSucc(nodeTo);
			nodeTo.removePred(nodeFrom);
			
			if(nodeFrom.isTail()){
				tails.add(nodeFrom);
			}
			if(nodeFrom.isHead()){
				heads.add(nodeFrom);
			}
			if(nodeTo.isTail()){
				tails.add(nodeTo);
			}
			if(nodeTo.isHead()){
				heads.add(nodeTo);
			}
			return true;
		}
		return false;
	}
	@Override
	public String toString(){
		String content = "";
		content+= "GRAPH CONTENT\n\n";
		content+= "NODES\n";
		content+="-------\n";
		for(MyNode<E> node : graph.values()){
			content+=  node + "\n";	
			content+= "---\n";	
		}
		content+= "EDGES\n";
		content+="-------\n";
		for(MyNode<E> node : graph.values()){
			Iterator<Node<E>> iterator = node.predsOf();
			content+= "["+node+"]"+"Predecessors :";	
			while(iterator.hasNext()){
				content+= "["+iterator.next()+"]";
			}
			content+="\n";
			
			Iterator<Node<E>> iterator2 = node.succsOf();
			content+= "["+node+"]"+"Successors :";	
			while(iterator2.hasNext()){
				content+= "["+iterator2.next()+"]";
			}
			content+="\n";
			
			content+= "---\n";	
		}
		return content;
	}

}
