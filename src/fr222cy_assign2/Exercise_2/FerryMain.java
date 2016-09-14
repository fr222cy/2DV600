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
		
		ferry.embark(new Car(4));
		ferry.embark(new Car(3));
		ferry.embark(new Car(4));
		ferry.embark(new Car(0));
		ferry.embark(new Car(4));
		ferry.embark(new Bicycle());
		ferry.embark(new Bicycle());
		ferry.embark(new Lorry(2));
		ferry.embark(new Bus(20));
		
		
			
			
			
			
		
		System.out.println(ferry.toString());
		

	}

}
