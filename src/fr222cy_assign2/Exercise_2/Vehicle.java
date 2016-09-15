package fr222cy_assign2.Exercise_2;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
	private double _space;
	private int _cost;
	private int _costPerPassenger;
	private List<Passenger> _passengersInVehicle; 
	private int _numOfPassengers;

	public Vehicle() {
		_passengersInVehicle = new ArrayList<>();
	}
	
	protected void setCost(int cost){
		_cost = cost;
	}
	
	protected void setSpace(double space){
		_space = space;
	}
	
	protected void setCostPerPassenger(int costPerPassenger){
		_costPerPassenger = costPerPassenger;
	}
	
	protected void setNumOfPassengers(int numOfPassengers) {
		_numOfPassengers = numOfPassengers;
	}
		
	protected int getCost(){
		return _cost;
	}
	
	protected double getSpace(){
		return _space;
	}
	
	protected int getCostPerPassenger(){
		return _costPerPassenger;
	}
	
	protected int getNumberOfPassengers(){
		return _numOfPassengers;
	}
	
	protected abstract String VehicleInfo();

	protected List<Passenger> getPassengers(){
		for(int i = 0; i < getNumberOfPassengers();i++){
			_passengersInVehicle.add(new Passenger(getCostPerPassenger()));
		}
		return _passengersInVehicle;
	}
	
	
	
}
