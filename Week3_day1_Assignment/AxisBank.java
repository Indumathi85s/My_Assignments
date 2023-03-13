package week2.day1;

public class AxisBank extends BankInfo {
	
	public void deposit() {
		System.out.println("deposit() method has been OverRidden from class BankInfo to class AxisBank");
	}

	public static void main(String[] args) {
		AxisBank a = new AxisBank();
		a.fixed();
		a.saving();
		a.deposit();
		
	}

}
