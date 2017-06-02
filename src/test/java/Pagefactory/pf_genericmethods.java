package Pagefactory;

import org.openqa.selenium.WebElement;

public class pf_genericmethods {
	
	
	public void gen_login(WebElement el, String text){
		el.sendKeys(text);
	}
	
	
	
	public void clk(WebElement el){
	el.click();
	System.out.println("I am in clk method");
}
	
	
}