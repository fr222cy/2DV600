/**
 * 
 */
package fr222cy;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.transform.Templates;

import fr222cy_assign3.graphs.ConnectedComponents;
import fr222cy_assign3.graphs.DFS;
import fr222cy_assign3.graphs.DirectedGraph;
import fr222cy_assign3.graphs.Node;

/**
 * @author Filip Rydberg
 *
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E> {
	
	/* Method: computeComponents
	 * Returns: Collection<Collection<Node<E>>> 
	 * Iterates each node in the graph.
	 * Does a DFS on the node if it isn't visited.
	 * Iterates the collection from the DFS.
	 * If the particular node in the collection is visited -> loop through all collections to locate if the node exist in any of them.
	 * If the node is in one of the collections we add this collection to that specified collection (merge) and mark that we got a connection.
	 * If there is no connection -> just add the collection to the set of collections.
	 */
	@Override
	public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
		HashSet<Node<E>> visited = new HashSet<>(); 
		Collection<Collection<Node<E>>> setOfCollections = new HashSet<>(); 
		Collection<Node<E>> collection; 
		Collection<Node<E>> temp; 
		Iterator<Node<E>> nodeIterator = dg.iterator(); 
		boolean connection; 
		MyDFS<E> dfs = new MyDFS<>(); 
		while(nodeIterator.hasNext()){
			connection = false; 
			Node<E> current = nodeIterator.next();
			if(!visited.contains(current)){ 
				collection =  dfs.dfs(dg, current); 

				for(Node<E> node : collection){
					if(visited.contains(node)){ 
						for(Collection<Node<E>> coll : setOfCollections){
							if(coll.contains(node)){ 
								visited.addAll(collection);
								coll.addAll(collection);
								connection = true; 
							}
						}
					}	
				}

				if(!connection){ 
					visited.addAll(collection);
					temp = new HashSet<>(); 
					temp.addAll(collection); 
					setOfCollections.add(temp); 
				}
			}
		}
		return setOfCollections; 
	}

}
