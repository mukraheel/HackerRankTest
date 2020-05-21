package Com.HackerRankTest.TestCase;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com.HackerRankTest.Utility.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

ReadConfig objReadConfig = new ReadConfig();
	
	
	
	public String Url = objReadConfig.geturl();
	public String UserName = objReadConfig.getusername();
	public String Passwoard = objReadConfig.getpasswoard();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeSuite
	public void testBeforeSuite() {
		System.out.println("BeforeSuite()");
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
		logger = Logger.getLogger("Hacker Rank Test");
		PropertyConfigurator.configure("log4j.properties");
		System.out.println("BeforeMethod()");
		
		
	}
}