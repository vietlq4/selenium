package Page;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Base_Element.element;
import Property.read_property;
import log.log;

public class Page_line_item extends login_page {

	
	read_property pro = new read_property();
	private static Logger log = Logger.getLogger(log.class.getName());
	
	String _click_create_x = pro.readbylocator("click_xpath");
	String _click_network_x = pro.readbylocator("click-network-xpath");
	String _input_name_x = pro.readbylocator("input-name-xpath");
	String _choice_locatorVN_x = pro.readbylocator("choice-vietnam-xpath");
	String _input_budget_x = pro.readbylocator("input-budget-xpath");
	String _click_save_c = pro.readbylocator("click-save-css");
	String _open_dynamic_x = pro.readbylocator("click_dynamic_x");
	String _check_dynamic_x = pro.readbylocator("check_dynamic_x");
	String _Dopen_delivery_x = pro.readbylocator("click_delivery_x");
	String _Dno_viewable_x = pro.readbylocator("Dno_viewable_x");
	String _Dviewable_x = pro.readbylocator("click_delivery_x");
	String _Dviewable_input_x = pro.readbylocator("Dviewable_input_x");
	String _Daccelerated_x = pro.readbylocator("Daccelerated_x");
	String _Dstandard_x = pro.readbylocator("Dstandard_x");
	String _Device_x = pro.readbylocator("Device_x");
	String _Device_edit_x = pro.readbylocator("Device_edit_x");
	String _Device_computer_x = pro.readbylocator("Device_computer_x");
	String _Device_mobile_x = pro.readbylocator("Device_mobile_x");
	String _Device_table_x = pro.readbylocator("Device_table_x");
	String _URL_x = pro.readbylocator("URL_x");
	String _URL_name_x = pro.readbylocator("URL_name_x");
	String _URL_value_x = pro.readbylocator("URL_value_x");
	String _kind_budget_x = pro.readbylocator("kind_budget_x");
	String _life_time_budget_x = pro.readbylocator("life_time_budget_x");
	String _get_nameline_x = pro.readbylocator("get_nameline_x");
	String _plan_time_start_x = pro.readbylocator("plan_time_start_x");
	String _plan_time_end_x = pro.readbylocator("plan_time_end_x");
	String _Plan_select_x = pro.readbylocator("Plan_select_x");

	String user = pro.readbylocator("email_name");
	String pass = pro.readbylocator("password_name");
	String url = pro.readbylocator("url");
	String ifamre = pro.readbylocator("iframe_xpath");
	String buttoncss = pro.readbylocator("button_css");

	public void input_username(String datauser) {
		 DOMConfigurator.configure("log4j.xml");
		myAction.waituntilByName(user);
		myAction.ClearbyName(user);
		myAction.SendKeyByname(user, datauser);
       log.info("input user "+datauser);
	}

	public void GetErroruser(String GetErroruser) {
		myAction.GetMessageById(GetErroruser);
	}

	public void input_password(String datauserpass) {
		myAction.waituntilByName(pass);
		myAction.ClearbyName(pass);
		myAction.SendKeyByname(pass, datauserpass);
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
	}

	public void login(String datauser, String datauserpass) {

		this.input_username(datauser);
		this.input_password(datauserpass);
		this.click_login();
	}

