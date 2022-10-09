package TA.Challenge_LS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Navegador {
	
	String URL = "https://www.saucedemo.com/";
	String Chromepath = "..\\Challenge-LS\\Driver\\chromedriver106.0.5249.61.exe";
	String firefoxpath = "..\\Challenge-LS\\Driver\\geckodriver0.31.0.exe";
	public static WebDriver driver;
	
@BeforeClass
@Parameters({"URL","BrowserType"})
	public void chromeNaveg () {
		
		System.setProperty("webdriver.chrome.driver", Chromepath);
		driver = new ChromeDriver();
		
	}
	public void firefoxNaveg() {
		System.setProperty("webdriver.gecko.driver", firefoxpath);
		driver = new FirefoxDriver();
		
	}
	
	public void configNavegador() {
		driver.get (URL);		
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
	}
	
}
