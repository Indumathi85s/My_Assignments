package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		System.out.println(driver.getTitle());

		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();


		driver.findElement(By.linkText("Create Lead")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Indumathi");

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Shivakumar");
		
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("7395926317");

		//Dropdown1

		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));

		Select drop1=new Select(source);

		Thread.sleep(2000);

		drop1.selectByVisibleText("Employee");

		//Dropdown2

		WebElement src = driver.findElement(By.id("createLeadForm_marketingCampaignId"));

		Select drop2=new Select(src);

		Thread.sleep(2000);

		drop2.selectByVisibleText("Pay Per Click Advertising");

		//Dropdown3

		WebElement src1 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));

		Select drop3=new Select(src1);

		Thread.sleep(2000);

		drop3.selectByVisibleText("Corporation");

		//Dropdown4

		WebElement src2 = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));

		Select drop4=new Select(src2);

		Thread.sleep(2000);

		drop4.selectByVisibleText("India");


		driver.findElement(By.name("submitButton")).click();


		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();

		System.out.println(text);

		if(text.contains("Testleaf")) {
			System.out.println("Lead is created");
		}
		else {
			System.out.println("Lead is Not created");
		}


		driver.close();


	}

}
