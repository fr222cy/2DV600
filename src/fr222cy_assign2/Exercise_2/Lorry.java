package fr222cy_assign2.Exercise_2;

public class Lorry extends Vehicle{
	private final int MAX_PASSENGERS = 2;
	
	public Lorry(int numOfPassengers) throws IndexOutOfBoundsException{
		
		if(numOfPassengers > MAX_PASSENGERS || numOfPassengers < 1){
			throw new IndexOutOfBoundsException("Max Passengers for Lorry:"+MAX_PASSENGERS +"  Min is: 1");
		}
		
		this.setCost(300);
		this.setSpace(8);
		this.setCostPerPassenger(15);
		this.setNumOfPassengers(numOfPassengers);
	}
	@Override
	protected String VehicleInfo() {
		return "Vehicle Type: Lorry|" +"Passengers: "+getNumberOfPassengers() ;
	}

}
