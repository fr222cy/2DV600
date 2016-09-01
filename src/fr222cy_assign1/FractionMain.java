/**
 * 
 */
package fr222cy_assign1;

/**
 * @author Filip Rydberg
 *
 */
public class FractionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Fraction f1 = new Fraction(1,1);
		Fraction f2 = new Fraction(1,2);
		Fraction f3 = new Fraction(1,3);
		Fraction testEqual = new Fraction(1,2);
		Fraction testEqual2 = new Fraction(1,2);
		
		System.out.println("Fractions");
		System.out.println("Fraction 1(f1) = "+f1.toString());
		System.out.println("Fraction 2(f2) = "+f2.toString());
		System.out.println("Fraction 3(f3) = "+f3.toString());
		
		
		System.out.println("-----");
		System.out.println("Method: String getNumerator()");
		System.out.println("Line Executed:f2.getNumerator()");
		System.out.println("Response: " + f2.getNumerator());
		
		System.out.println("-----");
		System.out.println("Method: String getDenominator()");
		System.out.println("Line Executed:f2.getDenominator()");
		System.out.println("Response: " + f2.getDenominator());
		
		System.out.println("-----");
		System.out.println("Method: boolean isNegative(Fraction)");
		System.out.println("Line Executed:f2.subtract(f1).isNegative()");
		System.out.println("Response: " + f2.subtract(f1).isNegative());
		
		System.out.println("-----");
		System.out.println("Method: Fraction add(Fraction)");
		System.out.println("Line Executed:f2.add(f1)");
		System.out.println("Response: " + f2.add(f1));
		

		System.out.println("-----");
		System.out.println("Method: Fraction subtract(Fraction)");
		System.out.println("Line Executed:f1.subtract(f2)");
		System.out.println("Response: " + f1.subtract(f2));
		
		System.out.println("-----");
		System.out.println("Method: Fraction multiply(Fraction)");
		System.out.println("Line Executed:f1.multiply(f3)");
		System.out.println("Response: " + f1.multiply(f3));
		
		System.out.println("-----");
		System.out.println("Method: Fraction divide(Fraction)");
		System.out.println("Line Executed:f1.divide(f3)");
		System.out.println("Response: " + f2.divide(f3));
		
		System.out.println("-----");
		System.out.println("Method: boolean isEqualTo(Fraction)");
		System.out.println("1.Line Executed:f2.isEqualTo(f3)");
		System.out.println("1.Response: " + f2.isEqualTo(f3));
		System.out.println("2.Line Executed:testEqual.isEqualTo(testEqual2)");
		System.out.println("2.Response: " + testEqual.isEqualTo(testEqual2));
		
	}

}
