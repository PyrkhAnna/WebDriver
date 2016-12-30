package by.htp.webdriver.runner;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainSelenium2 {
	public static   WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "d:\\selenium\\drivers\\geckodriver.exe");
		driver =  new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.it-academy.by/");
				
		WebElement firstMenu = driver.findElement(By.cssSelector("#main-menu li.expanded.menu-depth-1.menu-item-633"));
		System.out.println(firstMenu.findElement(By.tagName("a")).getText());
		/*
		driver.findElement(By.cssSelector("#main-menu ul.menu.clearfix")).click(); // Ищем нормальный элемент
		driver.switchTo().activeElement().sendKeys(Keys.TAB); // Переходим табом на проблемный элемент
		//driver.switchTo().activeElement().click();
		driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);// И кликаем на активном проблемном :) 
		//driver.switchTo().activeElement().click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("$('ul.menu.clearfix').css(\"display\",\"block\");");
		  driver.findElement(By.cssSelector("#main-menu ul.menu.clearfix")).click();
		  
		WebElement secondMenu = driver.findElement(By.cssSelector("#main-menu li.first.leaf.menu-depth-2.menu-item-634"));
		System.out.println(secondMenu.findElement(By.tagName("a")).getText());
		*/
		
		//WebElement activateFirstMenu = firstMenu.findElement(By.cssSelector("#main-menu ul.menu.clearfix"));
		/*Actions actions = new Actions(driver);
		actions.moveToElement(activateFirstMenu).build().perform();
		*/
		mouseOver(firstMenu);
		
		WebElement secondMenu1 = driver.findElement(By.cssSelector("#main-menu li.first.leaf.menu-depth-2.menu-item-634"));
		System.out.println(secondMenu1.findElement(By.tagName("a")).getText());
		//mouseOver(firstMenu);
		WebElement secondMenu2 = driver.findElement(By.cssSelector("#main-menu li.last.expanded.menu-depth-2.menu-item-657"));
		System.out.println(secondMenu2.findElement(By.tagName("a")).getText());
		//mouseOver(firstMenu);
		mouseOver(secondMenu2);
		WebElement thirdMenu1 = driver.findElement(By.cssSelector("#main-menu li.first.leaf.menu-depth-3.menu-item-660"));
		System.out.println(thirdMenu1.findElement(By.tagName("a")).getText());
		WebElement thirdMenu2 = driver.findElement(By.cssSelector("#main-menu li.leaf.menu-depth-3.menu-item-658"));
		System.out.println(thirdMenu2.findElement(By.tagName("a")).getText());
		WebElement thirdMenu3 = driver.findElement(By.cssSelector("#main-menu li.leaf.menu-depth-3.menu-item-659"));
		System.out.println(thirdMenu3.findElement(By.tagName("a")).getText());
		WebElement thirdMenu4 = driver.findElement(By.cssSelector("#main-menu li.last.leaf.menu-depth-3.menu-item-661"));
		System.out.println(thirdMenu4.findElement(By.tagName("a")).getText());
		/*
		WebElement secondMenu2 = driver.findElement(By.cssSelector("#main-menu li.last.expanded.menu-depth-2.menu-item-657"));
		List<WebElement> allA2 = secondMenu2.findElements(By.tagName("a"));
		for (WebElement a : allA2) {
			System.out.println(a.getText());
		}
		/*
		mouseOver(secondMenu2);
		WebElement thirdMenu1 = driver.findElement(By.cssSelector("#main-menu li.first.leaf.menu-depth-3.menu-item-660"));
		System.out.println(thirdMenu1.findElement(By.tagName("a")).getText());
		WebElement thirdMenu2 = driver.findElement(By.cssSelector("#main-menu li.leaf.menu-depth-3.menu-item-658"));
		System.out.println(thirdMenu2.findElement(By.tagName("a")).getText());
		WebElement thirdMenu3 = driver.findElement(By.cssSelector("#main-menu li.leaf.menu-depth-3.menu-item-659"));
		System.out.println(thirdMenu3.findElement(By.tagName("a")).getText());
		WebElement thirdMenu4 = driver.findElement(By.cssSelector("#main-menu li.last.leaf.menu-depth-3.menu-item-661"));
		System.out.println(thirdMenu4.findElement(By.tagName("a")).getText());
						
		/*
		WebElement firstMenu = driver.findElement(By.cssSelector("#main-menu li.expanded.menu-depth-1.menu-item-633"));
		List<WebElement> allA = firstMenu.findElements(By.tagName("a"));
		for (WebElement a : allA) {
			System.out.println(a.getText());
		}*/
		
		driver.quit();
	}
	
	private static void mouseOver(WebElement element) {
		String code = "var fireOnThis = arguments[0];"
	                + "var evObj = document.createEvent('MouseEvents');"
	                + "evObj.initEvent( 'mouseover', true, true );"
	                + "fireOnThis.dispatchEvent(evObj);";
		
		((JavascriptExecutor)driver).executeScript(code, element);
	}
	/*private static WebElement findAndPrint (String selector) {
		WebElement menu = driver.findElement(By.cssSelector(selector));
		System.out.println(menu.findElement(By.tagName("a")).getText());
		return menu;
	}*/
}


