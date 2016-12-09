package projeto;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public interface ConfigAppium {

	public static AndroidDriver openAplicationAndroid(String diretorioApp, String apk) throws MalformedURLException{
		
		File diretorioAplicacao = new File(diretorioApp);
		File arquivoAplicacao = new File(diretorioAplicacao, apk);
		
		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capacidade.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
		
		return driver;		
	}
}
