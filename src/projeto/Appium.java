package projeto;

import java.io.File;
import java.net.URL;

import javax.sql.rowset.spi.TransactionalWriter;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Appium {

	private WebDriver driver;
	
	@Before
	public void setUp () throws Exception{
	File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "Apps");
		File app = new File(appDir, "app-debug.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-Package", "br.com.lf.login");
		capabilities.setCapability("app-Activity", ".RootActivity");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}
	
	@Test
	public void teste(){
		WebElement el = driver.findElement(By.className("android.widget.EditText"));
		
	}
}
