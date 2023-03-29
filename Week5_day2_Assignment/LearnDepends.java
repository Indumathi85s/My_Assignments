package week5.day2;


import org.testng.annotations.Test;

public class LearnDepends {
	@Test(priority = -1)
	public void create() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Create");
	}
	
	@Test(priority = 1)
	public void edit() {
		System.out.println("Edit");
	}
	
	@Test(dependsOnMethods = {"merge"})
	public void duplicate() {
		System.out.println("Duplicate");
	}
	@Test
	public void merge() throws Exception {
		System.out.println("Merge");
		throw new Exception();
	}
}
