package week4.day2;

import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		//To disable the notification
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement men = driver.findElement(By.xpath("(//a[@class='desktop-main'])[1]"));

		Actions act =new Actions(driver);
		act.moveToElement(men).perform();
		
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		
		System.out.println(driver.getTitle());
		
		String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		
		System.out.println("Total count of the Jackets : "+text);
		
		/*//int amt=Integer.parseInt(text);
		String cat1 = driver.findElement(By.xpath("//span[@class='categories-num'][1]")).getText();
		int num1=Integer.parseInt(cat1);
		
		String cat2 = driver.findElement(By.xpath("//span[@class='categories-num'][2]")).getText();
		int num2=Integer.parseInt(cat2);
		
		int sum=num1+num2;
		System.out.println("The sum of two categories = "+sum);
		String s=String.valueOf(sum);
		
		if(text.contains(s)) {
			System.out.println("Total count and sum of categories of jackets are same");
		}*/
		
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator'][1]")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//div[1]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
		Thread.sleep(2000);
		List<WebElement> prices = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		//Declare a list 
		//List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < prices.size(); i++) {
			System.out.println(prices.get(i).getText());
			}
		WebElement sort = driver.findElement(By.className("sort-sortBy"));

		Actions action =new Actions(driver);
		action.moveToElement(sort).perform();
		
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		
		String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		
		System.out.println("The first item price : "+price);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h4[@class='product-sizes']")).click();
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
		
		driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-wishlist pdp-button')]")).click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
