package by.htp.webdriver.runner;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainSelenium2_1 {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "d:\\selenium\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().setScriptTimeout(150, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://www.it-academy.by/");
				
		WebElement firstMenu = driver.findElement(By.cssSelector("#main-menu li.expanded.menu-depth-1.menu-item-633"));
		System.out.println(firstMenu.findElement(By.tagName("a")).getText());
		
		mouseHoverJScript(firstMenu);
		
		WebElement secondMenu2 = driver.findElement(By.cssSelector("#main-menu li.last.expanded.menu-depth-2.menu-item-657"));
		System.out.println(secondMenu2.findElement(By.tagName("a")).getText());

		mouseHoverJScript(secondMenu2);
		
		WebElement thirdMenu1 = driver.findElement(By.cssSelector("#main-menu li.first.leaf.menu-depth-3.menu-item-660"));
		System.out.println(thirdMenu1.findElement(By.tagName("a")).getText());
		WebElement thirdMenu2 = driver.findElement(By.cssSelector("#main-menu li.leaf.menu-depth-3.menu-item-658"));
		System.out.println(thirdMenu2.findElement(By.tagName("a")).getText());
		WebElement thirdMenu3 = driver.findElement(By.cssSelector("#main-menu li.leaf.menu-depth-3.menu-item-659"));
		System.out.println(thirdMenu3.findElement(By.tagName("a")).getText());
		WebElement thirdMenu4 = driver.findElement(By.cssSelector("#main-menu li.last.leaf.menu-depth-3.menu-item-661"));
		System.out.println(thirdMenu4.findElement(By.tagName("a")).getText());

		WebElement catalogMenu = driver.findElement(By.cssSelector("#main-menu li.first.expanded.menu-depth-1.menu-item-553"));
		
		mouseHoverJScript(catalogMenu);
		
		driver.findElement(By.cssSelector("a[href='/catalog/159']")).click();
		
		driver.quit();
	}
	
	public static void mouseHoverJScript(WebElement HoverElement) {
		try {
			if (isElementPresent(HoverElement)) {
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
				+"evObj.initEvent('mouseover', true, false); "
				+"arguments[0].dispatchEvent(evObj);} "
				+"else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);
			} else {
					System.out.println("Element was not visible to hover " + "\n");
					}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + HoverElement + "is not attached to the page document" + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement + " was not found in DOM" + e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering" + e.getStackTrace());
		}
	}

	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()|| element.isEnabled()) flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}
	
	/*public static void displayElementMenu (String selector) {
		WebElement menuElement = driver.findElement(By.cssSelector(selector));
		System.out.println(menuElement.findElement(By.tagName("a")).getText());
		
	}*/
}
