/**
 * @author Filip Rydberg
 *
 */
package fr222cy_assign2.Exercise_2;

public class Bus extends Vehicle{
	private final int MAX_PASSENGERS = 20;
	
	public Bus(int numOfPassengers) throws IndexOutOfBoundsException{
		
		if(numOfPassengers > MAX_PASSENGERS || numOfPassengers < 1){
			throw new IndexOutOfBoundsException("Max Passengers for Bus:"+MAX_PASSENGERS +"  Min is: 1");
		}
		
		this.setCost(200);
		this.setSpace(4);
		this.setCostPerPassenger(10);
		this.setNumOfPassengers(numOfPassengers);
	}
	@Override
	protected String VehicleInfo() {
		return "Vehicle Type: Bus|" +"Passengers: "+getNumberOfPassengers() ;
	}
	
	
}
