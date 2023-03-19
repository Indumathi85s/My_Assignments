package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingFrames {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		String text = driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		WebElement findElement = driver.findElement(By.xpath("//iframe[@src='nested.xhtml']"));
		driver.switchTo().frame(findElement);
		driver.findElement(By.xpath("//button[text()='Count Frames']")).click();
		String text2 = driver.findElement(By.xpath("//button[text()='Count Frames']")).getText();
		System.out.println(text2);
		 driver.switchTo().defaultContent();
         
         WebElement frame = driver.findElement(By.xpath("//iframe[@src='page.xhtml']"));
         driver.switchTo().frame(frame);
         driver.switchTo().frame("frame2");
         
         driver.findElement(By.xpath("//button[text()='Click Me']")).click();
         String text3 = driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText();
         System.out.println(text3);
         driver.switchTo().defaultContent();
         driver.switchTo().parentFrame();
	}

}
