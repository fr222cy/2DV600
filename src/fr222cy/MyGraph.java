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

	@Override
	public void removeNodeFor(E item) {
		if(item == null || graph.get(item) == null){
			throw new RuntimeException("Recieved null as input");
		}
		
		MyNode<E> nodeToBeRemoved = graph.get(item);
		if(nodeToBeRemoved.isHead()){
			System.out.println("Removed Head:"+heads.remove(nodeToBeRemoved));
		}
		if(nodeToBeRemoved.isTail()){
			System.out.println("Removed Tail:" + tails.remove(nodeToBeRemoved));
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

	@Override
	public boolean removeEdgeFor(E from, E to) {
		if(from == null || to == null){
			throw new RuntimeException("Recieved null as input");
		}
		
		if(containsEdgeFor(from, to)){
			MyNode<E> from1 = graph.get(from);
			MyNode<E> to1 = graph.get(to);
			from1.removeSucc(to1);
			to1.removePred(from1);
			
			if(from1.isTail()){
				tails.add(from1);
			}
			if(from1.isHead()){
				heads.add(from1);
			}
			if(to1.isTail()){
				tails.add(to1);
			}
			if(to1.isHead()){
				heads.add(to1);
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
