package week1.day2;

public class PrimeNumbers {

	public static void main(String[] args) {
		int value=13;
		boolean flag=false;
		for (int i = 2; i <= value/2; ++i) {
		      if (value % i == 0) {
		        flag = true;
		        break;
		      }
		    }

		    if (!flag)
		      System.out.println(value + " is a prime number.");
		    else
		      System.out.println(value + " is not a prime number.");
	}

}
