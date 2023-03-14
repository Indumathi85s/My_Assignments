package week2.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PrintDuplicate {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(14);
		a.add(12);
		a.add(13);
		a.add(11);
		a.add(15);
		a.add(14);
		a.add(18);
		a.add(16);
		a.add(17);
		a.add(19);
		a.add(18);
		a.add(17);
		a.add(20);
		System.out.println("A = "+a);
		Collections.sort(a);
		System.out.println("The sorted list ");
		System.out.println(a);
		System.out.println("The duplicate Numbers ");
		for (int i = 0; i < a.size(); i++) {
			for (int j = i+1; j < a.size(); j++) {
				if(a.get(i) == a.get(j)) {
					System.out.print(" "+a.get(i));
				}
			}

		}

	}

}
