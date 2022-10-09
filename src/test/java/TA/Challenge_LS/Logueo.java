package TA.Challenge_LS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logueo {
	
	@FindBy(css= "#user-name")
	WebElement txtuser;
	
	@FindBy(css= "#password")
	WebElement txtpassw;
	
	@FindBy(css="#login-button")
	WebElement btnlogin;
	
	@FindBy(xpath = "//div[@class='error-message-container error']")
	WebElement msgerror;
	
	@FindBy(css = "h3[data-test='error']")
	WebElement txtuserbloq;
	
	public Logueo(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void escribirUsuario(String usuario) {
		
		txtuser.sendKeys(usuario);		
	}
	
	public void escribirContraseña(String contraseña) {
		
		txtpassw.sendKeys(contraseña);	
	}
	
	public void BtnLogin() {
		
		btnlogin.sendKeys(Keys.ENTER);
	}
	
	public String msgError() {
		
		return msgerror.getText();
	}

	public void userBloq() {
		txtuserbloq.findElement(By.cssSelector("h3[data-test='error']"));
	}
}
