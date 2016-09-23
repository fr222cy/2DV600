/**
 * @author Filip Rydberg
 *
 */
package fr222cy_assign2.Exercise_2;

public class Bicycle extends Vehicle{
	
	public Bicycle(){
		this.setCost(40);
		this.setSpace((double) 0.2);
		this.setNumOfPassengers(1);
	}
	@Override
	protected String VehicleInfo() {
		return "Vehicle Type: Bicycle";
	}
}
