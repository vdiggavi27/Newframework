package Genericlibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {

	public WebDriver fd;
	public static ExtentReports extentReports;
	public ExtentTest startTest;
	public String tcid;
	public String order;
	public String browser_type;
	
	
	@BeforeSuite(groups={"Smk","UAT","Reg"})
	public void create_Report(){
		
		extentReports = new ExtentReports("E:\\reportfm.html",false);
		
	}
	
	@Parameters({"browser"})
	@BeforeMethod(groups={"Smk","UAT","Reg"})
	public void launchApp(String btype) throws Exception{
		browser_type=btype;
		if(btype.equals("ff")){
			
			fd=new FirefoxDriver();
		}else if(btype.equals("ch")){
			
			System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
			fd=new ChromeDriver();
		}else if(btype.equals("ie")){
			System.setProperty("webdriver.ie.driver", "E:\\drivers\\IEDriverServer.exe");
			fd=new InternetExplorerDriver();
			
		}
//		fd= new FirefoxDriver();
		fd.get(utility.getval(utility.getval("env")));
		fd.manage().window().maximize();
		fd.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
	}
	
	
	@AfterMethod(groups={"Smk","UAT","Reg"})
	public void cloaseApp(){	
		
		fd.close();
		
		extentReports.endTest(startTest);
		extentReports.flush();
		
	}
	
	
	
//	capture snapshot
	public String getScreenshot() throws Exception{
		
		TakesScreenshot sc=(TakesScreenshot)fd;
		File screenshotAs = sc.getScreenshotAs(OutputType.FILE);
		
		String fpath = utility.getval("Screenshot_path") + tcid + "_" + order + ".png";
		FileUtils.copyFile(screenshotAs, new File(fpath));
		return fpath;
				
	}
	


}










