package by.htp.webdriver.runner;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailSelenium3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "d:\\selenium\\drivers\\geckodriver.exe");
		WebDriver driver =  new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.quizful.net/");
		
		WebElement linkRegistration = driver.findElement(By.cssSelector("a[href='/LoginAction.registration']"));
		linkRegistration.click();
		
		WebElement loginElement = driver.findElement(By.id("login"));
		loginElement.sendKeys("Anna_Pyrkh27");
		
		WebElement passElement = driver.findElement(By.name("registrationForm.password"));
		passElement.sendKeys("Klopik_123456");
		
		WebElement rePassElement = driver.findElement(By.name("registrationForm.repassword"));
		rePassElement.sendKeys("Klopik_123456");
		
		WebElement emailElement = driver.findElement(By.name("registrationForm.email"));
		emailElement.sendKeys("Buggest123@mail.ru");
		
		driver.findElement(By.name("registrationForm.captcha")).clear();
		(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
			    return (d.findElement(By.name("registrationForm.captcha")).getAttribute("value").length() == 5);
			 }
		});
		
		WebElement corporateElement = driver.findElement(By.id("corporate"));
		corporateElement.click();
		
		
		WebElement signInElement = driver.findElement(By.cssSelector("p.buttons input.btn.btn-primary"));
		signInElement.click();
		
		
		/*
		 * 
		 * assertSelectedValue
		 * текст в поле нужно проверить,
		 * 
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.assertSelectedValue;
            }
        });
		WebElement dynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("dynamicElement_id")));
		
		WebElement captchaElement = driver.findElement(By.name("registrationForm.captcha"));
		captchaElement.sendKeys("08621");
		*/
		
		
		
		/*  
		WebElement searchElement = driver.findElement(By.id("lst-ib"));
		searchElement.sendKeys("Java");
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement findElement = driver.findElement(By.name("btnG"));
		findElement.submit();
		WebElement passElement = driver.findElement(By.id("mailbox__password"));
		passElement.sendKeys("Klopik123");
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement signInElement = driver.findElement(By.id("mailbox__auth__button"));
		signInElement.submit();*/
		
		driver.quit();
	}

}
