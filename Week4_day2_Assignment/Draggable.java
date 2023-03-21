package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Draggable {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		//To disable the notification
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement source = driver.findElement(By.id("form:drag_content"));
		
		WebElement dest = driver.findElement(By.id("form:drop_content"));
		Actions DragDrop= new Actions(driver);
		DragDrop.dragAndDrop(source, dest).perform();
		System.out.println(dest.getCssValue("background-color"));
		
		WebElement src = driver.findElement(By.xpath("//span[text()='Drag me around']"));
		
		Point location = src.getLocation();
		int x = location.getX();
		System.out.println(x);
		int y = location.getY();
		System.out.println(y);

		DragDrop.dragAndDropBy(src, 100, 100).perform();
		
		System.out.println(src.getLocation().getX());

	}

}
