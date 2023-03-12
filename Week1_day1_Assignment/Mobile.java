package week1.assignment;

public class Mobile {
	public void makeCall() {
		String mobModel="One Plus 9R";
		float mobWeight=1.3f;
		System.out.println("Mobile Model: "+mobModel);
		System.out.println("Mobile Weight: "+mobWeight);
	}
public void sendMsg() {
	boolean IsFullyCharged;
	IsFullyCharged=true;
	int mobCost=20000;
	System.out.println("The cost of my mobile is "+mobCost);
	System.out.println("Charged : "+IsFullyCharged);
	}

	public static void main(String[] args) {
		Mobile mob=new Mobile();
		mob.makeCall();
		mob.sendMsg();
		
	}

}
