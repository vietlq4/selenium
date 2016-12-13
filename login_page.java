package Page;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Base_Element.element;
import Base_Element.takeScreenShot;
import Property.read_property;
import log.log;

public class login_page extends element {
	takeScreenShot TSS = new takeScreenShot();
	public element myAction ;
	// String a= "dsadsjahj";
	read_property pro = new read_property();
	String user = pro.readbylocator("email_name");
	String pass = pro.readbylocator("password_name");
	String url = pro.readbylocator("url");
	String ifamre = pro.readbylocator("iframe_xpath");
	String buttoncss = pro.readbylocator("button_css");
	String _click_create_x = pro.readbylocator("click_xpath");

	public void click_new_item (){
		myAction.waituntilByXpaths(_click_create_x);
		myAction.ClickByXpath(_click_create_x);
			
	}
	public void input_username(String datauser) {
		myAction.waituntilByName(user);
		myAction.ClearbyName(user);
		myAction.SendKeyByname(user, datauser);
		
	}
	public void GetErroruser(String GetErroruser) {
		myAction.GetMessageById(GetErroruser);
	}

	public void input_password(String datauserpass) {
		myAction.waituntilByName(pass);
		myAction.ClearbyName(pass);
		myAction.SendKeyByname(pass, datauserpass);
		log.info("My Account link element found");

	}

	public void GetErrorpass(String GetErrorpass) {
		myAction.GetMessageById(GetErrorpass);
	}

	public void GetError(String GetError) {
		myAction.GetMessageById(GetError);
	}

	public void click_login() {
		// myAction.waituntilByCss(buttoncss);
		myAction.ClickByCss(buttoncss);
		log.info("My Account link element found");
	}

	public void login(String datauser, String datauserpass) {

		this.input_username(datauser);
		this.input_password(datauserpass);
		this.click_login();
		log.info("My Account link element found");
		log.info("My Account link element found");
	}

	public void gotourl() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		myAction.geturl(url);

	}

	public void quit(String locator) throws IOException {
		TSS.takeScreenShotFF(driver, locator);
		myAction.close();
	}

	public void stwich_iframe() {
		myAction.waituntilByXpath(ifamre);
		myAction.Switchiframe(ifamre);

	}

	public void back_iframe() {
		myAction.back_frame();

	}
  public String get_Assert_fullname()
  { String locator= "//*[@id='wrapper']//span[1]/strong";
	  myAction.waituntilByXpath(locator);
	  String Assert_fullname =myAction.Gettextbyxpath(locator);
	  return Assert_fullname;
  }
  public String get_Assert_rule()
  { String locator= "//*[@id='wrapper']//span[1]/span/span";
     String Assert_rule;
	  myAction.waituntilByXpath(locator);
	  String a =myAction.Gettextbyxpath(locator);
	  if (a=="Support")
	  {
		  Assert_rule ="2";
	  }
	  else{
		  Assert_rule ="1";
	  }
	  return Assert_rule;
  }
  public String get_check_page()
  { String locator= "//*[@id='wrapper']//li[2]/a";
	  myAction.waituntilByXpath(locator);
	  String check_page;
	  check_page  =myAction.Gettextbyxpath(locator);
	  
	 
	  return check_page;
  }
}
