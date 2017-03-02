package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import config.Configuration;

public class Driver {
 
	public static WebDriver Instance = null;
	
	public static void Initialize() {
		if(Instance == null) {
			System.out.println("Initializing Driver");
			
				if(Configuration.Browser.browser.equalsIgnoreCase("ff")) {
					System.out.println("Initializing Driver Firefox");
					System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe"); 
					Instance=new FirefoxDriver();
				}
				else if (Configuration.Browser.browser.equalsIgnoreCase("chrome")) {
					System.out.println("Initializing Driver Chrome");
					System.setProperty("webdriver.chrome.driver", "./Drivers/ChromeDriver.exe"); 
					Instance=new ChromeDriver();
					
				} else {
					System.out.println("Initializing Driver BROWSER");
				}
			
		} else {
			System.out.println("NOT Initializing Driver");
		}
		
	}
	
	public static void winmax() {
		Instance.manage().window().maximize();
	}
	public static void close() {
		System.out.println("Closing browser");
		Instance.close();
		Instance=null;
	}
	
	public static void quit() {
		System.out.println("Quitting browser");
		Instance.quit();
		Instance=null;
	}
}
