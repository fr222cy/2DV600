/**
 * 
 */
package fr222cy;

import java.awt.event.ItemEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import fr222cy_assign3.graphs.DFS;
import fr222cy_assign3.graphs.DirectedGraph;
import fr222cy_assign3.graphs.Node;
import fr222cy_assign3.graphs.TransitiveClosure;

/**
 * @author Filip Rydberg
 *
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E>{

	@Override
	public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
		Map<Node<E>, Collection<Node<E>>> map = new HashMap<>();
		Iterator<Node<E>> iterator = dg.iterator();
		MyDFS<E> dfs = new MyDFS<E>();
		while(iterator.hasNext()){
			Node<E> node = iterator.next();
			List<Node<E>> list =  dfs.dfs(dg, node);
			map.put(node, list);
		}
		
	
		return map;
	}
}
