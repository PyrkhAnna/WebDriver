package by.htp.webdriver.runner;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainSelenium4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "d:\\selenium\\drivers\\geckodriver.exe");
		WebDriver driver =  new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.tut.by/");
		
		WebElement titleNews = driver.findElement(By.cssSelector("#title_news_block span.header._title"));
		System.out.println(titleNews.getText());
		
		WebElement linkNews = driver.findElement(By.cssSelector("#title_news_block a.header_link"));
		linkNews.click();
		
		List<WebElement> pNews = driver.findElements(By.cssSelector("#article_body p"));
		System.out.println("Amount p is "+pNews.size());
		driver.quit();
	}

}
