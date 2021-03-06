package Com.HackerRankTest.TestCase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com.HackerRankTest.Utility.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

ReadConfig objReadConfig = new ReadConfig();
	
	
	
	public String Url = objReadConfig.geturl();

	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeSuite
	public void testBeforeSuite() {
		System.out.println("BeforeSuite()");
	}
	
	@BeforeTest
	public void setExtent() 
	{
		System.out.println("BeforeTest()");
	}
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		System.out.println("BeforeClass()");
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new   ChromeDriver();
			
		} else if(br.equals("firefoxdriver"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new   FirefoxDriver();
		} else if (br.equals("ie"))
		{
			
			System.setProperty("webdriver.ie.driver",objReadConfig.getIEPath());
			driver = new InternetExplorerDriver();
			
		}
		
		driver.get(Url);
	}
	
	@BeforeMethod
	public void Setup()
	{
		
		System.out.println("BeforeMethod()");
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		System.out.println("AfterMethod()");
		
		
		driver.quit();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("AfterClass()");
		if(driver!=null)
			driver.close();
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("AfterTest()");
		
	}

	@AfterSuite
	public void testAfterSuite() {
		System.out.println("AfterSuite()");
	}
	
	
}
