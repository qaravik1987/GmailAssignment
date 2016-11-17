package corilis.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailAssignment {
	
	public WebDriver driver;
	
	public void driverSetup()
	{
		System.setProperty("webdriver.chrome.driver", ".//lib//chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void main(String[] args){
		GmailAssignment _gmailAssignment = new GmailAssignment();
		_gmailAssignment.driverSetup();
		_gmailAssignment.loginIntoGmail("qaravik1987@gmail.com", "test12345678");
		_gmailAssignment.tearDown();
	}
	
	public void loginIntoGmail(String userID, String pwd)
	{
		String content = "Name : Ravi Kumar Mahobia \n"+"Contact No : 8888817189 \n"+"https://github.com/qaravik1987/GmailAssignment.git";
		WebDriverWait wait = new WebDriverWait(driver, 2);
		String url = "https://www.gmail.com";
		driver.get(url);
		WebElement emailId = driver.findElement(By.id("Email"));
		emailId.sendKeys(userID);
		WebElement next = driver.findElement(By.id("next")); 
		next.submit();
		WebElement password = driver.findElement(By.id("Passwd")); 
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(pwd);
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
	    send.click();
	}
	
	public void tearDown()
	{
		driver.close();
	}

}
