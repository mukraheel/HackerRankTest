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
	
	@FindBy(xpath="//*[@id=\"join-neu-form\"]/div[1]/div/div[1]/div/button")
	WebElement Reglink;
	
	
	@FindBy(id="join_neu_email_field")
	WebElement txtEmailaddress;
	
	@FindBy(id="join_neu_first_name_field")
	WebElement txtFirstname;
	
	@FindBy(id="join_neu_password_field")
	WebElement txtPassword ;
	
	@FindBy(name="submit_attempt")
	WebElement btnLogin;
	
	public void setEmailaddress(String username)
	{
		txtEmailaddress.sendKeys(username);
	}
	
	public void setFirstname(String username)
	{
		txtFirstname.sendKeys(username);
	}
	
	public void setPasswoard(String userPass)
	{
		txtPassword.sendKeys(userPass);
	}
	
	public void clickBtn()
	{
		btnLogin.click();
	}
	
	public void loginlink()
	{
		loginlink.click();
	}
	
	public void Reglink()
	{
		Reglink.click();
	}
}
