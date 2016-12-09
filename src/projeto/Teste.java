package projeto;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Teste {

	public String caminhoApk = "C:\\app", apk = "login.apk";
	AndroidDriver driver;

	
	@Test
	public void loginFacebook() throws IOException{
		//configAppium = new ConfigAppium();
		driver = ConfigAppium.openAplicationAndroid(caminhoApk, apk);
		
		useLoginFacebook(driver, "lf.fernandosantos@gmail.com", "123456");
		
		String nomeTeste = "loginFacebook";
		String textoEsperado = "Bem vindo";
		
		assertTrue(verificaStatusTeste(driver, "buttonSair", textoEsperado));
		
		tirarScreenshot(driver, nomeTeste);
		
		
		
		
	}


	private Boolean verificaStatusTeste(AndroidDriver driver2, String element, String textoEsperado) {
		
		
		WebDriverWait wait = new WebDriverWait(driver2, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
		
		Boolean msg = driver2.getPageSource().contains("Bem vindo");
		
		return msg;
	}


	private void aguardar(String string) {
		
		
	}


	private void useLoginFacebook(AndroidDriver driver2, String login, String senha) throws MalformedURLException {
		String idGoSingIn = "alreadyRegistered";
		clickItemId(idGoSingIn);
		driver2.findElement(By.id("edtEmailLogin")).sendKeys(login);
		driver2.findElement(By.id("edtPasswordLogin")).sendKeys(senha);
		driver2.findElement(By.id("btnSingin")).click();
	}


	private void tirarScreenshot(AndroidDriver driver2, String nomeTeste) throws IOException {
		File screenshot = new File(nomeTeste+".png");
		File tmpScreenshot = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(tmpScreenshot, screenshot);
		System.out.println("Salvo em: "+ screenshot.getAbsolutePath());
		
	}


	private void clickItemId(String idGoSingIn) throws MalformedURLException {
		driver.findElement(By.id("alreadyRegistered")).click();
		
	}
	
	

}
