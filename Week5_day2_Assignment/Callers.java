package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class Callers {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		//To disable the notification
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://dev57553.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("2oaD6KN$q$vN");
		driver.findElement(By.id("sysverb_login")).click();
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
		
		driver.findElement(By.id("sys_user.user_name")).sendKeys("Indu85s");
		driver.findElement(By.id("sys_user.first_name")).sendKeys("Indumathi");
		driver.findElement(By.id("sys_user.last_name")).sendKeys("Shivakumar");
		driver.findElement(By.id("sys_user.title")).sendKeys("Student");
		driver.findElement(By.id("sys_display.sys_user.department")).sendKeys("Customer Support");
		driver.findElement(By.id("sys_user.email")).sendKeys("indumathi85s@gmail.com");
		
		WebElement src1 = driver.findElement(By.id("sys_user.preferred_language"));
		Select drop1=new Select(src1);
		drop1.selectByVisibleText("English");
		
		WebElement src2 = driver.findElement(By.id("sys_user.calendar_integration"));
		Select drop2=new Select(src2);
		drop2.selectByVisibleText("Outlook");
		
		WebElement src3 = driver.findElement(By.id("sys_user.time_zone"));
		Select drop3=new Select(src3);
		drop3.selectByVisibleText("GMT");
		
		WebElement src4 = driver.findElement(By.id("sys_user.date_format"));
		Select drop4=new Select(src4);
		drop4.selectByVisibleText("MM-dd-yyyy");
		
		driver.findElement(By.id("sys_user.phone")).sendKeys("7395926317");
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("567894212");
		
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		
		String text = driver.findElement(By.xpath("//div[@class='outputmsg_text']")).getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("(//input[contains(@class,'list_header_search ')])[2]")).sendKeys("Indumathi",Keys.ENTER);
		String name = driver.findElement(By.xpath("//td[contains(@class,'list_decoration_cell col-small')]")).getText();
		System.out.println(name);
	}

}
