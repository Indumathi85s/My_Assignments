package week2.day2;

public class ReverseString {

	public static void main(String[] args) {
		String name="indumathi";
		char[] charArray = name.toCharArray();
		for(int i=charArray.length-1;i>=0;i--) {
			System.out.println(charArray[i]);
		}
	}
}
