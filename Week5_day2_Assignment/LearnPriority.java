package week5.day2;

import org.testng.annotations.Test;

public class LearnPriority {

	@Test(priority = -1)
	public void create() {
		System.out.println("Create");
	}
	
	@Test(priority = -3)
	public void edit() {
		System.out.println("Edit");
	}
	
	@Test(priority = 1)
	public void duplicate() {
		System.out.println("Duplicate");
	}
}
