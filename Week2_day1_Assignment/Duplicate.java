package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Duplicate {

	public static void main(String[] args) throws InterruptedException {
		//ChromeDriver driver=new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
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
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Indu");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Creating Lead...");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("indumathi85s@gmail.com");

		driver.findElement(By.name("submitButton")).click();

		System.out.println(driver.getTitle());
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(text);
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).clear();

		driver.findElement(By.id("createLeadForm_firstName")).clear();

		driver.findElement(By.id("createLeadForm_lastName")).clear();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Whitehat Junior");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Karthik");
		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Annamalai");

		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());

		//driver.close();


	}

}
