package week6.day2;

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

import io.github.sukgu.Shadow;

public class ProjectMethod {
	public RemoteWebDriver driver;
	public String excelfile;
	public Shadow shadow;
	@Parameters({"browser","url","username","password"})

	@BeforeMethod
	public void PreCondition(String browser,String url,String username,String password) {
		switch(browser) 
		{
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
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("sysverb_login")).click();
	}
	
	@AfterMethod
	public void PostCondition() {
		driver.close();
	}
	
	@DataProvider(name="fetchData")
	public String[][] getData() throws IOException{
		
		String[][] inputData = ReadExcel.inputData(excelfile);
		return inputData;
		
	}


}
