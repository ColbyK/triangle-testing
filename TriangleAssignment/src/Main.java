// Colby Kuhnel
// COSC 4353

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Assert;

public class Main {
	public static void main(String[] args) {
		// Do manual input for side triangle
		// 		For false input coverage
		// 			Enter an invalid triangle choice
		// 			Enter an invalid double entry
		Triangle tri = specifiedTriangle();
		tri.printTypes();
		// Do manual input for point triangle
		Triangle tri2 = specifiedTriangle();
		tri2.printTypes();
		// Create negative side
		Assert.assertTrue(Arrays.equals(sideTriangle(-2, 2, 4).getResults(), getBools(false, 	false, 		false, 		false)));
		// Create invalid side triangle
		Assert.assertTrue(Arrays.equals(sideTriangle(2, 2, 4).getResults(), getBools(false, 	false, 		false, 		false)));
		// Create invalid point triangle
		Assert.assertTrue(Arrays.equals(pointTriangle(0, 0, 2, 0, 4, 0).getResults(), getBools(false, 		false, 		false, 		false)));
		// Assertions for other test coverage
		// 		Side Triangles														Equilateral / Isosceles / Scalene / Right
		Assert.assertTrue(Arrays.equals(sideTriangle(5, 6, 7).getResults(), getBools(false, 	false, 		true, 		false)));
		Assert.assertTrue(Arrays.equals(sideTriangle(3, 4, 5).getResults(), getBools(false, 	false, 		true, 		true)));
		Assert.assertTrue(Arrays.equals(sideTriangle(8, 8, 8).getResults(), getBools(true,	 	false, 		false, 		false)));
		Assert.assertTrue(Arrays.equals(sideTriangle(3, 3, 5).getResults(), getBools(false, 	true, 		false, 		false)));
		// 		Point Triangles																	Equilateral / Isosceles / Scalene / Right
		Assert.assertTrue(Arrays.equals(pointTriangle(0, 0, 3, 0, 3, 4).getResults(), getBools(false, 		false, 		true, 		true)));
		Assert.assertTrue(Arrays.equals(pointTriangle(0, 0, 3, 0, 0, 3).getResults(), getBools(false, 		true, 		false, 		false)));
		Assert.assertTrue(Arrays.equals(pointTriangle(0, 0, 3, 0, 0, 3).getResults(), getBools(false, 		true, 		false, 		false)));
		// Other actions
		Triangle tri3 = new Triangle(0, 0, 3, 0, 3, 4);
		Assert.assertTrue(Arrays.equals(tri3.getResults(), getBools(false, 		false, 		true, 		true)));
		Assert.assertEquals(tri3.getArea(), 3*4/2, 0.0001);
		Assert.assertEquals(tri3.getPointA().getXPos(), 0, 0.0001);
		Assert.assertEquals(tri3.getPointA().getYPos(), 0, 0.0001);
		Assert.assertEquals(tri3.getPointB().getXPos(), 3, 0.0001);
		Assert.assertEquals(tri3.getPointB().getYPos(), 0, 0.0001);
		Assert.assertEquals(tri3.getPointC().getXPos(), 3, 0.0001);
		Assert.assertEquals(tri3.getPointC().getYPos(), 4, 0.0001);
		Triangle tri4 = new Triangle(3,4,5);
		Assert.assertEquals(tri4.getSide1(), 3, 0.0001);
		Assert.assertEquals(tri4.getSide2(), 4, 0.0001);
		Assert.assertEquals(tri4.getSide3(), 5, 0.0001);
		// Invalid action coverage
		tri4.setPoints(0, 0, 0, 1, 1, 0);
		tri3.setSides(0, 1, 2);
	}
	// Reads and returns a double value from console with notif prompt
	public static double getDoubleInput(String notif) {
		Scanner input = new Scanner(System.in);
		boolean isValidInput = false;
		double value = 0;
		while(!isValidInput) {
			System.out.println(notif);
			try {
				value = input.nextDouble();
				isValidInput = true;
			}
			catch(Exception e){
				System.err.println("Invalid decimal value");
				input.nextLine();
			}
		}
		return value;
	}
	// Reads the selection for a triangle to be made
	public static Triangle specifiedTriangle() {
		Scanner input = new Scanner(System.in);
		boolean isValidInput = false;
		String inputStr;
		while(!isValidInput) {
			System.out.println("Specify the triangle to build with:\n1 - sides\n2 - points\nnum ->");
			inputStr = input.nextLine();
			if(inputStr.trim().equals("1")) {
				return sideTriangleInput();
			}
			if(inputStr.trim().equals("2")) {
				return pointTriangleInput();
			}
			System.err.println("Invalid input - enter a valid number");
		}
		return null;
	}
	// Create triangle with side input
	public static Triangle sideTriangleInput() {
		double side1 = getDoubleInput("Enter Side 1 of Triangle ->");
		double side2 = getDoubleInput("Enter Side 2 of Triangle ->");
		double side3 = getDoubleInput("Enter Side 3 of Triangle ->");
		
		return new Triangle(side1, side2, side3);
	}
	// Create triangle with point input
	public static Triangle pointTriangleInput() {
		double xP1 = getDoubleInput("Enter X Position of Point A of Triangle ->");
		double yP1 = getDoubleInput("Enter Y Position of Point A of Triangle ->");
		double xP2 = getDoubleInput("Enter X Position of Point B of Triangle ->");
		double yP2 = getDoubleInput("Enter Y Position of Point B of Triangle ->");
		double xP3 = getDoubleInput("Enter X Position of Point C of Triangle ->");
		double yP3 = getDoubleInput("Enter Y Position of Point C of Triangle ->");
		
		return new Triangle(xP1, yP1, xP2, yP2, xP3, yP3);
	}
	///////////////////////////////////////
	///////////////// HW6 /////////////////
	///////////////////////////////////////
	// Create side triangle with manual input (for testing)
	public static Triangle sideTriangle(double side1, double side2, double side3) {
		return new Triangle(side1, side2, side3);
	}
	// Create point triangle with manual input (for testing)
	public static Triangle pointTriangle(double xP1, double yP1, double xP2, double yP2, double xP3, double yP3) {
		return new Triangle(xP1, yP1, xP2, yP2, xP3, yP3);
	}
	// Gets boolean array for inputs
	public static boolean[] getBools(boolean equilateral, boolean isosceles, boolean scalene, boolean right) {
		return new boolean[] {equilateral, isosceles, scalene, right};
	}
}
