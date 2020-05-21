package Com.HackerRankTest.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Com.HackerRankTest.PageObject.LoginPage;


public class LoginTest extends BaseClass {
	
	public void updateproFile(String value, String Case, String status) throws IOException {

		// create object of faker which was added into POM.xml
		Faker faker = new Faker();

		// to Generate random data for test case process
		String Firstname = faker.name().firstName();
		String Password = faker.name().lastName();
		
		String Emailaddress = Firstname  + "@gmail.com";
		
		// create object for read and write RandomData properties file as input and output stream
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;
        
        // create object of properties class for set key and value into the properties file 
            Properties configProperty = new Properties();
  
            // load RandomData properties for update and create key values
            File file = new File("./configs/RandomData2.properties");
            fileIn = new FileInputStream(file);
            configProperty.load(fileIn);
            configProperty.setProperty("Firstname", Firstname);
    		configProperty.setProperty("Password", Password);
    		configProperty.setProperty("Emailaddress", Emailaddress);
    		
            fileOut = new FileOutputStream(file);
            configProperty.store(fileOut, null);
            fileIn.close();
           

	}
	
	@Parameters({ "url1" })
	@Test
	public void loginTest(String url)
	{
		
		
		logger.info("URL is hit");
		
		LoginPage lp = new LoginPage(driver,url);
		
		lp.loginlink();
		lp.setUserName(UserName);
		lp.setPasswoard(Passwoard);
		lp.clickBtn();
		
		logger.info("Click on Submit Button");
		
		if(driver.getTitle().equals(""))
		{
			Assert.assertTrue(true);
			logger.info("inside true condition");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("inside false condition");
		}
			
	}

}
