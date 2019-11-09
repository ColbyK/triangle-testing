// Colby Kuhnel
// COSC 4353

// Class for valid triangle creation
public class Triangle {
	private double side1;
	private double side2;
	private double side3;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private boolean valid;
	private TriangleType type;
	enum TriangleType{
		None,
		Side,
		Point
	}
	// Basic Triangle initialization
	public Triangle() {
		valid = false;
		type = TriangleType.None;
	}
	// Triangle information with side lengths specified
	public Triangle(double s1, double s2, double s3) {
		this();
		setSides(s1, s2, s3);
	}
	// Triangle information with point positions specified
	public Triangle(double xP1, double yP1, double xP2, double yP2, double xP3, double yP3) {
		this();
		setPoints(xP1, yP1, xP2, yP2, xP3, yP3);
	}
	// Validates and assigns sides to a new or existing 'Side' triangle. 'Point' triangles are not allowed to have sides be modified
	public void setSides(double s1, double s2, double s3) {
		if(type != TriangleType.Point) {
			setSidesValidate(s1, s2, s3);
			if(valid) {
				type = TriangleType.Side;
			}
		}
		else {
			System.err.println("Invalid action - cannot set sides when triangle points are defined");
		}
	}
	// Private usage of triangle validation 
	private void setSidesValidate(double s1, double s2, double s3) {
		if(s1 <= 0 || s2 <= 0 || s3 <= 0) {
			System.err.println("Invalid triangle - Negative values not allowed");
			valid = false;
		}
		else if(s1 + s2 <= s3 || s2 + s3 <= s1 || s1 + s3 <= s2) {
			System.err.println("Invalid triangle - Two sides must be greater than the third");
			valid = false;
		}
		else {
			side1 = s1;
			side2 = s2;
			side3 = s3;
			valid = true;
		}
	}
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	// Checks if the triangle is Equilateral. If triangle is not valid return false
	public boolean isEquilateral() {
		if(valid) {
			return (side1 == side2 && side2 == side3);
		}
		return false;
	}
	// Checks if the triangle is Isosceles. If triangle is not valid return false
	public boolean isIsosceles() {
		if(valid) {
			return 	(side1 == side2 && side2 != side3)||
					(side2 == side3 && side2 != side1)||
					(side1 == side3 && side3 != side2);
		}
		return false;
	}
	// Checks if the triangle is Scalene. If triangle is not valid return false
	public boolean isScalene() {
		if(valid) {
			return (side1 != side2 && side2 != side3 && side1 != side3);
		}
		return false;
	}
	// Checks if the triangle is Right. If triangle is not valid return false
	public boolean isRight() {
		if(valid) {
			return  (side1*side1 + side2*side2 == side3*side3)||
					(side2*side2 + side3*side3 == side1*side1)||
					(side1*side1 + side3*side3 == side2*side2);
		}
		return false;
	}
	public void printTypes() {
		System.out.println("Equilateral - " + isEquilateral());
		System.out.println("Isosceles - " + isIsosceles());
		System.out.println("Scalene - " + isScalene());
		System.out.println("Right - " + isRight());
	}
	///////////////////////////////////////
	///////////////// HW2 /////////////////
	///////////////////////////////////////
	// Gets the area of a triangle using sides
	public double getArea() {
		double sp = (side1 + side2 + side3)/2;
		return Math.sqrt(sp*(sp-side1)*(sp-side2)*(sp-side3));
	}
	public Point getPointA() {
		return pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	// Validates and assigns points to a new or existing 'Point' triangle. 'Side' triangles are not allowed to have points added
	// Also creates sides using the specified points
	public void setPoints(double xP1, double yP1, double xP2, double yP2, double xP3, double yP3) {
		if(type != TriangleType.Side) {
			double s1 = Math.sqrt(Math.pow((xP1 - xP2),2) + Math.pow((yP1 - yP2),2));
			double s2 = Math.sqrt(Math.pow((xP2 - xP3),2) + Math.pow((yP2 - yP3),2));
			double s3 = Math.sqrt(Math.pow((xP3 - xP1),2) + Math.pow((yP3 - yP1),2));
			setSidesValidate(s1, s2, s3);
			if(valid) {
				pointA = new Point(xP1, yP1);
				pointB = new Point(xP2, yP2);
				pointC = new Point(xP3, yP3);
				type = TriangleType.Point;
			}
		}
		else {
			System.out.println("Invalid action - cannot set points when triangle sides are defined");
		}
	}
	///////////////////////////////////////
	///////////////// HW6 /////////////////
	///////////////////////////////////////
	public boolean[] getResults() {
		return new boolean[] {isEquilateral(), isIsosceles(), isScalene(), isRight()};
	}
}
