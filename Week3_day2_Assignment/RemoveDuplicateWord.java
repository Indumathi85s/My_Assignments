package week2.day2;

public class RemoveDuplicateWord {

	public static void main(String[] args) {
		System.out.println("Input String");
		String text="We learn java basics as part of java sessions in java week1";
		System.out.println(text);
		String[] words = text.split("\\s");

		for (int i = 0; i < words.length; i++)
		{
			for (int j = 0; j < words.length; j++)
			{
				if (words[i].equals(words[j]))
				{
					if (i != j)
						words[i] = "";

				}
			}
		}

		for (int i = 0; i < words.length; i++)
		{

			if (words[i] != "")
			{
				System.out.print(words[i]+" ");

			}
		}

	}
}
