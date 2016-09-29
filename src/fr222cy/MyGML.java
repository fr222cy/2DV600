/**
 * 
 */
package fr222cy;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.spi.IIOServiceProvider;

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
	Map<Node<E>,Integer> map = new HashMap<>();
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
			map.put(node, identifier);
			identifier++;
		}
		identifier = 0;
		
		for(E item : graph.allItems()){
			Node<E> node = graph.getNodeFor(item);
			Iterator<Node<E>> successors = node.succsOf();
			
			while(successors.hasNext()){
				
				gml+= "\n\tedge\n\t[\n";
				gml+= "\t\tsource " + identifier + " \n\t\ttarget " + map.get(successors.next()) + "\n\t]";
			
			}			
			identifier++;
		}
		gml+="\n]";
		
		return gml;
	}

}
