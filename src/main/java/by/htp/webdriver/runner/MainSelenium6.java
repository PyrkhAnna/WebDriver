package by.htp.webdriver.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MainSelenium6 {
	private static WebDriver driver;
	private static final String DRIVER = "webdriver.gecko.driver";
	private static final String DRIVER_PATH = "d:\\selenium\\drivers\\geckodriver.exe";
	private static final String URL = "http://www.quizful.net/";
	private static final String LINK_LOG_IN = "a[href='/LoginAction.loginForm']";
	private static final String SIGN_IN = "p.buttons input.btn.btn-primary";
	private static final String LOGIN = "login";
	private static final String LOGIN_VALUE = "Anna_Pyrkh27";
	private static final String LOGIN_PASSWORD = "loginForm.password";
	private static final String LOGIN_PASSWORD_VALUE = "Klopik_123456";
			
	public static void main(String[] args) {
		System.setProperty(DRIVER, DRIVER_PATH);
		driver =  new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(URL);
				
		clickElementBySelector(LINK_LOG_IN);
		setElementById(LOGIN, LOGIN_VALUE);
		setElementByName(LOGIN_PASSWORD, LOGIN_PASSWORD_VALUE);
		clickElementBySelector(SIGN_IN);
		
		clickProfile();
		
		clickCorrectProfile();
				
		clickProfilePersonalForm();
		setName();
		setSurname();
		setSite();
		setYear();		
		setCompany();
		setCountry();
		setCity();
		setTime();
		setAbout();
		saveProfilePersonalForm();	
				
		clickCorrectProfile();
				
		WebElement linkNotificationsForm = driver.findElement(By.cssSelector("#profile-notifications-form img[src='/res/blank.gif']"));
		linkNotificationsForm.click();
		driver.findElement(By.name("notificationsForm.notificationsEnabled")).click();
		driver.findElement(By.name("notificationsForm.deliveryEnabled")).click();
		saveNotificationsForm();		
		
		clickCorrectProfile();		
		
		WebElement linkPrivacyForm = driver.findElement(By.cssSelector("#profile-privacy-form img[src='/res/blank.gif']"));
		linkPrivacyForm.click();
		driver.findElement(By.name("privacyForm.profileVisibility")).click();
		savePrivacyForm();
		
		
	}
	
	public static void clickElementBySelector(String selector) {
		driver.findElement(By.cssSelector(selector)).click();
	}
	public static void setElementById(String id, String value) {
		driver.findElement(By.id(id)).sendKeys(value);
	}
	public static void setElementByName(String name, String value) {
		driver.findElement(By.name(name)).sendKeys(value);
	}
	
	public static void clickProfile() {
		WebElement linkProfile = driver.findElement(By.cssSelector("#navigation a[href=' /user/Anna_Pyrkh27 ']"));
		linkProfile.click();
	}
	public static void clickCorrectProfile() {
		WebElement linkCorrectProfile = driver.findElement(By.cssSelector("a[href='/ProfileAction.settings']"));
		linkCorrectProfile.click();
	}
	public static void clickProfilePersonalForm() {
		WebElement linkProfilePersonalForm = driver.findElement(By.cssSelector("#profile-personal-form img[src='/res/blank.gif']"));
		linkProfilePersonalForm.click();
	}
	
	public static void saveProfilePersonalForm() {
		WebElement saveProfilePersonalForm = driver.findElement(By.name("personalForm.save"));
		saveProfilePersonalForm.submit();
	}
	public static void saveNotificationsForm() {
		WebElement saveNotificationsForm = driver.findElement(By.name("notificationsForm.save"));
		saveNotificationsForm.submit();
	}
	public static void savePrivacyForm() {
		WebElement savePrivacyForm = driver.findElement(By.name("privacyForm.save"));
		savePrivacyForm.submit();
	}
	
	public static void setName() {
		WebElement nameElement = driver.findElement(By.name("personalForm.name"));
		nameElement.sendKeys("Anna");
	}
	public static void setSurname() {
		WebElement surnameElement = driver.findElement(By.name("personalForm.surname"));
		surnameElement.sendKeys("Pyrkh");
	}
	public static void setYear() {
		WebElement yearElement = driver.findElement(By.name("personalForm.birthyear"));
		yearElement.sendKeys("2011");
	}
	public static void setSite() {
		WebElement siteElement = driver.findElement(By.name("personalForm.site"));
		siteElement.sendKeys("www.tut.by");
	}
	public static void setCompany() {
		WebElement companyElement = driver.findElement(By.name("personalForm.company"));
		companyElement.sendKeys("TUT");
	}
	public static void setCountry() {
		Select selectCountry = new Select(driver.findElement(By.cssSelector("select[name='personalForm.countryId'")));
		selectCountry.deselectAll();
		selectCountry.selectByVisibleText("Беларусь");
	}
	public static void setCity() {
		Select selectCity = new Select(driver.findElement(By.cssSelector("select[name='personalForm.cityId'")));
		selectCity.deselectAll();
		selectCity.selectByVisibleText("Минск");
	}
	public static void setTime() {
		Select selectTime = new Select(driver.findElement(By.cssSelector("select[name='personalForm.cityId'")));
		selectTime.deselectAll();
		selectTime.selectByVisibleText("Белоруссия/Минск(GMT+3)");
	}
	public static void setAbout() {
		WebElement aboutElement = driver.findElement(By.name("personalForm.about"));
		aboutElement.sendKeys("TUT.BY");
	}
}
