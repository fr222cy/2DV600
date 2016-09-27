/**
 * 
 */
package fr222cy;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.management.RuntimeErrorException;

import fr222cy_assign3.graphs.DirectedGraph;
import fr222cy_assign3.graphs.Node;

/**
 * @author Filip Rydberg
 *
 */
public class MyGraph<E> implements DirectedGraph<E> {
	private Map<E,MyNode<E>> graph = new HashMap<E, MyNode<E>>();
	private Set<Node<E>> heads = new TreeSet<Node<E>>();
	private Set<Node<E>> tails = new TreeSet<Node<E>>();

	public MyGraph() {
		
	}
	
	@Override
	public Node<E> addNodeFor(E item) {
		if(item != null){
			if(!graph.containsKey(item)){
				MyNode<E> newNode = new MyNode<E>(item);
				
				tails.add(newNode);
				heads.add(newNode);
				
				return graph.put(item, newNode);
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
			return graph.get(item);
		}
		else{
			throw new NullPointerException(item + " could not be found.");
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
			return true;
		}
	}

	@Override
	public boolean containsNodeFor(E item) {
		return graph.get(item) != null;
	}

	@Override
	public int nodeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Node<E>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Node<E>> heads() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int headCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Node<E>> tails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int tailCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<E> allItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int edgeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeNodeFor(E item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsEdgeFor(E from, E to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdgeFor(E from, E to) {
		// TODO Auto-generated method stub
		return false;
	}

}
