package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		//To disable the notification
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));

		Actions act =new Actions(driver);
		act.moveToElement(brands).perform();
		
		driver.findElement(By.xpath("//div[@id='scroller-container']/div[7]/a[1]")).click();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.className("sort-name")).click();
		
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[2]")).click();
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@for='checkbox_Color Protection_10764']//div)[2]")).click();
		
		String text = driver.findElement(By.xpath("//div[@class='css-rtde4j']")).getText();
		System.out.println(text);
		if(text.contains("Shampoo")) {
			System.out.println("Filter is applied for Shampoo");
		}
		driver.findElement(By.xpath("//img[@src='https://images-static.nykaa.com/media/catalog/product/tr:w-220,h-220,cm-pad_resize/5/2/52d9cafLP_8901526101245_1.jpg']")).click();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		//Step1
		Set<String> windowHandles = driver.getWindowHandles();
		//Step2
		List<String> listWindow=new ArrayList<String>(windowHandles);
		//Step3
		driver.switchTo().window(listWindow.get(1));
		Thread.sleep(2000);
		
		driver.findElement(By.className("css-2t5nwu")).click();
		driver.findElement(By.xpath("//option[@value='0']")).click();
		//Thread.sleep(1000);
		String rate = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
		
		System.out.println("Rate : "+rate);
		
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		
		driver.findElement(By.className("cart-count")).click();
		
		driver.switchTo().frame(0);
		
		String total = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		
		System.out.println("The Grand Total : "+total);
		
		driver.findElement(By.xpath("(//button[@class='css-1j2bj5f e8tshxd0'])[2]")).click();
		
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		String finalTot  = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
		
		System.out.println(finalTot);
		
		if(finalTot.equals(total)) {
			System.out.println("grand total is the same : "+finalTot);
		}
		driver.quit();
	}
}
