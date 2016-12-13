package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_Element.element;
import DB.DB_Create_Itiem;
import Data.ExcelDataConfig;
import Page.Page_line_item;
import Page.Result_LineItiem;
import Property.read_property;

public class line_item_test extends element {
	
	read_property pro = new read_property();
	private Page_line_item obLineItiem = new Page_line_item();
	DB_Create_Itiem db_Create_Itiem = new DB_Create_Itiem();

	@Test(dataProvider = "lineitem")
	public void fa(String user, String pass, String name, String budget, String kind, String checkdynamic,
			String un_computer, String un_device, String un_mobile, String locator_taget,String day) {
		// click create
		

		obLineItiem.stwich_iframe();
		obLineItiem.login(user, pass);
		obLineItiem.back_iframe();

		// Check user is found

		obLineItiem.click_new_item();
		obLineItiem.click_choice_network();// click choice network
		obLineItiem.input_name(name);
		obLineItiem.set_time(day);
		obLineItiem.input_budget(budget, kind);
		obLineItiem.choice_VN(locator_taget);
		obLineItiem.dynamic_check(checkdynamic);	
		obLineItiem.Check_Device(un_computer, un_device, un_mobile);
		
		obLineItiem.click_save();// click to save
		
		// obLineItiem
		Result_LineItiem data = db_Create_Itiem.query(user);
		if (kind.equals("daily")) {
          Assert.assertEquals(data.getDAILY_BUDGET(),budget);
		}
		else if (kind.equals("lifetime")){
			//Assert.assertEquals(data.getTOTAL_BUDGET(),"9999999999");
		}
		obLineItiem.click_operator();
		Assert.assertEquals(name, obLineItiem.get_name_line());
		System.out.println(data.getPROPERTIES());
		System.out.println(data.getLINEITEM_NAME());
	}

	@BeforeClass
	public void beforemethod() {
	   new element();
	   obLineItiem.gotourl();
		

	}
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(500);
		obLineItiem.close();

	}
	

	@DataProvider(name = "lineitem")
	public Object[][] lineitemdata() {
		int sheet = 0;
		ExcelDataConfig config = new ExcelDataConfig(
				"E:/DATA LEARNING/Selenium/traning/ANTS_DEMO/Data_Test/line_item.xlsx");
		int row = config.getrowcount(sheet);
		
		Object[][] data = new Object[row][11];
		for (int i = 0; i < row; i++) {
			System.out.println("gia tri cua i " + i);
			System.out.println("gia tri row " + row);
			data[i][0] = config.getdata(sheet, i, 0);
			data[i][1] = config.getdata(sheet, i, 1);
			data[i][2] = config.getdata(sheet, i, 2);
			data[i][3] = config.getdata(sheet, i, 3);
			data[i][4] = config.getdata(sheet, i, 4);
			data[i][5] = config.getdata(sheet, i, 5);
			data[i][6] = config.getdata(sheet, i, 6);
			data[i][7] = config.getdata(sheet, i, 7);
			data[i][8] = config.getdata(sheet, i, 8);
			data[i][9] = config.getdata(sheet, i, 9);
			data[i][10] = config.getdata(sheet, i, 10);
			//data[i][11] = config.getdata(sheet, i, 11);
			System.out.println("gia tri" + config.getdata(0, i, 0));
			System.out.println("gia tri" + config.getdata(0, i, 1));
			System.out.println("gia tri" + config.getdata(0, i, 2));
			System.out.println("gia //,tri" + config.getdata(0, i, 3));
			System.out.println("gia tri" + config.getdata(0, i, 4));
			System.out.println("gia tri" + config.getdata(0, i, 5));
			System.out.println("gia tri" + config.getdata(0, i, 6));
		}
		return data;
	}
	
}
