package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		//To disable the notification
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame(0);
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(item7, item5).perform();
		Thread.sleep(2000);
		act.dragAndDrop(item3, item2).perform();
		Thread.sleep(2000);
		act.dragAndDrop(item6, item1).perform();

	}

}
