import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class stormgain {
private final String URL="https://app.stormgain.com/";
private WebDriver browser;
private ArrayList<String> tab;
private ChromeOptions options;
private String email;
private String password;
private boolean connected=false;

private int attempts=1;
private int max_attempts;

public boolean done=false;

public stormgain(WebDriver browser,ChromeOptions options,String email,String password,int max_attempts) {
	this.email=email;
	this.password=password;
	this.browser=browser;
	this.options=options;
	this.max_attempts=max_attempts;
	this.start();
}

public stormgain start() {
	// FIRST WEBSITE : STORMGAIN
	if(max_attempts==attempts)
		return this;
	else
		attempts++;
	
	
	browser.get(URL);
	tab=new ArrayList<String>(browser.getWindowHandles());
	browser.switchTo().window(tab.get(0));

	try {
		var getLogin=new WebDriverWait(browser, 5).until(ExpectedConditions.elementToBeClickable(By.className("login-link")));
		getLogin.click();
	}catch (TimeoutException e) {
		try {
			browser.get("https://app.stormgain.com/crypto-miner/");
			var getMiner=new WebDriverWait(browser, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"region-header\"]/div/nav/div[2]/a[6]")));
			getMiner.click();
			connected=true;
		}catch (TimeoutException ee) {
			connected=false;
			return new_instance();
		}
	}
	
	if(!connected) {
	var getEmail=browser.findElement(By.id("email"));
	
	getEmail.sendKeys(email);
	
	var getPassword=browser.findElement(By.id("password"));
	
	getPassword.sendKeys(password);
	
	

	try {
		var getSignin=new WebDriverWait(browser, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modal\"]/div/div[2]/form/div[6]/input")));
		getSignin.click();
	}catch (TimeoutException e) {
		return new_instance();
	}



	

	try {
		var getMiner=new WebDriverWait(browser, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"region-header\"]/div/nav/div[2]/a[6]")));
		getMiner.click();
	}catch (TimeoutException e) {
		return new_instance();
	}
	
	}
	
	
	
	
	
	try {
		var getFrame=new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"region-main\"]/div/iframe")));
		browser.switchTo().frame(getFrame);
	}catch (TimeoutException e) {
		return new_instance();
	}

	
	try {
		Thread.sleep(2000);
		var getActivate=new WebDriverWait(browser, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/button")));
		getActivate.click();
		done=true;
	}catch (TimeoutException e) {
		done=false;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
	}


	
	
	
	if(done) {
		System.out.println("activate button is pressed");
	}
	else
		System.out.println("activate button is not available !!!!!!");
		

	
	browser.switchTo().defaultContent();


	
	return this;
}


public stormgain new_instance() {
	browser.close();
	return start();
}


public String getTab() {
	return tab.get(0);
}
}
