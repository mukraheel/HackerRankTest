package Com.HackerRankTest.TestCase;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.HackerRankTest.PageObject.LoginPage;


public class LoginTest extends BaseClass {
	
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
