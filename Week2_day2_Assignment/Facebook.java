package week3.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Facebook {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']")).sendKeys("Indumathi");
		driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[2]")).sendKeys("Shivakumar");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("7395926317");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Hello@123");
		
		WebElement src1 = driver.findElement(By.id("day"));

		Select drop1=new Select(src1);

		drop1.selectByValue("27");
		
		WebElement src2 = driver.findElement(By.id("month"));

		Select drop2=new Select(src2);

		drop2.selectByValue("11");
		
		WebElement src3 = driver.findElement(By.id("year"));

		Select drop3=new Select(src3);

		drop3.selectByValue("1985");
		
		driver.findElement(By.xpath("(//input[@class='_8esa'])[1]")).click();
		
		System.out.println(driver.getTitle());

	}

}
