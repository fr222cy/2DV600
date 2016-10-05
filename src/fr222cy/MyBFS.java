/**
 * 
 */
package fr222cy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


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
		HashSet<Node<E>>  visited = new HashSet<>();
		List<Node<E>> list = new ArrayList<Node<E>>();
		set.add(root);
		
		return bfsRecursive(set, list, visited);
	}
	
	private List<Node<E>> bfsRecursive(HashSet<Node<E>>set, List<Node<E>> list, HashSet<Node<E>> visited){
			
			Iterator<Node<E>> setIterator = set.iterator();
			set = new HashSet<>();
			
			while(setIterator.hasNext()){
				Node<E> node = setIterator.next();
				
				if(!visited.contains(node)){
					node.num = list.size() + 1;
					visited.add(node);
					list.add(node);
				}
				Iterator<Node<E>> successorIt = node.succsOf();			
				while(successorIt.hasNext()){
					Node<E> successor = successorIt.next();
					if(!visited.contains(successor)){
						set.add(successor);
					}
				}		
			}
	
		if(!set.isEmpty()){
			bfsRecursive(set, list,visited);
		}
		return list;
	}

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph) {
		List<Node<E>> list = new ArrayList<Node<E>>();
		HashSet<Node<E>>  set;
		HashSet<Node<E>>  visited = new HashSet<>();
		Iterator<Node<E>> heads = graph.heads();
		
		if(graph.headCount() != 0){
			while(heads.hasNext()){
				set = new HashSet<>();
				set.add(heads.next());
				list = bfsRecursive(set, list,visited);
			}
		}
		else{
			set = new HashSet<>();
			set.add(graph.getNodeFor(graph.allItems().get(0)));
			list = bfsRecursive(set, list,visited);
		}

		return list;
	}

}
