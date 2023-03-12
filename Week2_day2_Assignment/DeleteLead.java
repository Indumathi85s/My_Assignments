package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		System.out.println(driver.getTitle());

		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.linkText("Phone")).click();
		
		driver.findElement(By.name("phoneNumber")).sendKeys("7395926317");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		
		String str =  driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).getText();
		
		System.out.println(str);
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(str);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		
		String str1 =  driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		
		System.out.println(str1);
		
		System.out.println(str + " is deleted successfully");
		
		driver.close();		

	}

}
