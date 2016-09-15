package fr222cy_assign2.Exercise_2;

public class Car extends Vehicle{
	private final int MAX_PASSENGERS = 4;
	
	public Car(int numOfPassengers) throws IndexOutOfBoundsException{
		
		if(numOfPassengers > MAX_PASSENGERS || numOfPassengers < 1){
			throw new IndexOutOfBoundsException("Max Passengers for Car:"+MAX_PASSENGERS +"  Min is: 1");
		}
		
		this.setCost(100);
		this.setSpace(1);
		this.setCostPerPassenger(15);
		this.setNumOfPassengers(numOfPassengers);
	}
	
	@Override
	protected String VehicleInfo() {
		return "Vehicle Type: Car|" +"Passengers: "+getNumberOfPassengers() ;
	}

}
