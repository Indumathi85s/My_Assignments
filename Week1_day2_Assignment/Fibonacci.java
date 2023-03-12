package week1.day2;

public class Fibonacci {

	public static void main(String[] args) {
		int num1 = 0, num2 = 1;

		int counter = 0;
		int n=8;


		while (counter < n) {


			System.out.print(num1 + " ");

			int sum = num2 + num1;
			num1 = num2;
			num2 = sum;
			counter = counter + 1;
		}

	}

}
