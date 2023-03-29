package week5.day2;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LearnInvocation {
	@Test(invocationCount = 3,invocationTimeOut = 2000, threadPoolSize = 2)
	public void create() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Create");
	}
	
	@Test(invocationCount = 2,invocationTimeOut = 1000, threadPoolSize = 2)
	public void edit() {
		System.out.println("Edit");
	}
	
	@Test
	@Ignore
	public void duplicate() {
		System.out.println("Duplicate");
	}
}
