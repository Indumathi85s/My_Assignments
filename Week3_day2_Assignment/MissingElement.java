package week2.day2;

import java.util.Set;
import java.util.TreeSet;

public class MissingElement {

	public static void main(String[] args) {
		int count=1;
		Set<Integer> a = new TreeSet<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(7);
		a.add(6);
		a.add(8);
		System.out.println("A = "+a);
		for (Integer sum : a) {
			if(sum != count) {
				System.out.println("The missing element = "+count);
				count++;
			}
			count++;
		}
	}

}
