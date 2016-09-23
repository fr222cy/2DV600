/**
 * @author Filip Rydberg
 *
 */
package fr222cy_assign2.Exercise_2;

public class Passenger {
	private int _cost;
	public Passenger(int cost){
		_cost = cost;
	}
	
	public Passenger(){
		_cost = 20;
	}
	
	public int getCost(){
		return _cost;
	}
	
}
