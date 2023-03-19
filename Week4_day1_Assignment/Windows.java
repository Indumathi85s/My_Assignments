package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Windows {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.partialLinkText("FLIGHTS")).click();
		System.out.println(driver.getTitle());
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		//Step1
		Set<String> windowHandles = driver.getWindowHandles();
		//Step2
		List<String> listWindow=new ArrayList<String>(windowHandles);
		//Step3
		driver.switchTo().window(listWindow.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(windowHandle);
		System.out.println(driver.getTitle());
		driver.quit();
		
		

	}

}
