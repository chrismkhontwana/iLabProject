/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilab;

import java.io.File;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author chrismkhontwana
 */
public class SeleniumActions 
{
    public static WebDriver driver;
    TestData data = new TestData();
    String testfile =  System.getProperty("user.dir")+"/testData.txt";
    public static ExtentReports extent;
    public static ExtentTest test;
   
      public void startTesting(String testName)
      {
         startIlabReporting();
         test = extent.startTest(testName);
         data.readTxtFile(testfile);
         data.getTestData();
          
      }
    public void startBrowser(String browser)
    {
     
            if(System.getProperty("os.name").equalsIgnoreCase("windows"))
              {
                   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
         
                   System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver.exe");
              }
             
             else
               {
                 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver"); 
         
                 System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/geckodriver");
              }
            if(browser.equalsIgnoreCase("chrome"))
            {
              //Set and start chrome driver instance      
              driver = new ChromeDriver();
              driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

            }
            else if(browser.equalsIgnoreCase("firefox"))
            {
               
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            }
    }
    public boolean navigate(String url)
    {
        try
        {
          //Navigate to URL
           driver.navigate().to(url);
           driver.manage().window().maximize(); 
           return true;
        }
        catch(Exception e)
        {
            System.out.println("[ERROR] Failed to navigate to '"+url+"' - "+e);
            return false;
        }

              
    }
    public boolean userClick(By element)
    {
        try
        {
           waitForElement(element,15);
           driver.findElement(element).click();  
           return true;
        }
        catch(Exception e)
        {
            System.out.println("[ERROR] Failed to click '"+element+"'- "+e);
            return false;
        }

    }
        
    public boolean enterText(By element, String text)
    {
        try
        {
         waitForElement(element,15);
         driver.findElement(element).clear();
         driver.findElement(element).sendKeys(text);
         return true;
        }
        catch(Exception e)
        {
             System.out.println("[ERROR] Failed to enter '"+text+"' in '"+element+"' textbox - "+e);
            return false;
        }
    }
        
    public boolean waitForElement(By element, Integer timeout)
    {
        boolean elementFound = false;
        try
        {
            int waitCount = 0;
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            while (!elementFound && waitCount < timeout)
            {
                try
                {
                    WebDriverWait wait = new WebDriverWait(driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(element)) != null)
                    {
                        elementFound = true;
                        break;
                    }
                }
                catch (Exception e)
                {
                    elementFound = false;

                }
                waitCount++;
            }
        }
        catch (Exception e)
        {
            elementFound = false;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return elementFound;
    }
  
     
    public  boolean waitForElementToBeDisplayed(By element, Integer timeout)
    {
        boolean elementDisplayed = false;
        try
        {
            int waitCount = 0;
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            while (!elementDisplayed && waitCount < timeout)
            {
                try
                {
                    WebDriverWait wait = new WebDriverWait(driver, 1);

                    if ((driver.findElement(element).isDisplayed())== true)
                    {
                        elementDisplayed = true;
                        break;
                    }
                }
                catch (Exception e)
                {
                    elementDisplayed = false;

                }
                waitCount++;
            }
        }
        catch (Exception e)
        {
            elementDisplayed = false;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return elementDisplayed;
    }
    
    public boolean userClickByActions(By element)
    {
        try 
        {
          waitForElement(element,15);
          Actions actions = new Actions(driver);
          WebElement ele = driver.findElement(element);
          actions.moveToElement(ele);
          actions.click();
          actions.perform();
          return true;
        }
        catch(Exception e)
        {
            System.out.println("[ERROR] Failed to click '"+element+"'- "+e);
            return false;
        }
        
    }
    
    public boolean scrollToElement(By element)
    {
        try
        {
          JavascriptExecutor je = (JavascriptExecutor) driver;
          WebElement ele = driver.findElement(element);
          je.executeScript("arguments[0].scrollIntoView(true);",ele);
          return true;
        }
        catch(Exception e)
        {
           System.out.println("[ERROR] Failed to scroll to element '"+element+"'- "+e);
           return false;
        }
    }
   public void startIlabReporting()
    {
    
        String html = System.getProperty("user.dir")+"/src/ilab/Reports/iLabReport.html";
        extent = new ExtentReports(html,true);
        extent.addSystemInfo("Environment","iLab website")
                .addSystemInfo("Ran by","Chris");
        extent.loadConfig(new File(System.getProperty("user.dir")+"/src/ilab/Reports/extent-config.xml"));
    }
    public void shutDownBrowser()
    {
        extent.endTest(test);
        driver.quit();
        extent.flush();
        extent.close();
    }
}
