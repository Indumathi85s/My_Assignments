package week2.day2;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		System.out.println("Input String");
		String text="We learn java basics as part of java sessions in java week1";
		System.out.println(text);
		String[] words = text.split(" ");
		String result="";
		LinkedHashSet<String> set = new LinkedHashSet<String>(Arrays.asList(words));
		for(String word: set) {
			result = result + word + " ";
		}
		System.out.println("Sentence after removing duplicate words: " );
		System.out.println(result);
	}

}
