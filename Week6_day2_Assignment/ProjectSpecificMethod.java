package testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


import week6.day2.ReadExcel;

public class ProjectSpecificMethod {

	public RemoteWebDriver driver;
	public String excelfile;
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void PreCondition(String browser,String url,String username,String password) {
		
		switch(browser) {
		case "chrome":
		{
	
			driver=new ChromeDriver();
			break;
		}
		case "edge":
		{
			driver=new EdgeDriver();
			break;
		}
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@AfterMethod
	public void PostCondition() {
		driver.close();
	}
	@DataProvider(name="fetchData")
	public String[][] getdata() throws IOException {
	    String[][] inputData = ReadExcel.inputData(excelfile);//ctrl+2+l
	    return inputData;
	    
	}
}
