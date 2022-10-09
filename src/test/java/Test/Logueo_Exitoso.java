package Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import TA.Challenge_LS.CapturaDePantalla;
import TA.Challenge_LS.Logueo;

public class Logueo_Exitoso {
	
	WebDriver driver;
	
	//Se ejecuta el navegador
	@BeforeSuite
	public void abrirPagina() {
		
		String URL = "https://www.saucedemo.com/";	
		
		//Utilizando el navegador chrome para la ejecución.
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Descomentar para utilizar navegador firefox y comentar las lineas 26 y 27.
		/*WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();*/
				
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	//Se realiza el logueo|
	@Test (description = "01_Loguear exitosamente")
	public void loguear() throws InterruptedException, IOException {
			
		Logueo eusuario = new Logueo(driver);
		eusuario.escribirUsuario("standard_user");
		eusuario.escribirContraseña("secret_sauce");
		eusuario.BtnLogin();
		
		AssertJUnit.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl() );		
		
	}
	//Se realiza la captura de pantalla en caso de fallar el test
	@SuppressWarnings("static-access")
	@AfterMethod
	public void capturaPantalla( ITestResult result) {
		
		if(!result.isSuccess()) {
			CapturaDePantalla cap = new CapturaDePantalla();
			cap.capturaPantalla(driver);	
	}
		
	}
	//Cierra el navegador
	@AfterSuite
	public void cerrarNavegador()  {
					
		driver.close();
	}
}
