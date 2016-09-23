/**
 * @author Filip Rydberg
 *
 */
package fr222cy_assign2.Exercise_2;

public class FerryMain {
	
	public static void main(String[] args) {
		
		Ferry ferry = new Ferry();
		/*
		 * Demonstrating the functionality of embark(),countPassangers(),countVehicleSpace() and countMoney().
		 */
		System.out.println("'Embarking 2 Bicycles and 2 full Cars, Lorries and Busses.'");
		System.out.println();
		
		for(int i = 0; i <2 ; i++){
			ferry.embark(new Bicycle());
			ferry.embark(new Car(4));
			ferry.embark(new Lorry(2));
			ferry.embark(new Bus(20));
		}
		
		System.out.println("ferry.countPassengers()|Expected:54|Response:"+ferry.countPassengers());
		System.out.println("ferry.countVehicleSpace()|Expected:26|Response:"+ferry.countVehicleSpace());
		System.out.println("ferry.countMoney()|Expected:2010|Response:"+ferry.countMoney());
		System.out.println();
		
		/*
		 * Using the same data as above -> add a new Car with two passengers and a 
		 * passengers without vehicle. Demonstrating that passengers, vehicleSpace and totalMoney
		 * has increased.
		 */
		System.out.println("'Adding one more car with 2 passengers (ferry.embark(new Car(2).\n"
				+ "And a new passenger without Vehicle (ferry.embark(new Passenger()).'");
		System.out.println();
		ferry.embark(new Car(2));
		ferry.embark(new Passenger());
		System.out.println("ferry.countPassengers()|Expected:57|Response:"+ferry.countPassengers());
		System.out.println("ferry.countVehicleSpace()|Expected:27|Response:"+ferry.countVehicleSpace());
		System.out.println("ferry.countMoney()|Expected:2010|Response:"+ferry.countMoney());
		System.out.println();
		System.out.println("'Disembark all vehicles and passengers'|ferry.disembark()");
		ferry.disembark();
		
		/*
		 * The ferry is now disembarked, which should result in that there are no passengers and
		 * vehicles left on the ferry. The money however, should be remained.
		 */
		
		System.out.println("ferry.countPassengers()|Expected:0|Response:"+ferry.countPassengers());
		System.out.println("ferry.countVehicleSpace()|Expected:0|Response:"+ferry.countVehicleSpace());
		System.out.println("ferry.countMoney()|Expected:2010|Response:"+ferry.countMoney());
		System.out.println();
		System.out.println();
		
		/*
		 * Demonstrating three scenarios when embarking the ferry (NOTE: The console will be spammed with vehicles.)
		 * To ensure that there are no bugs.
		 */
		
		//Scenario 1 (11 Busses(20))
		System.out.println("Try to add 11 busses with 20 passengers each.\n"
				+ "Should only add 10 busses and 200 passengers");
		System.out.println();
		for(int i = 0; i < 11; i++){
			ferry.embark(new Bus(20));
		}
		System.out.println("Printing Ferry Status.. ferry.ToString() -> ");	
		System.out.println(ferry.toString());
		
		System.out.println("'Disembark all vehicles and passengers'|ferry.disembark()");
		ferry.disembark();

		System.out.println();
		System.out.println();
		
		//Scenario 2 (1 Car(4) and fill with Bicycles)
		System.out.println("Try to add 1 full car and then fill the ferry up with bicycles.\n"
				+ "Should be 197 Vehicles and 200 passengers");
		System.out.println();
		ferry.embark(new Car(4));
		
		for(int i = 0; i < 200; i++){
			ferry.embark(new Bicycle());
		}
	
		System.out.println("Printing Ferry Status.. ferry.ToString() -> ");	
		System.out.println(ferry.toString());
		System.out.println();
		System.out.println();
		
		
		System.out.println("'Disembark all vehicles and passengers'|ferry.disembark()");
		ferry.disembark();
		
		//Scenario 3 (39 Cars(4) 1 bicycle then a Car(4))
		System.out.println("Add 39 full cars. Then a bicycle, then a full car.\n"
				+"Should only add 39 cars and a bicycle");
		
		for(int i = 0; i< 39; i++){
			ferry.embark(new Car(4));
		}
		ferry.embark(new Bicycle());
		ferry.embark(new Car(4));
		
		System.out.println(ferry.toString());
		ferry.disembark();
		//Scenario 4 200 Bicycles
				System.out.println("Adds 200 bicycles\n"
								+"Should add 200 bicyles");
				
				for(int i = 0; i< 200; i++){
					ferry.embark(new Bicycle());
				}
				
				System.out.println(ferry.toString());
	}
	
	

}
