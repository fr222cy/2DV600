/**
 * 
 */
package fr222cy_assign1;

/**
 * @author Filip Rydberg
 *
 */
public class Fraction {
	
	private int _n;
	private int _d;
	
	
	public Fraction(int numerator, int denominator){
		if(denominator != 0){
			_n = numerator;
			_d = denominator;
		}
		else{
			System.out.println("Denominator can't have the value 0");
			System.exit(0);
		}
		
	}
	
	public int getNumerator(){
		return _n;
	}
	
	public int getDenominator(){
		return _d;
	}
		
	public boolean isNegative(){
		return (double)getNumerator()/(double)getDenominator() < 0;
	}
	
	public Fraction add(Fraction f){
		int newN;
		int newD;
		
		
		if(getDenominator() == f.getDenominator()){
			newN = getNumerator() + f.getNumerator();
			return new Fraction(newN,getDenominator());
		}
		else{
			newD = getDenominator() * f.getDenominator();
			newN = getNumerator() * f.getDenominator() + f.getNumerator() * getDenominator();
			return new Fraction(newN,newD);
		}
	}
	
	public Fraction subtract(Fraction f){
		int newN;
		int newD;
		
		
		if(getDenominator() == f.getDenominator()){
			newN = getNumerator() - f.getNumerator();
			return new Fraction(newN,getDenominator());
		}
		else{
			newD = getDenominator() * f.getDenominator();
			newN = getNumerator() * f.getDenominator() - f.getNumerator() * getDenominator();
			return new Fraction(newN,newD);
		}
	}
	
	public Fraction multiply(Fraction f){
		int newN;
		int newD;
		
		newN = getNumerator() * f.getNumerator();
		newD = getDenominator() * f.getDenominator();
		
		return new Fraction(newN,newD);
	}
	
	public Fraction divide(Fraction f){		
		int tempDeno = f.getDenominator();
		f._d = f.getNumerator();
		f._n = tempDeno;
				
		return this.multiply(f);
	}
	public String toString(){
		return getNumerator()+"/"+getDenominator();
	}
	
	public boolean isEqualTo(Fraction f){
		
		return (double)getNumerator()/(double)getDenominator() == (double)f.getNumerator()/(double)f.getDenominator();
	}
	
	
	
	

}
