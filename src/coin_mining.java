import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class coin_mining {
	private final String URL="https://coin-mining-farm.com/";
	private WebDriver browser;
	private ArrayList<String> tab;
	private ChromeOptions options;
	private String email;
	private String password;
	private boolean connected=false;
	
	private int attempts=1;
	private int max_attempts;
	
	public boolean done=false;
	
	
	public coin_mining(WebDriver browser,ChromeOptions options,String email,String password,int max_attempts) {
		this.email=email;
		this.password=password;
		this.browser=browser;
		this.options=options;
		this.max_attempts=max_attempts;
		this.start();
	}
	
	public coin_mining start() {
		// SECOND WEBSITE : COIN-MINING
		if(max_attempts==attempts)
			return this;
		else
			attempts++;
		

		((JavascriptExecutor) browser).executeScript("window.open('https://coin-mining-farm.com/','_blank');");
		tab=new ArrayList<String>(browser.getWindowHandles());
		browser.switchTo().window(tab.get(1));
		
		try {
			var getLogin=new WebDriverWait(browser, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu\"]/ul/li[6]/a")));
			getLogin.click();
		}catch (TimeoutException e) {
			try {
				
				browser.get("https://coin-mining-farm.com/panel/plan/hourly-free-plan");
				var getMiner=new WebDriverWait(browser, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myvue\"]/div/div[2]/div/div[2]/div/div/div/div/a")));
				getMiner.click();
				connected=true;
			}catch (TimeoutException ee) {
				connected=false;
				return new_instance();
			}
		}
		

		if(!connected) {
		try {
			var getEmail=new WebDriverWait(browser, 10).until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
			getEmail.sendKeys(email);
		}catch (TimeoutException e) {
			return new_instance();
		}
		

		
		var getPassword=browser.findElement(By.name("password"));
		
		getPassword.sendKeys(password);
		
		

		try {
			var getSignin=new WebDriverWait(browser, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myvue\"]/div/div[2]/form/div[4]/button")));
			getSignin.click();
		}catch (TimeoutException e) {
			return new_instance();
		}

		try {
			Thread.sleep(5000);
		}catch (Exception e) {
			
		}
		
		browser.get("https://coin-mining-farm.com/panel/plan/hourly-free-plan");
		
		try {
			var getMiner=new WebDriverWait(browser, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myvue\"]/div/div[2]/div/div[2]/div/div/div/div/a")));
			getMiner.click();
		}catch (TimeoutException e) {
			return new_instance();
		}
		}
		




		
		
		// check if already activated
		try {
			var getActivate=new WebDriverWait(browser, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("alert alert-danger")));
			getActivate.click();
			done=true;
		}catch (TimeoutException e) {
			done=true;
		}


		
		
		
		if(done) {
			System.out.println("activate button is pressed");
		}
		else
			System.out.println("activate button is not available !!!!!!");
			

		return this;
	}


	public coin_mining new_instance() {
		browser.close();
		browser.switchTo().window(tab.get(0));
		return start();
	}
	
	
	public String getTab() {
		return tab.get(1);
	}
	
	
	
	
	
}
