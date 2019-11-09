// Colby Kuhnel
// COSC 4353

// Class for a point creation
public class Point {
	private double xPos;
	private double yPos;
	public Point(double xP, double yP) {
		setXPos(xP);
		setYPos(yP);
	}
	public void setXPos(double xP) {
		xPos = xP;
	}
	public void setYPos(double yP) {
		yPos = yP;
	}
	public double getXPos() {
		return xPos;
	}
	public double getYPos() {
		return yPos;
	}
}
