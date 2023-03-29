package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class Knowledge {

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
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[text()='Knowledge']").click();
		Thread.sleep(3000);
		
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.className("btn-text")).click();
		
		driver.findElement(By.id("sys_display.kb_knowledge.kb_knowledge_base")).sendKeys("IT",Keys.ENTER);
		
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='IT']")).click();
		driver.findElement(By.xpath("//span[text()='Java']")).click();
		driver.findElement(By.id("ok_button")).click();
		
		//driver.findElement(By.id("sys_display.kb_knowledge.kb_category")).sendKeys("Java");
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys("Hello Everyone");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
	}

}
