/**
 * 
 */
package fr222cy_assign1;

/**
 * @author Filip Rydberg
 *
 */
public class Point {

	private int _x;
	private int _y;
	
	public static void main(String[] args) {
		
		Point p1 = new Point();
		Point p2 = new Point(3,4);
				
		System.out.println(p1.toString());   // ==> (0,0)
		System.out.println(p2.toString());   // ==> (3,4)
				
		if (p1.isEqualTo(p2))              // False!
			System.out.println("The two points are equal");
				
		double dist = p1.distanceTo(p2);
		System.out.println("Point Distance: "+dist);
				
		p2.move(5,-2);         // ==> (8,2)
		p1.moveToXY(8,2);      // ==> (8,2)
				
		if (p1.isEqualTo(p2))              // True!
			System.out.println("The two points are equal");
		
	}
	
	public Point(int x,int y){
		_x = x;
		_y = y;
	}
	public Point(){
		_x = 0;
		_y = 0;
	}
	
	public String toString(){
		return "==> ("+_x+","+_y+")";
	}
	
	public boolean isEqualTo(Point p){
		
		if(_x == p._x && _y == p._y){
		return true;
		}
		return false;
	}
	
	public double distanceTo(Point p){
		return Math.sqrt(Math.pow((p._x-_x),2) + Math.pow((p._y-_y),2));
	}
	
	public void move(int amountX,int amountY){
		_x += amountX;
		_y += amountY;
	}
	
	public void moveToXY(int newX,int newY){
		_x = newX;
		_y = newY;
	}
	
}
