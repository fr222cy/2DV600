/**
 * 
 */
package fr222cy;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import fr222cy_assign3.graphs.DirectedGraph;
import fr222cy_assign3.graphs.GML;
import fr222cy_assign3.graphs.Node;

/**
 * @author Filip Rydberg
 *
 */
public class MyGML<E> extends GML<E>{

	public MyGML(DirectedGraph<E> dg) {
		super(dg);
		
	}
	Map<Node<E>,Integer> map = new HashMap<>(); //Using map to store the identifier and node.
	@Override
	public String toGML() {
		String gml = "";
		int identifier = 0;
		
		gml+="graph\n[";
		
		for(E item : graph.allItems()){
			Node<E> node = graph.getNodeFor(item);
			gml+= "\n\tnode\n\t[\n";
			gml+= "\t\tid\t " + identifier + "\n";
			gml+= "\t\tlabel\t" + '"'+node+'"'+"\n\t]";	
			map.put(node, identifier);//Store the identifier as the value and the node as a key.
			identifier++;
		}
		identifier = 0;
		
		for(E item : graph.allItems()){
			Node<E> node = graph.getNodeFor(item);
			Iterator<Node<E>> successors = node.succsOf();
			
			while(successors.hasNext()){
				gml+= "\n\tedge\n\t[\n";
				gml+= "\t\tsource " + identifier + " \n\t\ttarget " + map.get(successors.next()) + "\n\t]";//map.get -> the identifier of the next node.
			}			
			identifier++;
		}
		gml+="\n]";
		
		return gml;
	}

}
