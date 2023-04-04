package week6.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Proposal extends ProjectMethod {
	
	@BeforeTest
	public void setup() {
		excelfile="Proposal";
	}

	@Test(dataProvider = "fetchData")
	public void proposal(String desc) throws InterruptedException {
		

		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
		shadow.setImplicitWait(10);
		filter.click();
		filter.sendKeys("My Proposal");
		shadow.findElementByXPath("//mark[text()='My Proposal']").click();
		Thread.sleep(3000);
		WebElement eleFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(desc);
		Thread.sleep(10);
		driver.findElement(By.xpath("//span[@class='ui_action_container_primary']//button[text()='Submit']")).click();
	}

}
