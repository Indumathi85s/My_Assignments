package week1.day2;
import java.util.Arrays;
public class MissingElement {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		int c = 0;
		int n=arr.length;

		for (int i = arr[0]; i <= arr[n - 1]; i++)
		{

			if (arr[c] == i)
			{
				c++;
			}
			else
			{
				System.out.println("The missing number is "+i);
				break;
			}
		}
	}

}


