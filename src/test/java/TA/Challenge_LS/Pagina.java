package TA.Challenge_LS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagina{
	
	String URL = "https://www.saucedemo.com/";
	WebDriver driver;
	
public void abrirPagina() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
	
	}
} 