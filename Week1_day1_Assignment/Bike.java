package week1.assignment;

public class Bike {
	public void printBrake() {
		System.out.println("This is Bike class");
	}

	public static void main(String[] args) {
		Car c = new Car();
		Bike b = new Bike();
		c.soundHorn();
		c.applyBreak();
		b.printBrake();

	}

}
