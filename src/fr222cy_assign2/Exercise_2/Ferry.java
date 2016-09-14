package fr222cy_assign2.Exercise_2;

import java.util.ArrayList;
import java.util.Iterator;


public class Ferry implements FerryInterface{
	ArrayList<Vehicle> _vehicles;
	ArrayList<Passenger> _passengers;
	private final int MAX_SPACE = 40;
	private final int MAX_ROOM = 200;
	private int _totalMoney = 0;
	
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
		float sum = 0;
		for(Vehicle v: _vehicles){
			sum += v.getSpace();
		}
		return Math.round(sum);
	}

	@Override
	public int countMoney() {
		return _totalMoney;
	}

	@Override
	public void embark(Vehicle v) {
		if(hasSpaceFor(v) && _passengers.size() + v.getNumberOfPassengers() <= MAX_ROOM){
			_vehicles.add(v);
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
	}

	@Override
	public boolean hasSpaceFor(Vehicle v) {
		if(countVehicleSpace() + v.getSpace() > MAX_SPACE 
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
	
	@Override
	public String toString(){
		String text = "";
		text+="-----------------\n";
		text+="FERRY INFORMATION\n";
		text+="-----------------\n";
		text+="Vehicles Embarked: "+ _vehicles.size() +"\n";
		text+="Passengers Embarked: "+ _passengers.size() +"/"+MAX_ROOM+"\n";
		text+="Space Occupied:"+countVehicleSpace()+"/"+MAX_SPACE+ "\n";
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
