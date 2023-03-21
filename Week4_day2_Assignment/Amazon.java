package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		//To disable the notification
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price of the first item is "+text);
		
		String rating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("No. of customer rated the product : "+rating);
		
		WebElement star = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-3 aok-align-bottom'])[1]"));
		
		Actions act =new Actions(driver);
		act.moveToElement(star).perform();
		Thread.sleep(3000);
		String star_5 = driver.findElement(By.xpath("(//a[@title='5 stars represent 50% of rating'])[3]")).getText();
		System.out.println("The percentage for 5-star : "+star_5);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).click();
		Thread.sleep(2000);
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		//Step1
		Set<String> windowHandles = driver.getWindowHandles();
		//Step2
		List<String> listWindow=new ArrayList<String>(windowHandles);
		//Step3
		driver.switchTo().window(listWindow.get(1));
		Thread.sleep(2000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		//Create folder to save the img file
		File dest =new File("./snap/img1.png");
		//Merge source and destination
		FileUtils.copyFile(source, dest);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		String tot = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		System.out.println("The sub-total in the cart : "+ tot);
		
		if(text.contains(tot)) {
			System.out.println("Cart amount is verified");
		}
	}

}
