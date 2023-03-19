package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
public class PromptDialog {

	public static void main(String[] args) throws InterruptedException {
		/*
		 from Testleaf Trainer to everyone:    4:16 PM
Testcase:
Launch https://leafground.com/alert.xhtml
Click on the Show button next to Prompt Dialog
Switch the driver focus to alert 
Enter the text in the alert text box 
Accept the alert 
Confirm the text entered is displayed in the webpage

		 */


		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();

		Alert prompt = driver.switchTo().alert();
		String text = prompt.getText();
		System.out.println(text);
		prompt.sendKeys("Indumathi");
		prompt.accept();
		
		String text2 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(text2);

	}

}
