package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		System.out.println(driver.getTitle());

		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();
		
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		
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
		
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		
		//driver.close();
		Thread.sleep(2000);
		
		driver.switchTo().window(windowHandle);

		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
		System.out.println(driver.getTitle());
		String window = driver.getWindowHandle();
		System.out.println(window);
		//Step1
		Set<String> windowHandles1 = driver.getWindowHandles();
		//Step2
		List<String> list=new ArrayList<String>(windowHandles1);
		//Step3
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		
		//driver.close();
		
		driver.switchTo().window(window);
		
		driver.findElement(By.className("buttonDangerous")).click();
	
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		if(title.contains("View Contact")) {
			System.out.println("Contacts are merged successfully");
		}

	}

}
