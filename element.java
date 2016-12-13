package Base_Element;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import log.log;

public class element {
	   
	    public static WebDriver driver ;
        public static Logger Logger ;
		
		public Logger app_log= Logger.getLogger("Testslog");
		public element() {
			  driver = new FirefoxDriver() ;
				
			   Logger app_log= Logger.getLogger("Testslog");
			System.setProperty("org.apache.commons.logging.log","org.apache.commons.logging.impl.Jdk14logger");
			
		}
		/*--------geturl------------*/
	public void geturl (String url)
	{
		driver.get(url);
	}
		                                     /*--------CLICK------------*/
	
	public void ClickByid(String locator){ // click on 1 element id
		try {
		driver.findElement(By.id(locator)).click();
		}
		catch(Throwable e){
			app_log.debug("Fail:: don't find key  "+locator);
		}
	}
	public void ClickByCss(String locator){ // click on 1 element id
	
		driver.findElement(By.cssSelector(locator)).click();
		//driver.findElement(By.cssSelector("button.btn-green")).click();
		
		
	}
	public void ClickByXpath(String locator){ // click on 1 element xpath
		// click on 1 element
		driver.findElement(By.xpath(locator)).click();;
		                               /*--------Send Key ------------*/
	}
	public void SendKeyById(String locator, String value){
		// fill data at fill text
		driver.findElement(By.id(locator)).sendKeys(value);
		}
	public void SendKeyByXpath(String locator, String value){
		// fill data at fill text
		driver.findElement(By.xpath(locator)).sendKeys(value);
		}
	public void SendKeyByname(String locator, String value){
		// fill data at fill text
		driver.findElement(By.name(locator)).sendKeys(value);
		}
	public void SendKeyByCss(String locator, String value){
		// fill data at fill text
		driver.findElement(By.cssSelector(locator)).sendKeys(value);
		}
	                      /*--------clear field ------------*/
	
	public void ClearbyCss(String locator){
		// fill data at fill text
		driver.findElement(By.cssSelector(locator)).clear();
		}

	public void ClearbyName(String locator){
		// fill data at fill text
		driver.findElement(By.name(locator)).clear();
		}
	public String GetMessageById(String locator){ // fill data at fill text
		return driver.findElement(By.id(locator)).getText();
		}
	                           /*--------clear field ------------*/
	public String Gettextbyxpath(String locator){ // fill data at fill text
		return driver.findElement(By.xpath(locator)).getText();
		}
	public void close(){
		 try { 
		        if (driver != null) { 
		            driver.close(); 
		        } 
		    } catch (Exception e) { 
		        System.out.println(e.getMessage()); 
		        log.info("close sucessfully ");
		    }
		    //driver = null;
	 }
	public void Open(String URL){
		driver.get(URL);
	 }
	
	public void waituntilById(String locator){
		(new WebDriverWait(driver, 20))
				   .until(ExpectedConditions.elementToBeClickable(By.id(locator)));
	}
	public void waituntilByXpath(String locator){
		(new WebDriverWait(driver, 20))
				   .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	public void waituntilByXpaths(String locator){
		(new WebDriverWait(driver, 60))
				   .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	public void waituntilByName(String locator){
		(new WebDriverWait(driver, 20))
				   .until(ExpectedConditions.elementToBeClickable(By.name(locator)));
	}
	
public void waituntilByCss(String locator){
	(new WebDriverWait(driver, 20))
			   .until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
}
                     /*--------Switch  iframe ------------*/
	public void Switchiframe(String xpath)//Switch iframe by xpath
	{
		  driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
	}
	public void back_frame()//Switch iframe by xpath
	{
		driver.switchTo().defaultContent();
	}
}
	
