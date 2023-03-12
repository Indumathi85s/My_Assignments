package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();



		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited Account1");
		
		driver.findElement(By.xpath("(//textarea[@class='inputBox'])[1]")).sendKeys("Selenium Automation Tester");
		
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Tester");
		
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Test Leaf");
		
		driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("10,000");
		
		//Dropdown1

		WebElement src = driver.findElement(By.xpath("(//select[@class='inputBox'])[2]"));

		Select drop1=new Select(src);

		drop1.selectByVisibleText("Computer Software");
		
		//Dropdown2

			WebElement src1 = driver.findElement(By.xpath("(//select[@class='inputBox'])[3]"));

			Select drop2=new Select(src1);

			drop2.selectByVisibleText("S-Corporation");
			
		//Dropdown3

			WebElement src2 = driver.findElement(By.xpath("(//select[@class='inputBox'])[4]"));

			Select drop3=new Select(src2);

			drop3.selectByValue("LEAD_EMPLOYEE");
			
		//Dropdown4

			WebElement src3 = driver.findElement(By.id("marketingCampaignId"));

			Select drop4=new Select(src3);

			drop4.selectByIndex(6);
			
			
		//Dropdown5

			WebElement src4 = driver.findElement(By.id("generalStateProvinceGeoId"));

			Select drop5=new Select(src4);

			drop5.selectByValue("TX");
			
			
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		System.out.println(driver.getTitle());


	}

}
