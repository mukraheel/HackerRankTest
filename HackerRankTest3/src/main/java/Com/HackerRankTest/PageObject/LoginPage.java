package Com.HackerRankTest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver lwebdrive;
	
	public LoginPage(WebDriver rdriver, String Url)
	{
		lwebdrive = rdriver;
		lwebdrive.get(Url);
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button")
	WebElement loginlink;
	
	@FindBy(id="join_neu_email_field")
	WebElement txtusername;
	
	@FindBy(id="join_neu_password_field")
	WebElement txtpassword;
	
	@FindBy(name="submit_attempt")
	WebElement btnLogin;
	
	public void setUserName(String username)
	{
		txtusername.sendKeys(username);
	}
	
	public void setPasswoard(String userPass)
	{
		txtpassword.sendKeys(userPass);
	}
	
	public void clickBtn()
	{
		btnLogin.click();
	}
	
	public void loginlink()
	{
		loginlink.click();
	}
}
