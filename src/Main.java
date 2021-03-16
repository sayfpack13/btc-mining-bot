import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Main {

	public static void main(String[] args) {
		
final String accounts[]=new String[20];
int accounts_count=0;
final String cookies[]={
		"C:/Users/Sayf/AppData/Local/Google/Chrome/User Data",
		"C:/Users/Sayf/AppData/Local/Google/Chrome/User Data2",
		"C:/Users/Sayf/AppData/Local/Google/Chrome/User Data3"
};

// VARS
final boolean stormgain=true;
final boolean coin_mining=false;

final boolean enable_cookies=false;
final boolean multiple_cookies=false;
final boolean icognito=false;
final boolean silent_mode=true;
final int times=1000;
final int sleep=1; //hours
final int max_attempts=3;
//VARS



int done;
int undone;
int a=0;


// read accounts from external file
try(BufferedReader br = new BufferedReader(new FileReader("accounts.txt"))) {
	StringBuilder sb = new StringBuilder();
	String line = br.readLine();

	while (line != null) {

		accounts[a]=line;
		accounts_count++;
		a++;
		line = br.readLine();

	}

}catch(Exception e) {
}


ArrayList<String>[] tabs = new ArrayList[accounts_count];
final stormgain[] stormgain_instance=new stormgain[accounts_count];
final coin_mining[] coin_mining_instance=new coin_mining[accounts_count];
final String emails[]=new String[accounts_count];
final String passwords[]=new String[accounts_count];


		// get accounts ready

		for( a=0;a<accounts_count;a++) {
			emails[a]=accounts[a].substring(0, accounts[a].indexOf(":"));
			passwords[a]=accounts[a].substring(accounts[a].indexOf(":")+1,accounts[a].length());
		}




		// browser
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver browsers[]=new WebDriver[15];
		
		// browser options
		ChromeOptions options = new ChromeOptions();
		
		
		if(silent_mode) {
			options.addArguments("--headless");
			//options.addArguments("--headless", "--disable-gpu", "--window-size=1900,1080","--ignore-certificate-errors", "--silent");
			options.addArguments("--blink-settings=imagesEnabled=false");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-blink-features=AutomationControlled");
			
		    options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");                         //specify user agent
		    options.setExperimentalOption("excludeSwitches", new String [] {"enable-automation"});
		}else {
			options.addArguments("--start-maximized");
			options.addArguments("--blink-settings=imagesEnabled=false");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-blink-features=AutomationControlled");
			//options.setExperimentalOption("useAutomationExtension", false);
		}
			

		options.addArguments("--no-sandbox");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-in-process-stack-traces");
		options.addArguments("--disable-logging");
		options.addArguments("--disable-dev-shm-usage");
		//options.addArguments("--log-level=3");
		//options.addArguments("--output=/dev/null");

		
		
		
		if(icognito)
			options.addArguments("--incognito");
		

		if(enable_cookies & !multiple_cookies)
			options.addArguments("user-data-dir=" + cookies[0]);
		
		
		
		
		// start process
		for(int b=0;b<times;b++) {
		done=0;
		undone=0;
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("This is the "+(b+1)+" Job ...");
		
		for( a=0;a<accounts_count;a++) {
			if(enable_cookies & multiple_cookies)
				options.addArguments("user-data-dir=" + cookies[a]);
	
			browsers[a]=new ChromeDriver(options);

			
			
			
			
			System.out.println("================================================");
			System.out.println("Account "+(a+1)+" ("+emails[a]+"): starting ...");
			
			if(stormgain)
			stormgain_instance[a]=new stormgain(browsers[a],options,emails[a],passwords[a],max_attempts);
			
			
			if(coin_mining)
			coin_mining_instance[a]=new coin_mining(browsers[a],options,emails[a],passwords[a],max_attempts);
			
			
			if(stormgain)
			if(stormgain_instance[a].done)
				done++;
			else
				undone++;
			
			
			if(coin_mining)
			if(stormgain_instance[a].done)
				done++;
			else
				undone++;
			
			
			
			// get tabs
			tabs[a]=new ArrayList<String>();
			
			if(stormgain)
				tabs[a].add(stormgain_instance[a].getTab());
			
			if(coin_mining)
				tabs[a].add(coin_mining_instance[a].getTab());

			System.out.println("================================================");
		}
		
		
		System.out.println("Accounts done: "+done+"\nAccount undone: "+undone+"\nTaking a rest for next round");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		
		try {
			Thread.sleep((sleep*1000*60*60)+5000);
		}catch(Exception e) {
			
		}
		
		
		for( a=0;a<accounts_count;a++) {
			browsers[a].quit();
		}
		
		
		}
		
		
		// stop process
		
		

		
	}
	
	
	

}
