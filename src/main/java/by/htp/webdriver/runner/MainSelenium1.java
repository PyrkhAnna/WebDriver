package by.htp.webdriver.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainSelenium1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "d:\\selenium\\drivers\\geckodriver.exe");
		WebDriver driver =  new FirefoxDriver();
		driver.get("https://google.com/");
		
		WebElement searchElement = driver.findElement(By.id("lst-ib"));
		searchElement.sendKeys("Java");
			
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement findElement = driver.findElement(By.name("btnG"));
		findElement.submit();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean exist=false;
		System.out.println("Page title is: " + driver.getTitle());
		if (driver.getTitle().contains("Java")) {
			//System.out.println("Page title is: " + driver.getTitle());
			exist=true;
		}
		//if (title.getText().contains("Java")) exist=true;
		
		if (exist) System.out.println("true"); else System.out.println("false");
		/*
		WebElement h3 = driver.findElement(By.tagName("h3"));
		List<WebElement> allA = h3.findElements(By.tagName("a"));
		boolean exist=false;
		for (WebElement a : allA) {
			if (a.getText().contains("Java")) exist=true;
		}
		if (exist) System.out.println("true"); else System.out.println("false");
		*/
		
		/*WebElement passElement = driver.findElement(By.id("mailbox__password"));
		passElement.sendKeys("Klopik123");
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement signInElement = driver.findElement(By.id("mailbox__auth__button"));
		signInElement.submit();*/

	}

}
