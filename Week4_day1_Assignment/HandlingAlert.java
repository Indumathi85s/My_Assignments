package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingAlert {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//First
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		String text3 = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		System.out.println(text3);
		
		//Second
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.accept();
		String text4 = driver.findElement(By.xpath("//span[@id='result']")).getText();
		System.out.println(text4);
		
		//Third
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		String text5 = driver.findElement(By.xpath("//p[contains(text(),'You have clicked')]")).getText();
		System.out.println(text5);
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		
		//Fourth
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[5]")).click();
		String text6 = driver.findElement(By.xpath("//p[contains(text(),'Unless you close this')]")).getText();
		System.out.println(text6);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		
		//Fifth
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
		Alert prompt = driver.switchTo().alert();
		String text = prompt.getText();
		System.out.println(text);
		prompt.sendKeys("Indumathi");
		prompt.accept();		
		String text2 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(text2);
		
		//Sixth
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[7]")).click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		
		//Seventh
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]")).click();
		String str = driver.findElement(By.xpath("//p[text()='I am Sweet Alert and can be maximized or minimized. By the way, am not a new window.']")).getText();
		System.out.println(str);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-minus'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-extlink'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
		
	}

}
