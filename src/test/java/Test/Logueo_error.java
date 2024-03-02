package Test;
import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import TA.Challenge_LS.CapturaDePantalla;
import TA.Challenge_LS.Logueo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Logueo_error {
	
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		
		//Utilizando el navegador chrome para la ejecución.
		String URL = "https://www.saucedemo.com/";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}
	@Test (description = "01_Loguear Usuario invalido")
	public void usuarioInvalido() throws InterruptedException {
					
		Logueo eusuario = new Logueo(driver);
		eusuario.escribirUsuario("falso");
		eusuario.escribirContraseña("secret_sauce");
		eusuario.BtnLogin();		
		WebElement t1 = driver.findElement(By.cssSelector("h3[data-test='error']"));
		Assert.assertEquals(t1.getText(),"Epic sadface: Username and password do not match any user in this service");
		
	}
	@Test (description = "02_Loguear contraseña invalida")
	public void contraseñaInvalida() {
		
		driver.navigate().refresh();				
		Logueo eusuario = new Logueo(driver);
		eusuario.escribirUsuario("standard_user");
		eusuario.escribirContraseña("pw123");
		eusuario.BtnLogin();		
		WebElement t1 = driver.findElement(By.cssSelector("h3[data-test='error']"));
		Assert.assertEquals(t1.getText(),"Epic sadface: Username and password do not match any user in this service");	
		
	}
	
	@Test (description = "03_Loguear ingresando solo usuario")
	public void loguearIngresandoUsuario() throws InterruptedException, IOException {
		
		driver.navigate().refresh();				
		Logueo eusuario = new Logueo(driver);
		eusuario.escribirUsuario("standard_user");
		eusuario.escribirContraseña("");
		eusuario.BtnLogin();
		WebElement t1 = driver.findElement(By.cssSelector("h3[data-test='error']"));
		Assert.assertEquals(t1.getText(),"Epic sadface: Password is required");	
		
	}
	@Test (description = "04_Loguear ingresando solo contraseña")
	public void loguearIngresandoContraseña() throws InterruptedException, IOException {
		
		driver.navigate().refresh();		
		Logueo eusuario = new Logueo(driver);
		eusuario.escribirUsuario("");
		eusuario.escribirContraseña("secret_sauce");
		eusuario.BtnLogin();
		WebElement t1 = driver.findElement(By.cssSelector("h3[data-test='error']"));
		Assert.assertEquals(t1.getText(),"Epic sadface: Username is required");		
		
	}
	
	//Se realiza la captura de pantalla en caso de fallar el test
		@SuppressWarnings("static-access")
		@AfterMethod
		public void capturaPantalla( ITestResult result) {
		
		if(result.isSuccess()) {
			CapturaDePantalla cap = new CapturaDePantalla();
			cap.capturaPantalla(driver);	
	}
		
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
