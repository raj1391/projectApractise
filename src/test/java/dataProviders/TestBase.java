package dataProviders;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.NotConnectedException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase extends ConfigFileReader {

	public static WebDriver driver ; 
	ConfigFileReader config1 = new ConfigFileReader ();
	@BeforeTest
	@Parameters("browser")
	
	public void preSetupBrowser (String browser ) throws WebDriverException, InterruptedException, NotConnectedException
	
	{
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver	",	config1.getDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\Download\\Chrome\\SeleniumServers\\IEDriverServer.exe");
			System.out.println("A");
			Thread.sleep(10);
			System.out.println("sleep");
			driver = new InternetExplorerDriver();
			System.out.println("B");
		}
		
		else if (browser.equalsIgnoreCase("edge"))
		{
			
			System.setProperty("webdriver.edge.driver", "E:\\Download\\Chrome\\SeleniumServers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		System.out.println("maximise window");
		driver.manage().timeouts().implicitlyWait(config1.getImplicitlyWait(), TimeUnit.SECONDS);
		System.out.println("set implicit wait to 30s");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

	@AfterMethod
	public void screenShotsFailure(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
			{
		
				try {
					TakesScreenshot shots = (TakesScreenshot)driver;
					File src = shots.getScreenshotAs(OutputType.FILE);
					File dest = new File ("./Screenshots/" + result.getName() + ".png");
					FileUtils.copyFile(src, dest);
					System.out.println("screenshots cpied succesfully");
				}
				
				catch (Exception e )
				{
					System.out.println("Exception while captuirng screenshot" + e.getMessage());
				}
				
			}
		
	}
}
