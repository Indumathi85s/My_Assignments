package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) {
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
		
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/viewLead?partyId=10189']")).click();

		
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		System.out.println(text);
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		System.out.println("Company Name is updated as TestLeaf");
		driver.close();
		
	}

}
