package week2.day2;

import java.util.ArrayList;

public class FindIntersection {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(3);
		a.add(2);
		a.add(11);
		a.add(4);
		a.add(6);
		a.add(7);
		System.out.println("A = "+a);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(2);
		b.add(8);
		b.add(4);
		b.add(9);
		b.add(7);
		System.out.println("B = "+b);
		
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < b.size(); j++) {
				if(a.get(i) == b.get(j)) {
					System.out.println("The Intersection : "+a.get(i));
					break;
				}
				
			}
			
		}

	}

}
