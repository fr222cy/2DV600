/**
 * 
 */
package fr222cy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageTypeSpecifier;

import fr222cy_assign3.graphs.BFS;
import fr222cy_assign3.graphs.DirectedGraph;
import fr222cy_assign3.graphs.Node;

/**
 * @author Filip Rydberg
 *
 */
public class MyBFS<E> implements BFS<E>{
	
	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
		HashSet<Node<E>>  set = new HashSet<>();
		List<Node<E>> list = new ArrayList<Node<E>>();
		set.add(root);
		
		return bfs(set, list);
	}
	
	private List<Node<E>> bfs(HashSet<Node<E>>set, List<Node<E>> list){
			
			Iterator<Node<E>> setIterator = set.iterator();
			set = new HashSet<>();
			
			while(setIterator.hasNext()){
				Node<E> node = setIterator.next();
				
				if(!list.contains(node)){
					node.num = list.size() + 1;
					list.add(node);
				}
				Iterator<Node<E>> successorIt = node.succsOf();			
				while(successorIt.hasNext()){
					Node<E> successor = successorIt.next();
					if(!list.contains(successor)){
						set.add(successor);
					}
				}		
			}
	
		if(!set.isEmpty()){
			bfs(set, list);
		}
		return list;
	}

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph) {
		List<Node<E>> list = new ArrayList<Node<E>>();
		HashSet<Node<E>>  set;
		Iterator<Node<E>> heads = graph.heads();

		while(heads.hasNext()){
			set = new HashSet<>();
			set.add(heads.next());
			list = bfs(set,list);
		}
		return list;
	}

}
