package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Knowledge extends ProjectMethod {
	
	@BeforeTest
	public void setup() {
		excelfile="Knowledge";
	}
	
	@Test(dataProvider = "fetchData")
	public void knowledge(String know, String desc) throws InterruptedException {
		

		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[text()='Knowledge']").click();
		Thread.sleep(3000);
		
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.className("btn-text")).click();
		
		driver.findElement(By.id("sys_display.kb_knowledge.kb_knowledge_base")).sendKeys(know,Keys.ENTER);
		
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='IT']")).click();
		driver.findElement(By.xpath("//span[text()='Java']")).click();
		driver.findElement(By.id("ok_button")).click();
		
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys(desc);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
	}

}
