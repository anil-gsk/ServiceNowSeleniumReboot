package leaf.homeworksweek2;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Verify;

public class WrapperCode {
	
	protected WebDriver driver;
	protected WebElement Listbox; 
	protected String PrimaryWindowHandel;
	protected WebDriverWait wait;
	
	WebElement element;
	
	protected void startBrowser(String Browsertype, String URL){
		
		
		Browsertype = Browsertype.toLowerCase();
		
		switch(Browsertype){
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
			 driver = new ChromeDriver();
			 break;
		
		case "firefox":
			 driver = new FirefoxDriver();
			 break;
			 
		case "ie":
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\IEDriverServer.exe");;
			 driver = new InternetExplorerDriver();
			 break;	
			 
		default: 
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
		 	driver = new ChromeDriver();
		 	
		}
		System.out.println("Passed:Launched Browser Sucessfully"); 	
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

}

	protected void clickWebLink(String Locator){
		
		System.out.println(driver.findElement(By.linkText(Locator)).isDisplayed());
		
		try {
			
			driver.findElement(By.linkText(Locator)).click();
			
		
		
		} catch (NoSuchElementException e) {
			
			System.out.println(e.getMessage());
			
			
		}
		
		
		
	}
	
	protected void selectByVisualText(String Locator, String Visibletext){
		
		try {
			Listbox = driver.findElement(By.id(Locator));
			Select list = new Select(Listbox);
			list.selectByVisibleText(Visibletext);
			System.out.println("Sucessfully selected ListBox with value "+" "+Visibletext);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());	
		}
		
	}
	
	protected void selectByIndex(String Locator, int index){
		
		try {
			Listbox = driver.findElement(By.id(Locator));
			Select list = new Select(Listbox);
			list.selectByIndex(index);
			System.out.println("Sucessfully selected ListBox with index "+" "+index+"and its value is "+list.getFirstSelectedOption().getText());
			
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());	
		}
		
	}
	
	protected void colseBrowser(){
		
		
		driver.close(); // closes current window in which driver is worki9ng on
		
		
	}
	
	protected void closeAllBrowsers(){
		
		driver.quit();
		
		
	}
	
	protected void switchToPrimaryWindow(){
		
		
		PrimaryWindowHandel = getCurrentWindowHandle();
		
		driver.switchTo().window(PrimaryWindowHandel);
		
		
		
	}
	
	protected String getCurrentWindowHandle(){
		
		return driver.getWindowHandle();
		
	}
	
	protected String getCurrentWindowTitel(){
		
		return driver.getTitle();
		
	}
	
	protected  void switchtoLastWindow(){
		
		int dummy =0;
		
		Set<String> windowhandles = driver.getWindowHandles();
		
		int WindowsCount = driver.getWindowHandles().size();
		
		for(String window:windowhandles){
			
			driver.switchTo().window(window);
			
			dummy = +dummy;
			
		}
		
		if(dummy == WindowsCount){
		
			System.out.println("Switched to last window Sucessfully");
			
		}else{
			
			System.out.println("Failed to switch to last window");
			
		}
		
	}

	protected void closeAllOtherWindows(String OpenWindowHandle){
		
		Set<String> AllWindowsHandles =  driver.getWindowHandles();
		
		for (String CurrentWindowHandle : AllWindowsHandles) {
			
			if(!(CurrentWindowHandle==OpenWindowHandle)){
				
				driver.switchTo().window(CurrentWindowHandle);
				
				colseBrowser();
				
			}
			
		}
		
		driver.switchTo().window(OpenWindowHandle);
		
		if(driver.getWindowHandles().size()==1){
			
			System.out.println("All other windows are closed");
			
		}else{
			
			System.out.println("Failed to close all the windows");
			
			
		}
		
		
		
		
		
		
	}

	protected void switchToFrameByElement(String Locator){
		
		try {
			driver.switchTo().frame(driver.findElement(By.xpath(Locator)));
		} catch (NoSuchFrameException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		
	}

	protected void switchToFirstFrame(){
		
		try {
			driver.switchTo().frame(0);
		} catch (NoSuchFrameException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}

	protected void acceptAlert(){
		
		try {
			
			driver.switchTo().alert().accept();
		} 
		catch (NoAlertPresentException e) {
			
			System.out.println(e.getMessage());
		
		}
		
	}
	
	protected void dismissAlert(){
		
		try {
			
			driver.switchTo().alert().dismiss();
		} 
		catch (NoAlertPresentException e) {
			
			System.out.println(e.getMessage());
			
			
		
		}
		
	}
	
	protected void verifyText(String Locator, String TextToBeVerified){
		
		
		
		try {
			String Actualtext = driver.findElement(By.xpath(Locator)).getText();
			
			if(Actualtext.equals(TextToBeVerified)){
				
				System.out.println("Text verified sucessfully: Expected text "+TextToBeVerified+ " Actaual text: "+Actualtext);
				
		
				
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			
			
		}
		
		
		
	}

	protected void verifyURL(String ExpectedUrl){
		
		Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());	
		
		
	}

	protected void verifyTitel(String ExpectedTitle){
		
		String ActualTitle =  driver.getTitle();
		
		if(ActualTitle.equals(ExpectedTitle)){
			
			System.out.println("Browser Titels verified sucessfully and matched Expected title:"
					+ " "+ExpectedTitle+ " Actaual title: "+ActualTitle);
			
		}
	}

	protected void clickButton(String Locator){
		
		System.out.println(driver.findElement(By.id(Locator)).isDisplayed());
		
		try {
			
			driver.findElement(By.id(Locator)).click();
			
		
		
		} catch (NoSuchElementException e) {
			
			System.out.println(e.getMessage());
			
			
		}
		
		
	}

	protected void typeText(String Locator, String TextToType){
		
		System.out.println(driver.findElement(By.id(Locator)).isDisplayed());
		
		try {
			
			driver.findElement(By.id(Locator)).sendKeys(TextToType);;
			
		
		
		} catch (NoSuchElementException e) {
			
			System.out.println(e.getMessage());
			
			
		}
		
		
		
	}

	/*protected void WaitForElement(){
		
		wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
		
	}*/

}
