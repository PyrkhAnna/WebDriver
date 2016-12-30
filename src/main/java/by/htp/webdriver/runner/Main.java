package by.htp.webdriver.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "d:\\selenium\\drivers\\geckodriver.exe");
		WebDriver driver =  new FirefoxDriver();
		driver.get("http://mail.ru/");
		
		WebElement emailElement = driver.findElement(By.id("mailbox__login"));
		emailElement.sendKeys("TATHTP@mail.ru");
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement passElement = driver.findElement(By.id("mailbox__password"));
		passElement.sendKeys("Klopik123");
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement signInElement = driver.findElement(By.id("mailbox__auth__button"));
		signInElement.submit();
		
	}

}
