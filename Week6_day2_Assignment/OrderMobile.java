package week6.day2;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class OrderMobile extends ProjectMethod {
	@BeforeTest
	public void setup() {
		excelfile="Mobile";
	}

	@Test(dataProvider = "fetchData")
	public void orderMobile(String Color, String GB) throws InterruptedException {
		
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(10);
		Thread.sleep(2000);
		dom.findElementByXPath("//div[@class='sn-polaris-tab can-animate polaris-enabled']").click();

		Thread.sleep(2000);
		
		dom.findElementByXPath("//span[text()='Service Catalog']").click();
		
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//h2[text()[normalize-space()='Mobiles']]")).click();
		
		driver.findElement(By.xpath("//strong[text()='iPhone 6s']")).click();
		Thread.sleep(2000);
		
		WebElement color = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select drop1=new Select(color);
		drop1.selectByVisibleText(Color);
		
		WebElement gb = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		Select drop2=new Select(gb);
		drop2.selectByVisibleText(GB);
		
		driver.findElement(By.id("oi_order_now_button")).click();
		
		String order = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
		
		System.out.println(order);
		
		String req = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("Request Number : "+req);

	}

}
