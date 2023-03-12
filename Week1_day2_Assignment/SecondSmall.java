package week1.day2;

import java.util.Arrays;

public class SecondSmall {

	public static void main(String[] args) {
		int num[]={23,45,67,32,89,22 };
		Arrays.sort(num);
		int n=num.length;
		System.out.println("Arranging in Assending order");
		for (int i = 0; i <n ; i++) {
			System.out.println(num[i]);
		}
		System.out.println("The second smallest number is "+num[1]);

	}

}
