package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement element = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert prompt = driver.switchTo().alert();
		String text = prompt.getText();
		System.out.println(text);
		prompt.accept();
		String text2 = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text2);
	}

}
