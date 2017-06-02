package Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_signin extends pf_genericmethods{

	@FindBy(linkText="Sign In")
	public WebElement sigin;
	
	@FindBy(name="logid")
	public WebElement uid;
	
	@FindBy(name="pswd")
	public WebElement pwd;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	public WebElement submitbtn;
	
	@FindBy(xpath="//b[contains(text(),'Sorry we were unable to complete this step because :')]")
	public WebElement exp_msg;
	
	@FindBy(className="proper")
	public WebElement msg_uname;
	
	public pf_signin(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void cl_click(){
		System.out.println("I am in cl_click method");
		clk(sigin);
	}
	

	public void login(String ud, String pd) {
		
		System.out.println("Login method executed in pfsignin");
		gen_login(uid,ud);
		gen_login(pwd,pd);
		clk(submitbtn);
	}
}


