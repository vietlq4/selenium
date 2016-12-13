package testcase;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_Element.element;
import DB.DB_login;
import Data.ExcelDataConfig;
import Page.Result_login;
import Page.login_page;
import Property.read_property;
import log.log;

public class login_test extends element {
	
	
	read_property pro = new read_property();
	private login_page oblogin = new login_page();
	DB_login db_login = new DB_login();
	private static Logger log = Logger.getLogger(log.class.getName());

	@Test(dataProvider="loginData")

	public void f(String user ,String pass) {
		log.info("=== run test case =====");
		oblogin.stwich_iframe();
		oblogin.login(user, pass);
		oblogin.back_iframe();
		DOMConfigurator.configure("log4j.xml");
 
		Result_login data = db_login.query(user);
		
		// Check user is found 
		if (data != null) {
			data.getFullname();
			data.getRole();
			System.out.println(data.getRole());
				Assert.assertEquals(data.getFullname(),oblogin.get_Assert_fullname());//check full name
				Assert.assertEquals(data.getRole(),oblogin.get_Assert_rule() );//check role
				//data= 1
				Assert.assertEquals("Operations",oblogin.get_check_page());// check page
				
		}
		log.info("=== end test case ====");

	}
	@BeforeClass
	public void beforeMethod() {
		// oblogin.gotourl(url);
		new element();
		oblogin.gotourl();
	}

	@AfterMethod
	public void afterMethod() throws Exception {
          
		oblogin.quit("login");
		

	}
	@DataProvider(name="loginData")
	public Object [][]passdata()
	{
		ExcelDataConfig config = new ExcelDataConfig("E:/DATA LEARNING/Selenium/traning/ANTS_DEMO/Data_Test/login.xlsx");
		int row = config.getrowcount(0);
		 Object[][] data = new Object[row][2];
		 for(int i =0;i<row;i++ ) 
		 {
			 data[i][0]=config.getdata(0, i, 0);
			 data[i][1]=config.getdata(0, i, 1);
			 System.out.println("gia tri "+config.getdata(0, i, 0));
			 System.out.println("gia tri "+config.getdata(0, i, 1));
		 }
		return data;
	}
}
