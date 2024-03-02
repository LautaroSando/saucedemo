package TA.Challenge_LS;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CapturaDePantalla {
	static String captura ="..\\Challenge-LAUTAROS\\Capturas\\";
	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
	
	public static void capturaPantalla(WebDriver driver) {
	
	File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(screen,new File(captura+"Error"+"_"+LocalDateTime.now().format(formato)+".png")); 
	} catch (IOException p) {
		p.printStackTrace();
	}

}
}
