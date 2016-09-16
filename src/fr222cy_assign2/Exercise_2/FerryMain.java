/**
 * 
 */
package fr222cy_assign2.Exercise_2;

/**
 * @author Filip Rydberg
 *
 */
public class FerryMain {
	
	
	public static void main(String[] args) {
		
		Ferry ferry = new Ferry();
		
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
		System.out.println();
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
		System.out.println("ferry.countPassengers()|Expected:0|Response:"+ferry.countPassengers());
		System.out.println("ferry.countVehicleSpace()|Expected:0|Response:"+ferry.countVehicleSpace());
		System.out.println("ferry.countMoney()|Expected:2010|Response:"+ferry.countMoney());
		System.out.println();
		System.out.println();
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
		System.out.println("Add 39 full cars. Then a bicycle, then a full car.\n"
				+"Should only add 39 cars and a bicycle");
		
		for(int i = 0; i< 39; i++){
			ferry.embark(new Car(4));
		}
		ferry.embark(new Bicycle());
		ferry.embark(new Car(4));
		
		System.out.println(ferry.toString());
	}
	
	

}
