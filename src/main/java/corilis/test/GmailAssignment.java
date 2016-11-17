package corilis.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailAssignment {

	public static void main(String[] args){
		
		String content = "Name : Ravi Kumar Mahobia \n"+"Contact No : 8888817189 \n"+"http://";
		System.setProperty("webdriver.chrome.driver", ".//lib//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		String url = "https://www.gmail.com";
		driver.get(url);
		WebElement emailId = driver.findElement(By.id("Email"));
		emailId.sendKeys("qaravik1987@gmail.com");
		WebElement next = driver.findElement(By.id("next")); 
		next.submit();
		WebElement password = driver.findElement(By.id("Passwd")); 
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys("test12345678");
		WebElement signIn = driver.findElement(By.id("signIn"));
		signIn.submit();
		WebElement compose = driver.findElement(By.cssSelector("div[class^='T-I'][role='button'][gh='cm']"));
		wait.until(ExpectedConditions.elementToBeClickable(compose));
		compose.click();
		WebElement to = driver.findElement(By.name("to"));
		to.sendKeys("hiring@coriolis.co.in");
		List<WebElement> addCC = driver.findElements(By.cssSelector("span[data-tooltip^='Add']"));
		wait.until(ExpectedConditions.elementToBeClickable(addCC.get(0)));
		addCC.get(0).click();
		WebElement cc = driver.findElement(By.name("cc"));
		cc.sendKeys("shrikant.katkojwar@coriolis.co.in");
		WebElement subjectBox = driver.findElement(By.name("subjectbox"));
		subjectBox.sendKeys("GmailAssignment");
		WebElement mailBody = driver.findElement(By.cssSelector("div[class^='Am']"));
		mailBody.sendKeys(content);
		WebElement send = driver.findElement(By.cssSelector("div[role='button'][data-tooltip^='Send']"));
	//	send.click();
		driver.close();

	}

}
