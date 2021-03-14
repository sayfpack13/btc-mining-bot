import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Main {

	public static void main(String[] args) {
final String accounts[]={
		"sayfpackc11@gmail.com:pass",
		"sayfpack@gmail.com:pass",
		"iamsayfrourou123@gmail.com:pass"
		};
final String cookies[]={
		"C:/Users/Sayf/AppData/Local/Google/Chrome/User Data",
		"C:/Users/Sayf/AppData/Local/Google/Chrome/User Data2",
		"C:/Users/Sayf/AppData/Local/Google/Chrome/User Data3"
};

final boolean enable_cookies=false;
final boolean silent_mode=true;
final int times=1000;
final int sleep=6; //hours
final int max_attempts=3;







ArrayList<String>[] tabs = new ArrayList[accounts.length];
final stormgain stormgain_threads[]=new stormgain[accounts.length];
final coin_mining[] coin_mining_threads=new coin_mining[accounts.length];


final String emails[]=new String[accounts.length];
final String passwords[]=new String[accounts.length];


		// get accounts ready
		for(int a=0;a<accounts.length;a++) {
			emails[a]=accounts[a].substring(0, accounts[a].indexOf(":"));
			passwords[a]=accounts[a].substring(accounts[a].indexOf(":")+1,accounts[a].length());
		}




		// browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe ");
		WebDriver browsers[]=new WebDriver[100];
		
		// browser options
		ChromeOptions options = new ChromeOptions();
		
		
		
		options.addArguments("chrome.switches", "--disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-extensions");
		options.addArguments("--blink-settings=imagesEnabled=false");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		//options.setExperimentalOption("useAutomationExtension", false);
		//options.addArguments("--incognito");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.addArguments("--disable-blink-features=AutomationControlled");
		

		
		if(silent_mode)
			options.addArguments("--headless");
		
		
		// start process
		for(int b=0;b<times;b++) {
		
		for(int a=0;a<accounts.length;a++) {
			if(enable_cookies)
				options.addArguments("user-data-dir=" + cookies[a]);
			
			browsers[a]=new ChromeDriver(options);
			
			
			
			
			
			stormgain_threads[a]=new stormgain(browsers[a],options,emails[a],passwords[a],max_attempts);
			
			
			// patched bot
			//coin_mining_threads[a]=new coin_mining(browsers[a],options,emails[a],passwords[a],max_attempts);
			
			
			
			// get tabs
			tabs[a]=new ArrayList<String>(browsers[a].getWindowHandles());

		}
		
		
		
		try {
			Thread.sleep((sleep*1000*60*60)+5000);
		}catch(Exception e) {
			
		}
		
		
		for(int a=0;a<accounts.length;a++) {
			browsers[a].close();
			browsers[a].quit();
		}
		
		
		}
		
		
		// stop process
		
		

		
	}
	
	
	

}
