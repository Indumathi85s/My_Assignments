package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderMobile {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		//To disable the notification
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://dev57553.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("2oaD6KN$q$vN");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
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
		drop1.selectByVisibleText("Gold");
		
		WebElement gb = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		Select drop2=new Select(gb);
		drop2.selectByVisibleText("128");
		
		driver.findElement(By.id("oi_order_now_button")).click();
		
		String order = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
		
		System.out.println(order);
		
		String req = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("Request Number : "+req);

	}

}
