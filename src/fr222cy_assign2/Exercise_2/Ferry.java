/**
 * @author Filip Rydberg
 *
 */
package fr222cy_assign2.Exercise_2;

import java.util.ArrayList;
import java.util.Iterator;


public class Ferry implements FerryInterface{
	ArrayList<Vehicle> _vehicles;
	ArrayList<Passenger> _passengers;
	private final int MAX_SPACE = 40;
	private final int MAX_ROOM = 200;
	private int _totalMoney = 0;
	private double _usedSpace = 0;
	private int multiplier = (int) Math.pow(10, 2);
	
	public Ferry(){
		_vehicles = new ArrayList<>();
		_passengers = new ArrayList<>();
	}
	
	@Override
	public Iterator<Vehicle> iterator() {
		return new Iterator<Vehicle>() {
			private int count = 0;
			
			public boolean hasNext(){
				return count<_vehicles.size();
			}
			public Vehicle next(){
				return _vehicles.get(count++);
			}
		};
					
	}

	@Override
	public int countPassengers() {
		return _passengers.size();
	}

	@Override
	public int countVehicleSpace() {	
		return (int)_usedSpace;
	}

	@Override
	public int countMoney() {
		return _totalMoney;
	}
	/*
	 * Embark(Vehicle)
	 * Adds the specified vehicle to the list of vehicles.
	 * Based on the vehicles size, increase usedSpace.
	 * Based on the cost of the vehicle, increase totalMoney.
	 * Embark every passenger in the vehicle.
	 */
	@Override
	public void embark(Vehicle v) {
		if(hasSpaceFor(v) && _passengers.size() + v.getNumberOfPassengers() <= MAX_ROOM){
			_vehicles.add(v);
			_usedSpace += v.getSpace();
			//http://stackoverflow.com/questions/14845937/java-how-to-set-precision-for-double-value User:justAnotherGuy
			_usedSpace= (double) ((long) (_usedSpace * multiplier)) / multiplier;
			_totalMoney += v.getCost();
						
			for(Passenger passenger: v.getPassengers()){
				embark(passenger);
			}
		}
	}

	@Override
	public void embark(Passenger p) {
		if(hasRoomFor(p)){
			_totalMoney += p.getCost();
			_passengers.add(p);
		}	
	}

	@Override
	public void disembark() {
		_vehicles.clear();
		_passengers.clear();
		_usedSpace = 0;
	}

	@Override
	public boolean hasSpaceFor(Vehicle v) {
		if(_usedSpace + v.getSpace() > MAX_SPACE 
		   || _vehicles.contains(v)){
			return false;
		}
		return true;
	}

	@Override
	public boolean hasRoomFor(Passenger p) {
		if(countPassengers() + 1 > MAX_ROOM 
		   || _passengers.contains(p)){
			return false;
		}
		return true;
	}
	/*
	 * Tostring()
	 * NOTE: Using Math.ceil only to get a more realistic summary.
	 * If there are 2 Bicycles and 39 cars it would summaries 40 instead of 39.4.
	 */
	@Override
	public String toString(){
		String text = "";
		text+="-----------------\n";
		text+="FERRY INFORMATION\n";
		text+="-----------------\n";
		text+="Vehicles Embarked: "+ _vehicles.size() +"\n";
		text+="Passengers Embarked: "+ _passengers.size() +"/"+MAX_ROOM+"\n";
		text+="Space Occupied:"+(int)Math.ceil(_usedSpace)+"/"+MAX_SPACE+ "\n"; 
		text+="Total Income: "+ _totalMoney +"\n";
		text+="-----------------\n";
		text+="Vehicle Details\n";
		text+="-----------------\n";
		Iterator<Vehicle> iterator = _vehicles.iterator();
		while (iterator.hasNext()) {
			text += iterator.next().VehicleInfo() + "\n";
		}
		return text;
	}
	

}
