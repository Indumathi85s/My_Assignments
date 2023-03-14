package week2.day2;

import java.util.Set;
import java.util.TreeSet;

public class SecondLargest {

	public static void main(String[] args) {
		Set<Integer> a = new TreeSet<Integer>();
		a.add(3);
		a.add(2);
		a.add(11);
		a.add(4);
		a.add(6);
		a.add(7);
		System.out.println("A = "+a);
		Object[] array = a.toArray();		
		Object num=array[array.length-2];
		System.out.println("The second largest number = "+num);
	}
}
