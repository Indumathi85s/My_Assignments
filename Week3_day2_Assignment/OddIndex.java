package week2.day2;

public class OddIndex {

	public static void main(String[] args) {
		String name="changeme";
		char[] charArray = name.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if(i%2 != 0) {
				char ch=name.charAt(i);
				charArray[i]=Character.toUpperCase(ch); 
			}
		}
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
		}
	}
}
