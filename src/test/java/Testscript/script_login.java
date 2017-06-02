package Testscript;

import java.util.Map;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import Genericlibrary.Base;
import Pagefactory.pf_signin;

public class script_login extends Base {
	
	
	
	@Test(dataProvider ="validLogin", dataProviderClass=Dataprovider.dp_login.class,priority=2,groups={"Smk"})
	public void valid_Login(Map hm){
		
		String uid = hm.get("username").toString();
		String psd = hm.get("pwd").toString();
		String expmsg = hm.get("exp_msg").toString();	
		tcid = hm.get("TC_ID").toString(); // available in base.class. extend base to use varaibles declared
		order=hm.get("Order").toString();// available in base.class. 
		
		 startTest = extentReports.startTest(tcid+"_" + order + "_" + browser_type);  // available in base.class.
		 
		 pf_signin pf_si = new pf_signin(fd);
		 pf_si.cl_click();
		 pf_si.login(uid, psd);
		 String Act_msg =pf_si.msg_uname.getText();
		
		 if(Act_msg.equals(expmsg)){
			 startTest.log(LogStatus.PASS, "Validate Login msg","Passed"); //available in base.class
				
			}else{
				 startTest.log(LogStatus.FAIL, "Validate Login msg","Failed"); //available in base.class
				
			}
		
}
	@Test(dataProvider="invalidLogin",dataProviderClass=Dataprovider.dp_login.class,priority=1,groups={"Smk"})
	public void  invalid_Login(Map hm){
		
		//get username,passwd,expmessage and order,tcid ( use order and tcid varaible names declared as public in base) from hashmap and convert it to string
	 String uid = hm.get("username").toString();
	 String psd = hm.get("pwd").toString();
	 tcid = hm.get("TC_ID").toString();
	 String Exp_msg = hm.get("exp_msg").toString();
	 order = hm.get("Order").toString();
		//instantiate pf_signin
	 System.out.println("uid="+uid);
	 pf_signin pf_si = new pf_signin(fd);
	 //click on signin in https://shop.rediff.com/ home page
	pf_si.cl_click();
	// pf_si.signin.click();
	 
	 //enter uid and password by calling this function
	 pf_si.login(uid, psd);
	 System.out.println("pf_si.login called");
	 String Act_msg = pf_si.exp_msg.getText();
	 if(Act_msg.equals(Exp_msg)){
		
		 startTest = extentReports.startTest(tcid+"_" + order + "_" + browser_type);  // available in base.class.
		 startTest.log(LogStatus.PASS, "Invalidlogin", "TC pass");
	 }
	 
		
	}
}
