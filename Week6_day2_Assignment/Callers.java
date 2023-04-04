package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Callers extends ProjectMethod {
	
	@BeforeTest
	public void setup() {
		excelfile="Callers";
	}
	@Test(dataProvider = "fetchData")
	public void callers(String un,String fn,String ln,String title,String dep,String email,String lang,String inte,String time,String date,String ph,String mob) throws InterruptedException {
				
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
		shadow.setImplicitWait(10);
		filter.click();
		filter.sendKeys("Callers");
		shadow.findElementByXPath("//mark[text()='Callers']").click();
		Thread.sleep(3000);
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("sys_user.user_name")).sendKeys(un);
		driver.findElement(By.id("sys_user.first_name")).sendKeys(fn);
		driver.findElement(By.id("sys_user.last_name")).sendKeys(ln);
		driver.findElement(By.id("sys_user.title")).sendKeys(title);
		driver.findElement(By.id("sys_display.sys_user.department")).sendKeys(dep);
		driver.findElement(By.id("sys_user.email")).sendKeys(email);
		
		WebElement src1 = driver.findElement(By.id("sys_user.preferred_language"));
		Select drop1=new Select(src1);
		drop1.selectByVisibleText(lang);
		
		WebElement src2 = driver.findElement(By.id("sys_user.calendar_integration"));
		Select drop2=new Select(src2);
		drop2.selectByVisibleText(inte);
		
		WebElement src3 = driver.findElement(By.id("sys_user.time_zone"));
		Select drop3=new Select(src3);
		drop3.selectByVisibleText(time);
		
		WebElement src4 = driver.findElement(By.id("sys_user.date_format"));
		Select drop4=new Select(src4);
		drop4.selectByVisibleText(date);
		
		driver.findElement(By.id("sys_user.phone")).sendKeys(ph);
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys(mob);
		
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		
		String text = driver.findElement(By.xpath("//div[@class='outputmsg_text']")).getText();
		System.out.println(text);
		
		//driver.findElement(By.xpath("(//input[contains(@class,'list_header_search ')])[2]")).sendKeys("Indumathi",Keys.ENTER);
		//String name = driver.findElement(By.xpath("//td[contains(@class,'list_decoration_cell col-small')]")).getText();
		//System.out.println(name);
	}

}