	public void gotourl() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		myAction.geturl(url);

	}

	public void stwich_iframe() {
		myAction.waituntilByXpath(ifamre);
		myAction.Switchiframe(ifamre);
   }

	public void back_iframe() {
		myAction.back_frame();
  }

	public void click_new_item() {
		myAction.waituntilByXpath(_click_create_x);
		myAction.ClickByXpath(_click_create_x);
  }
	public void close() {
		//TSS.takeScreenShotFF(driver, locator);
		myAction.close();
	}

	public void click_choice_network() {
		myAction.waituntilByXpath(_click_network_x);
		myAction.ClickByXpath(_click_network_x);

	}
	

	public void input_name(String name) { // -----INput NAME
		myAction.waituntilByXpath(_input_name_x);
		myAction.SendKeyByXpath(_input_name_x, name);
	}

	public void choice_VN(String locator_taget) { // ----- locator_taget
		if (locator_taget.equals("VN")) {
			myAction.waituntilByXpath(_choice_locatorVN_x);
			myAction.ClickByXpath(_choice_locatorVN_x);
			  log.info("String locator_taget"+locator_taget);
		}
	}

	public void input_budget(String budget, String kind) {
		if (kind.trim().equals("lifetime")) {
			myAction.waituntilByXpath(_kind_budget_x);// click kind of payment
			myAction.ClickByXpath(_kind_budget_x);

			myAction.waituntilByXpath(_input_budget_x);
			myAction.SendKeyByXpath(_input_budget_x, budget);

			myAction.waituntilByXpath(_life_time_budget_x);
			// click kind of payment
			myAction.ClickByXpath(_life_time_budget_x);
		}
	}

	public void click_save() {
		myAction.waituntilByCss(_click_save_c);
		myAction.ClickByCss(_click_save_c);
	}

	public void dynamic_check(String checkdynamic) { // Dynamic Line Item
														// settings
		if (checkdynamic.toLowerCase().equals("yes")) {
			myAction.waituntilByXpath(_open_dynamic_x);
			myAction.ClickByXpath(_open_dynamic_x);
			myAction.waituntilByXpath(_check_dynamic_x);
			myAction.ClickByXpath(_check_dynamic_x);
			myAction.ClickByXpath(_open_dynamic_x);// to close
		}
	}

	public void Line_Item_delivery(String check, String value) {
		if (check != "") {
			myAction.waituntilByXpath(_Dopen_delivery_x);
			myAction.ClickByXpath(_Dopen_delivery_x);

			myAction.waituntilByXpath(_Dno_viewable_x);// click no viewable
			myAction.ClickByXpath(_Dno_viewable_x);

			myAction.waituntilByXpath(_Dviewable_x);
			myAction.ClickByXpath(_Dviewable_x);// click viewable impressions

			myAction.waituntilByXpath(_Dviewable_input_x);// input viewable
															// impressions
			myAction.SendKeyByXpath(_Dviewable_input_x, value);

			myAction.waituntilByXpath(_Daccelerated_x);// check Accelerated:
														// Show creatives as
														// quickly as reasonably
														// possible
			myAction.ClickByXpath(_Daccelerated_x);

			myAction.waituntilByXpath(_Dstandard_x);// check Standard: Show
													// creatives evently
													// overtime
			myAction.ClickByXpath(_Dstandard_x);
		}
		myAction.ClickByXpath(_Dopen_delivery_x);// click to close delivery
	}

	public void Check_Device(String un_computer, String un_device, String un_mobile) {
		myAction.waituntilByXpath(_Device_x);// click onpen _Device
		myAction.ClickByXpath(_Device_x);

		myAction.waituntilByXpath(_Device_edit_x);
		// click to _Device edit
		myAction.ClickByXpath(_Device_edit_x);
		if (un_computer.equals("no")) {
			myAction.waituntilByXpath(_Device_computer_x);// click to uncheck
															// computer
			myAction.ClickByXpath(_Device_computer_x);
		}
		if (un_mobile.equals("no")) {
			myAction.waituntilByXpath(_Device_mobile_x);// click to uncheck
														// mobile
			myAction.ClickByXpath(_Device_mobile_x);
		}
		if (un_device.equals("no")) {
			myAction.waituntilByXpath(_Device_table_x);// click to uncheck table
			myAction.ClickByXpath(_Device_table_x);

		}
		myAction.ClickByXpath(_Device_x);// click to close
	}

	public void _url(String name, String value) {
		myAction.waituntilByXpath(_URL_x);// click to open
		myAction.ClickByXpath(_URL_x);

		myAction.waituntilByXpath(_URL_name_x);
		myAction.SendKeyByXpath(_URL_name_x, name);// input name

		myAction.waituntilByXpath(_URL_value_x);
		myAction.SendKeyByXpath(_URL_value_x, value);// input value
	}


	public String get_name_line() {
		myAction.waituntilByXpath(_get_nameline_x);
		String text = myAction.Gettextbyxpath(_get_nameline_x);
		return text;
	}

	public void click_operator() { // click_operator to check name
		myAction.waituntilByXpath("//*[@class='main-nav']//li[2]/a)[1]");
		myAction.ClickByXpath("//*[@class='main-nav']//li[2]/a)[1]");

	}

	public void set_time(String day) {
		if(day.equals("null")){
			return;
		}
		else{
		String start ="(//*[@class='start-time']//input)[1]";
		String end ="(//*[@class='start-time']//input)[2]";
		myAction.waituntilByXpath(_Plan_select_x);
		myAction.ClickByXpath(_Plan_select_x);
		
		myAction.waituntilByXpath(start);       // click input start 
		myAction.ClickByXpath(start);
		
		String start_day = "(.//*[@id='ui-datepicker-div']/table/tbody//a)[" + day + "]";
		myAction.waituntilByXpath(start_day);
		myAction.ClickByXpath(start_day);
		
		myAction.waituntilByXpath(end);       // click input end 
		myAction.ClickByXpath(end);
		
		String end_day ="(.//*[@id='ui-datepicker-div']/table/tbody//a)["+day+"]";
		myAction.waituntilByXpath(end_day);
		myAction.ClickByXpath(end_day);
		}
	}
}
